package cz.opentree.limessh.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.opentree.limessh.ui.theme.LimeDarkBg
import cz.opentree.limessh.ui.theme.LimeTerminalGreen
import cz.opentree.limessh.ui.theme.TerminalThemes
import cz.opentree.limessh.data.local.UnlockMethod
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import cz.opentree.limessh.ui.viewmodel.SettingsViewModel
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.data.backup.OpenSshExporter
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.plugin.automation.AutomationGrants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.ui.text.input.PasswordVisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBack: () -> Unit,
    onOpenKnownHosts: () -> Unit = {},
    viewModel: SettingsViewModel = viewModel(),
) {
    val context = LocalContext.current
    val app = context.applicationContext as LimeApp
    val settings by app.settings.preferences.collectAsState()
    val scope = rememberCoroutineScope()
    var picker by remember { mutableStateOf<String?>(null) }
    var showBackupDialog by remember { mutableStateOf(false) }
    var showRestoreDialog by remember { mutableStateOf(false) }
    var backupPassword by remember { mutableStateOf("") }
    var statusMessage by remember { mutableStateOf<String?>(null) }
    val exportConfig = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("text/plain")) { uri ->
        if (uri != null) scope.launch {
            statusMessage = try {
                withContext(Dispatchers.IO) {
                    val repository = ConnectionRepository(AppDatabase.getInstance(context))
                    val text = OpenSshExporter.export(repository.observeConnections().first(), repository.observeIdentities().first())
                    context.contentResolver.openOutputStream(uri)?.bufferedWriter()?.use { it.write(text) }
                        ?: error("Cannot open destination")
                }
                "OpenSSH configuration exported (credentials excluded)."
            } catch (e: Exception) { "Export failed: ${e.message}" }
        }
    }

    val createFileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("application/octet-stream"),
    ) { uri ->
        if (uri != null) {
            viewModel.exportBackup(uri, backupPassword) { result ->
                statusMessage = result
            }
        }
    }

    val openFileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri ->
        if (uri != null) {
            viewModel.pendingRestoreUri = uri
            showRestoreDialog = true
        }
    }

    val openMetadataFileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri ->
        if (uri != null) {
            viewModel.importMetadata(uri) { result ->
                statusMessage = result
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LimeDarkBg,
                    titleContentColor = LimeTerminalGreen,
                    navigationIconContentColor = LimeTerminalGreen,
                ),
            )
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            item { SectionHeader("Terminal") }
            item {
                SettingsItem(
                    icon = Icons.Default.TextFields,
                    title = "Font size",
                    subtitle = "${settings.fontSize} sp",
                    onClick = { picker = "font" },
                )
            }
            item {
                SettingsItem(
                    icon = Icons.Default.Palette,
                    title = "Color scheme",
                    subtitle = TerminalThemes.byId(settings.terminalThemeId).name +
                        if (settings.terminalThemeId == TerminalThemes.DEFAULT_ID) " (default)" else "",
                    onClick = { picker = "theme" },
                )
            }
            item {
                SettingsItem(
                    icon = Icons.Default.ViewList,
                    title = "Scrollback lines",
                    subtitle = "${settings.scrollback} lines",
                    onClick = { picker = "scrollback" },
                )
            }
            item { HorizontalDivider() }
            item { SectionHeader("Security") }
            item {
                SettingsItem(
                    icon = Icons.Default.Lock,
                    title = "Inactivity lock timeout",
                    subtitle = if (settings.lockTimeoutSeconds == 0) "Disabled" else "${settings.lockTimeoutSeconds} seconds; SSH sessions continue",
                    onClick = { picker = "lock" },
                )
            }
            item {
                SettingsItem(
                    icon = Icons.Default.Fingerprint,
                    title = "Unlock method",
                    subtitle = when (settings.unlockMethod) {
                        UnlockMethod.DEVICE_CREDENTIAL -> "Screen lock PIN, pattern or password"
                        UnlockMethod.BIOMETRIC_OR_CREDENTIAL -> "Fingerprint or face, with screen-lock fallback"
                        UnlockMethod.BIOMETRIC_ONLY -> "Fingerprint or face only"
                    },
                    onClick = { picker = "unlock" },
                )
            }
            item {
                SettingsItem(
                    icon = Icons.Default.Lock,
                    title = "Lock now",
                    subtitle = if (settings.lockTimeoutSeconds == 0) "Enable an inactivity timeout first" else "Require unlock immediately",
                    onClick = {
                        statusMessage = if (app.settings.lockNow()) null else "Choose an inactivity lock timeout first."
                    },
                )
            }
            item {
                SettingsItem(
                    icon = Icons.Default.Security,
                    title = "Known hosts",
                    subtitle = "View and remove trusted SSH host fingerprints",
                    onClick = onOpenKnownHosts,
                )
            }
            item { HorizontalDivider() }
            item { SectionHeader("Backup & restore") }
            item {
                SettingsItem(
                    icon = Icons.Default.Upload,
                    title = "Export backup",
                    subtitle = "AES-256-GCM configuration backup; passwords and private keys excluded",
                    onClick = { showBackupDialog = true },
                )
            }
            item {
                SettingsItem(
                    icon = Icons.Default.Download,
                    title = "Restore backup",
                    subtitle = "Import a LimeSSH encrypted backup",
                    onClick = { openFileLauncher.launch("application/octet-stream") },
                )
            }
            item { HorizontalDivider() }
            item { SectionHeader("Extensions & automation") }
            item {
                SettingsItem(icon = Icons.Default.Upload, title = "Export OpenSSH config",
                    subtitle = "Connection metadata only; no credentials", onClick = { exportConfig.launch("limessh_config") })
            }
            item {
                SettingsItem(icon = Icons.Default.Extension, title = "Configure Tasker action",
                    subtitle = "Run a saved command on an already-open session", onClick = {
                        context.startActivity(Intent(context, cz.opentree.limessh.plugin.automation.TaskerConfigActivity::class.java))
                    })
            }
            item {
                SettingsItem(icon = Icons.Default.Lock, title = "Revoke Tasker grants",
                    subtitle = "Disable all previously configured automation actions", onClick = {
                        scope.launch(Dispatchers.IO) {
                            AutomationGrants(context).revokeAll()
                            withContext(Dispatchers.Main) { statusMessage = "All automation grants revoked." }
                        }
                    })
            }
            item { HorizontalDivider() }
            item { SectionHeader("Migration") }
            item {
                SettingsItem(
                    icon = Icons.Default.SwapHoriz,
                    title = "Import connection metadata",
                    subtitle = "Import supported JSON metadata; passwords and private keys excluded",
                    onClick = { openMetadataFileLauncher.launch("application/json") },
                )
            }
            item { HorizontalDivider() }
            item { SectionHeader("About") }
            item {
                SettingsItem(
                    icon = Icons.Default.Info,
                    title = "LimeSSH v0.1.0-dev",
                    subtitle = "Open-source SSH client for Android",
                    onClick = { },
                )
            }
            item {
                SettingsItem(
                    icon = Icons.Default.OpenInNew,
                    title = "Source code",
                    subtitle = "github.com/opentreecz/limessh",
                    onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/opentreecz/limessh"),
                        )
                        context.startActivity(intent)
                    },
                )
            }
            // Debug: show last crash log if one exists.
            item {
                val crashFile = remember {
                    (context.applicationContext as cz.opentree.limessh.LimeApp)
                        .getExternalFilesDir(null)
                        ?.resolve(cz.opentree.limessh.LimeApp.CRASH_LOG_FILENAME)
                        ?: (context.applicationContext as cz.opentree.limessh.LimeApp)
                        .filesDir.resolve(cz.opentree.limessh.LimeApp.CRASH_LOG_FILENAME)
                }
                if (crashFile.exists()) {
                    SettingsItem(
                        icon = Icons.Default.Warning,
                        title = "Last crash log (debug)",
                        subtitle = "Tap to view — delete file to dismiss",
                        onClick = { statusMessage = runCatching { crashFile.readText().take(1000) }.getOrElse { "Cannot read: ${it.message}" } },
                    )
                }
            }
            statusMessage?.let { msg ->
                item {
                    Spacer(Modifier.height(16.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                    ) {
                        Text(
                            text = msg,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }
            }
            item { Spacer(Modifier.height(32.dp)) }
        }
    }

    if (showBackupDialog) {
        var pw by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showBackupDialog = false },
            title = { Text("Export backup") },
            text = {
                Column {
                    Text("Set a strong password. This exports configuration and identity metadata, not passwords or private keys.")
                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(
                        value = pw,
                        onValueChange = { pw = it },
                        label = { Text("Backup password") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        backupPassword = pw
                        showBackupDialog = false
                        createFileLauncher.launch("limessh_backup.lime")
                    },
                    enabled = pw.length >= 8,
                ) { Text("Export") }
            },
            dismissButton = {
                TextButton(onClick = { showBackupDialog = false }) { Text("Cancel") }
            },
        )
    }

    if (showRestoreDialog) {
        var pw by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showRestoreDialog = false },
            title = { Text("Restore backup") },
            text = {
                Column {
                    Text("Restore merges configuration by ID and may replace matching records and host trust. Passwords and private keys are not restored. Enter the backup password.")
                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(
                        value = pw,
                        onValueChange = { pw = it },
                        label = { Text("Backup password") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showRestoreDialog = false
                        viewModel.pendingRestoreUri?.let { uri ->
                            viewModel.restoreBackup(uri, pw) { result ->
                                statusMessage = result
                            }
                        }
                    },
                ) { Text("Restore") }
            },
            dismissButton = {
                TextButton(onClick = { showRestoreDialog = false }) { Text("Cancel") }
            },
        )
    }
    if (picker == "theme") {
        AlertDialog(
            onDismissRequest = { picker = null },
            title = { Text("Terminal color scheme") },
            text = {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    TerminalThemes.all.forEach { theme ->
                        val selected = theme.id == settings.terminalThemeId
                        Row(
                            Modifier.fillMaxWidth().clickable {
                                app.settings.setTerminalTheme(theme.id)
                                picker = null
                            }.padding(vertical = 8.dp),
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                        ) {
                            RadioButton(selected = selected, onClick = null)
                            Spacer(Modifier.width(12.dp))
                            Column(Modifier.weight(1f)) {
                                Text(theme.name + if (theme.id == TerminalThemes.DEFAULT_ID) " (default)" else "")
                                Row(Modifier.padding(top = 4.dp)) {
                                    Box(
                                        Modifier.background(theme.background).padding(horizontal = 8.dp, vertical = 2.dp),
                                    ) { Text("user@host:~$", color = theme.foreground, fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace) }
                                    Spacer(Modifier.width(8.dp))
                                    theme.ansi.take(8).forEach { color ->
                                        Box(Modifier.size(12.dp).background(color))
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = { TextButton(onClick = { picker = null }) { Text("Close") } },
        )
    }
    if (picker == "unlock") {
        val options = listOf(
            UnlockMethod.BIOMETRIC_OR_CREDENTIAL to "Fingerprint or face, with screen-lock fallback",
            UnlockMethod.DEVICE_CREDENTIAL to "Screen lock PIN, pattern or password",
            UnlockMethod.BIOMETRIC_ONLY to "Fingerprint or face only",
        )
        AlertDialog(
            onDismissRequest = { picker = null },
            title = { Text("Unlock method") },
            text = {
                Column {
                    options.forEach { (method, label) ->
                        Row(
                            Modifier.fillMaxWidth().clickable { app.settings.setUnlockMethod(method); picker = null }.padding(vertical = 10.dp),
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                        ) {
                            RadioButton(selected = settings.unlockMethod == method, onClick = null)
                            Spacer(Modifier.width(12.dp))
                            Text(label)
                        }
                    }
                    Text(
                        "If no fingerprint or face is enrolled, the screen lock is used instead so limessh cannot lock you out. " +
                            "Android 8–10 shows the screen-lock prompt as a second step.",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 8.dp),
                    )
                }
            },
            confirmButton = { TextButton(onClick = { picker = null }) { Text("Close") } },
        )
    }
    picker?.takeIf { it == "font" || it == "scrollback" || it == "lock" }?.let { kind ->
        val options = when (kind) {
            "font" -> listOf(10, 12, 13, 14, 16, 18, 20, 24, 28)
            "scrollback" -> listOf(0, 1000, 5000, 10000)
            else -> listOf(0, 30, 60, 300, 900)
        }
        AlertDialog(onDismissRequest = { picker = null }, title = { Text("Choose $kind setting") },
            text = { Column { options.forEach { value ->
                TextButton(onClick = {
                    when (kind) {
                        "font" -> app.settings.setFontSize(value)
                        "scrollback" -> app.settings.setScrollback(value)
                        else -> {
                            val keyguard = context.getSystemService(android.content.Context.KEYGUARD_SERVICE) as android.app.KeyguardManager
                            if (value == 0 || keyguard.isDeviceSecure) app.settings.setLockTimeout(value)
                            else statusMessage = "Set an Android screen lock before enabling inactivity lock."
                        }
                    }
                    picker = null
                }) { Text(if (value == 0) "Disabled" else value.toString()) }
            } } }, confirmButton = { TextButton(onClick = { picker = null }) { Text("Cancel") } })
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
    )
}

@Composable
private fun SettingsItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
) {
    ListItem(
        headlineContent = { Text(title) },
        supportingContent = {
            Text(subtitle, style = MaterialTheme.typography.bodySmall)
        },
        leadingContent = {
            Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        },
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
    )
}
