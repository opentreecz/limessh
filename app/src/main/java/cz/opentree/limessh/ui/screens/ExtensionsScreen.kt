package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.plugin.builtin.*
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtensionsScreen(initialSessionId: String?, onBack: () -> Unit) {
    val app = LocalContext.current.applicationContext as LimeApp
    val scope = rememberCoroutineScope()
    val sessions by app.sessionManager.activeSessions.collectAsState()
    val repository = remember { ConnectionRepository(AppDatabase.getInstance(app)) }
    val connections by repository.observeConnections().collectAsState(initial = emptyList())
    val snippets by repository.observeSnippets().collectAsState(initial = emptyList())
    val groups by repository.observeGroups().collectAsState(initial = emptyList())
    var groupTarget by remember { mutableStateOf<UUID?>(null) }
    var pendingGroup by remember { mutableStateOf<UUID?>(null) }
    var selected by remember { mutableStateOf(initialSessionId) }
    val session = sessions.firstOrNull { it.id.toString() == selected }
    var output by remember { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var monitorEnabled by remember { mutableStateOf(false) }
    var country by remember { mutableStateOf("cz") }
    var pendingCommand by remember { mutableStateOf<String?>(null) }
    var knockConnection by remember { mutableStateOf<String?>(null) }
    var knockSpec by remember { mutableStateOf("tcp:7000,pause:200,tcp:8000,pause:200,tcp:9000") }
    var knockBusy by remember { mutableStateOf(false) }
    val log by app.auditLog.entriesFlow.collectAsState()

    fun execute(command: String, group: UUID? = null) {
        val targets = if (group == null) listOfNotNull(session) else {
            val ids = connections.filter { it.groupId == group }.map { it.id }.toSet()
            sessions.filter { it.connectionId in ids }
        }
        if (targets.isEmpty()) { output = "No active sessions in this target"; return }
        busy = true
        scope.launch {
            try {
                val text = StringBuilder()
                for (current in targets) {
                    val result = app.sessionManager.execute(current.id, command)
                    text.append("${current.connectionName} · Exit ${result.exitCode}\n${result.stdout.take(65536)}\n${result.stderr.take(65536)}\n")
                }
                output = text.toString()
            } catch (e: CancellationException) { throw e }
            catch (e: Exception) { output = e.message ?: "Extension failed" }
            finally { busy = false }
        }
    }

    Scaffold(topBar = { TopAppBar(title = { Text("Extensions") }, navigationIcon = {
        IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") }
    }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Active session", style = MaterialTheme.typography.titleMedium)
            if (sessions.isEmpty()) Text("Connect to a server to use remote extensions.")
            Row(Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                sessions.forEach { item -> FilterChip(selected = session?.id == item.id,
                    enabled = !busy,
                    onClick = { selected = item.id.toString(); monitorEnabled = false; output = "" },
                    label = { Text(item.connectionName) }) }
            }
            val enabled = session != null && !busy
            Button(enabled = session != null, onClick = { monitorEnabled = !monitorEnabled }) {
                Text(if (monitorEnabled) "Stop performance monitor" else "Start performance monitor")
            }
            if (monitorEnabled && session != null) key(session.id) { PerformancePanel(session.engine) }
            OutlinedButton(enabled = enabled, onClick = { execute(ExtensionCommands.EXAMPLE) }) { Text("Example / API diagnostic") }
            OutlinedButton(enabled = enabled, onClick = { execute(ExtensionCommands.NVIDIA) }) { Text("NVIDIA GPU monitor") }
            OutlinedButton(enabled = enabled, onClick = { execute(ExtensionCommands.NAS) }) { Text("FreeNAS / TrueNAS ZFS status") }
            Text("These adapters require nvidia-smi or ZFS tools on the remote host.", style = MaterialTheme.typography.bodySmall)
            HorizontalDivider()
            Text("Openpyn / NordVPN controller", style = MaterialTheme.typography.titleMedium)
            OutlinedTextField(country, { country = it }, label = { Text("Country code") }, singleLine = true)
            Row {
                TextButton(enabled = enabled, onClick = { execute(ExtensionCommands.VPN_STATUS) }) { Text("Status") }
                TextButton(enabled = enabled && country.matches(Regex("[a-zA-Z]{2}")), onClick = {
                    pendingGroup = null; pendingCommand = ExtensionCommands.vpnConnect(country)
                }) { Text("Connect") }
                TextButton(enabled = enabled, onClick = { pendingGroup = null; pendingCommand = ExtensionCommands.VPN_DISCONNECT }) { Text("Disconnect") }
            }
            Text("Requires openpyn and configured non-interactive sudo on the remote host.", style = MaterialTheme.typography.bodySmall)
            if (busy) LinearProgressIndicator(Modifier.fillMaxWidth())
            if (output.isNotBlank()) SelectionContainer { Text(output) }
            HorizontalDivider()
            Text("Saved commands / GroupSnippet workflow", style = MaterialTheme.typography.titleMedium)
            Row(Modifier.horizontalScroll(rememberScrollState())) {
                FilterChip(selected = groupTarget == null, onClick = { groupTarget = null }, label = { Text("Selected session") })
                groups.forEach { group -> FilterChip(selected = groupTarget == group.id,
                    onClick = { groupTarget = group.id }, label = { Text("Group: ${group.name}") }) }
            }
            snippets.forEach { snippet ->
                OutlinedButton(enabled = !busy && (session != null || groupTarget != null), onClick = {
                    pendingGroup = groupTarget; pendingCommand = snippet.content
                }) { Text(snippet.name) }
            }
            Text("Group commands run sequentially on already-open sessions in that group. Manage the library from the main menu.", style = MaterialTheme.typography.bodySmall)
            HorizontalDivider()
            Text("Port knocker", style = MaterialTheme.typography.titleMedium)
            Row(Modifier.horizontalScroll(rememberScrollState())) {
                connections.forEach { connection -> FilterChip(selected = knockConnection == connection.id.toString(),
                    enabled = !knockBusy,
                    onClick = { knockConnection = connection.id.toString() },
                    label = { Text(connection.nickname.ifBlank { connection.address }) }) }
            }
            OutlinedTextField(knockSpec, { knockSpec = it }, label = { Text("tcp:port,udp:port,pause:ms") }, modifier = Modifier.fillMaxWidth())
            Button(enabled = knockConnection != null && !knockBusy, onClick = {
                val connection = connections.firstOrNull { it.id.toString() == knockConnection } ?: return@Button
                knockBusy = true
                scope.launch {
                    try {
                        val steps = KnockSequence.parse(knockSpec)
                        PortKnocker().knock(connection.address, steps).getOrThrow()
                        app.auditLog.log("limessh", AuditAction.KNOCK_SEQUENCE, connection.id)
                        output = "Knock sequence sent. This does not confirm the firewall opened."
                    } catch (e: CancellationException) { throw e }
                    catch (e: Exception) { output = e.message ?: "Knock failed" }
                    finally { knockBusy = false }
                }
            }) { Text(if (knockBusy) "Knocking…" else "Send knock sequence") }
            HorizontalDivider()
            Text("Plugin audit log (this app process)", style = MaterialTheme.typography.titleMedium)
            log.takeLast(100).asReversed().forEach { entry -> Text(app.auditLog.formatEntry(entry), style = MaterialTheme.typography.bodySmall) }
            TextButton(onClick = { app.auditLog.clear() }) { Text("Clear log") }
            HorizontalDivider()
            Text("Compatibility", style = MaterialTheme.typography.titleMedium)
            Text("Built-in adapters implement the researched workflows. Third-party plugin APKs are not drop-in compatible. A new Tasker/Locale action is available in Settings; runtime interoperability remains unverified. Cloud services and unknown-license forks require separate work.")
        }
    }
    pendingCommand?.let { command ->
        AlertDialog(onDismissRequest = { pendingCommand = null }, title = { Text("Run remote command?") },
            text = { Text("${if (pendingGroup == null) session?.connectionName.orEmpty() else "Active sessions in group: " + groups.firstOrNull { it.id == pendingGroup }?.name}\n\n$command") },
            confirmButton = { TextButton(enabled = !busy && (session != null || pendingGroup != null), onClick = {
                pendingCommand = null; execute(command, pendingGroup)
            }) { Text("Run") } },
            dismissButton = { TextButton(onClick = { pendingCommand = null }) { Text("Cancel") } })
    }
}

@Composable
private fun PerformancePanel(engine: cz.opentree.limessh.ssh.SshEngine) {
    val monitor = remember(engine) { PerformanceMonitor(engine) }
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(monitor, lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) monitor.start()
            if (event == Lifecycle.Event.ON_STOP) monitor.stop()
        }
        lifecycle.addObserver(observer)
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) monitor.start()
        onDispose { lifecycle.removeObserver(observer); monitor.stop() }
    }
    val cpu by monitor.cpuUsage.collectAsState()
    val ram by monitor.freeRam.collectAsState()
    val load by monitor.loadAverage.collectAsState()
    val disk by monitor.diskUsage.collectAsState()
    val network by monitor.networkUsage.collectAsState()
    val temperature by monitor.temperature.collectAsState()
    Text("CPU $cpu\nRAM $ram\nLoad $load\nDisk $disk\nNetwork $network\nTemperature $temperature")
}
