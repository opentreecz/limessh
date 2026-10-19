package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.domain.model.ForwardMode
import cz.opentree.limessh.domain.model.PortForward
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortForwardScreen(
    forwards: List<PortForward>,
    onSave: (PortForward) -> Unit,
    onDelete: (PortForward) -> Unit,
    onBack: () -> Unit,
) {
    var showDialog by remember { mutableStateOf(false) }
    var editing by remember { mutableStateOf<PortForward?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Port Forwards") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { editing = null; showDialog = true }) {
                Icon(Icons.Default.Add, "Add forward")
            }
        },
    ) { padding ->
        if (forwards.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("> No port forwards configured.", style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            LazyColumn(Modifier.padding(padding)) {
                items(forwards, key = { it.id }) { pf ->
                    val modeLabel = when (pf.mode) {
                        ForwardMode.LOCAL -> "L"
                        ForwardMode.REMOTE -> "R"
                        ForwardMode.SOCKS -> "D"
                    }
                    val desc = when (pf.mode) {
                        ForwardMode.LOCAL -> "localhost:${pf.localPort} -> ${pf.host}:${pf.remotePort}"
                        ForwardMode.REMOTE -> "${pf.host}:${pf.remotePort} -> localhost:${pf.localPort}"
                        ForwardMode.SOCKS -> "SOCKS5 on :${pf.localPort}"
                    }
                    ListItem(
                        headlineContent = { Text(pf.name.ifBlank { desc }) },
                        leadingContent = {
                            Badge(containerColor = MaterialTheme.colorScheme.primary) {
                                Text(modeLabel)
                            }
                        },
                        supportingContent = { Text(desc, style = MaterialTheme.typography.bodySmall) },
                        modifier = Modifier.clickable { editing = pf; showDialog = true },
                    )
                    HorizontalDivider()
                }
            }
        }

        if (showDialog) {
            PortForwardDialog(
                forward = editing,
                onSave = { onSave(it); showDialog = false },
                onDelete = editing?.let { pf -> { onDelete(pf); showDialog = false } },
                onDismiss = { showDialog = false },
            )
        }
    }
}

@Composable
fun PortForwardDialog(
    forward: PortForward?,
    onSave: (PortForward) -> Unit,
    onDelete: (() -> Unit)?,
    onDismiss: () -> Unit,
) {
    var name by remember { mutableStateOf(forward?.name ?: "") }
    var mode by remember { mutableStateOf(forward?.mode ?: ForwardMode.LOCAL) }
    var host by remember { mutableStateOf(forward?.host ?: "localhost") }
    var localPort by remember { mutableStateOf(forward?.localPort?.toString() ?: "") }
    var remotePort by remember { mutableStateOf(forward?.remotePort?.toString() ?: "") }
    var openInBrowser by remember { mutableStateOf(forward?.openInBrowser ?: false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (forward != null) "Edit Forward" else "New Forward") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") }, singleLine = true)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ForwardMode.entries.forEach { m ->
                        FilterChip(selected = mode == m, onClick = { mode = m }, label = { Text(m.name) })
                    }
                }
                if (mode != ForwardMode.SOCKS) {
                    OutlinedTextField(value = host, onValueChange = { host = it }, label = { Text("Host") }, singleLine = true)
                    OutlinedTextField(value = remotePort, onValueChange = { remotePort = it.filter { c -> c.isDigit() } },
                        label = { Text("Remote Port") }, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                }
                OutlinedTextField(value = localPort, onValueChange = { localPort = it.filter { c -> c.isDigit() } },
                    label = { Text("Local Port") }, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = openInBrowser, onCheckedChange = { openInBrowser = it })
                    Text("Open in browser after setup")
                }
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onSave(PortForward(
                    id = forward?.id ?: UUID.randomUUID(), name = name, mode = mode,
                    connectionId = forward?.connectionId, host = host,
                    localPort = localPort.toIntOrNull() ?: 0,
                    remotePort = remotePort.toIntOrNull() ?: 0,
                    openInBrowser = openInBrowser,
                ))
            }) { Text("Save") }
        },
        dismissButton = {
            Row {
                if (onDelete != null) TextButton(onClick = onDelete) { Text("Delete", color = MaterialTheme.colorScheme.error) }
                TextButton(onClick = onDismiss) { Text("Cancel") }
            }
        },
    )
}
