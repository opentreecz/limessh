package cz.opentree.limessh.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.ssh.RemoteEntry
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

/** Actions exposed by a long-press context sheet on a remote entry. */
private enum class EntryAction { RENAME, DELETE }

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun SftpBrowserScreen(sessionId: String, onBack: () -> Unit) {
    val context = LocalContext.current
    val manager = (context.applicationContext as LimeApp).sessionManager
    val session = manager.getSession(UUID.fromString(sessionId))
    val scope = rememberCoroutineScope()

    var path by remember { mutableStateOf(".") }
    var entries by remember { mutableStateOf(emptyList<RemoteEntry>()) }
    var status by remember { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var refresh by remember { mutableIntStateOf(0) }

    // Download
    var download by remember { mutableStateOf<RemoteEntry?>(null) }
    // Upload
    var uploadName by remember { mutableStateOf<String?>(null) }
    // Mkdir
    var showMkdirDialog by remember { mutableStateOf(false) }
    // Rename
    var renameTarget by remember { mutableStateOf<RemoteEntry?>(null) }
    // Delete
    var deleteTarget by remember { mutableStateOf<RemoteEntry?>(null) }
    // Context sheet
    var sheetEntry by remember { mutableStateOf<RemoteEntry?>(null) }

    suspend fun op(block: suspend () -> Unit) {
        busy = true; status = ""
        try { block(); refresh++ }
        catch (e: CancellationException) { throw e }
        catch (e: Exception) { status = e.message ?: "Operation failed" }
        finally { busy = false }
    }

    val saveFile = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("application/octet-stream")) { uri ->
        val file = download
        if (uri != null && file != null && session != null) scope.launch {
            op { withContext(Dispatchers.IO) {
                context.contentResolver.openOutputStream(uri)?.use { session.engine.download(file.path, it) }
                    ?: error("Cannot open destination")
            } }
            status = "Downloaded ${file.name}"
        }
    }
    val openFile = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        val name = uploadName
        if (uri != null && name != null && session != null) scope.launch {
            op { withContext(Dispatchers.IO) {
                context.contentResolver.openInputStream(uri)?.use { session.engine.upload("${path.trimEnd('/')}/$name", it) }
                    ?: error("Cannot open source")
            } }
            status = "Uploaded $name"
        }
    }

    LaunchedEffect(path, refresh) {
        if (session == null) { status = "Session has ended"; return@LaunchedEffect }
        busy = true
        try {
            val canonical = session.engine.canonicalPath(path)
            entries = session.engine.listFiles(canonical)
            if (path != canonical) path = canonical
        } catch (e: CancellationException) { throw e }
        catch (e: Exception) { status = e.message ?: "Cannot list directory" }
        finally { busy = false }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("SFTP") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") }
                },
            )
        },
        floatingActionButton = {
            if (session != null) FloatingActionButton(onClick = { showMkdirDialog = true }) {
                Icon(Icons.Default.CreateNewFolder, contentDescription = "New folder")
            }
        },
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(horizontal = 12.dp)) {
            Text(path, style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(vertical = 4.dp))
            Row {
                TextButton(enabled = !busy && session != null,
                    onClick = { path = path.trimEnd('/').substringBeforeLast('/', "").ifBlank { "/" } }) { Text("Parent") }
                TextButton(enabled = !busy && session != null, onClick = { refresh++ }) { Text("Refresh") }
                TextButton(enabled = !busy && session != null, onClick = { uploadName = "" }) { Text("Upload") }
            }
            if (busy) LinearProgressIndicator(Modifier.fillMaxWidth())
            if (status.isNotBlank()) Text(status, style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 4.dp))
            LazyColumn {
                items(entries, key = { it.path }) { entry ->
                    ListItem(
                        headlineContent = { Text(entry.name) },
                        supportingContent = {
                            Text(if (entry.directory) "Directory" else "${entry.size} bytes")
                        },
                        trailingContent = if (!entry.directory) null else ({
                            Icon(Icons.Default.ChevronRight, contentDescription = null)
                        }),
                        modifier = Modifier.combinedClickable(
                            enabled = !busy && session != null,
                            onClick = {
                                if (entry.directory) path = entry.path
                                else { download = entry; saveFile.launch(entry.name) }
                            },
                            onLongClick = { sheetEntry = entry },
                        ),
                    )
                    HorizontalDivider()
                }
            }
        }
    }

    // Context bottom sheet (rename / delete) triggered by long-press
    sheetEntry?.let { entry ->
        ModalBottomSheet(onDismissRequest = { sheetEntry = null }) {
            Text(entry.name, style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
            HorizontalDivider()
            ListItem(
                headlineContent = { Text("Rename") },
                leadingContent = { Icon(Icons.Default.Edit, contentDescription = null) },
                modifier = Modifier.clickable { renameTarget = entry; sheetEntry = null },
            )
            ListItem(
                headlineContent = { Text("Delete", color = MaterialTheme.colorScheme.error) },
                leadingContent = { Icon(Icons.Default.Delete, contentDescription = null,
                    tint = MaterialTheme.colorScheme.error) },
                modifier = Modifier.clickable { deleteTarget = entry; sheetEntry = null },
            )
            Spacer(Modifier.height(24.dp))
        }
    }

    // Upload — enter remote filename dialog
    if (uploadName == "") {
        var name by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { uploadName = null },
            title = { Text("Remote filename") },
            text = {
                OutlinedTextField(value = name, onValueChange = { name = it }, singleLine = true,
                    supportingText = { Text("Existing files are not overwritten.") })
            },
            confirmButton = {
                TextButton(
                    enabled = name.isNotBlank() && name !in listOf(".", "..") && '/' !in name && '\u0000' !in name,
                    onClick = { uploadName = name; openFile.launch(arrayOf("*/*")) },
                ) { Text("Choose file") }
            },
            dismissButton = { TextButton(onClick = { uploadName = null }) { Text("Cancel") } },
        )
    }

    // Mkdir dialog
    if (showMkdirDialog) {
        var name by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showMkdirDialog = false },
            title = { Text("New folder") },
            text = {
                OutlinedTextField(value = name, onValueChange = { name = it }, singleLine = true,
                    label = { Text("Folder name") })
            },
            confirmButton = {
                TextButton(
                    enabled = name.isNotBlank() && name !in listOf(".", "..") && '/' !in name,
                    onClick = {
                        val newDir = "${path.trimEnd('/')}/$name"
                        showMkdirDialog = false
                        scope.launch { session?.let { op { it.engine.mkdir(newDir) } } }
                    },
                ) { Text("Create") }
            },
            dismissButton = { TextButton(onClick = { showMkdirDialog = false }) { Text("Cancel") } },
        )
    }

    // Rename dialog
    renameTarget?.let { entry ->
        var newName by remember(entry) { mutableStateOf(entry.name) }
        AlertDialog(
            onDismissRequest = { renameTarget = null },
            title = { Text("Rename") },
            text = {
                OutlinedTextField(value = newName, onValueChange = { newName = it }, singleLine = true,
                    label = { Text("New name") })
            },
            confirmButton = {
                TextButton(
                    enabled = newName.isNotBlank() && newName != entry.name && '/' !in newName,
                    onClick = {
                        val newPath = "${path.trimEnd('/')}/$newName"
                        renameTarget = null
                        scope.launch { session?.let { op { it.engine.rename(entry.path, newPath) } } }
                    },
                ) { Text("Rename") }
            },
            dismissButton = { TextButton(onClick = { renameTarget = null }) { Text("Cancel") } },
        )
    }

    // Delete confirmation dialog
    deleteTarget?.let { entry ->
        AlertDialog(
            onDismissRequest = { deleteTarget = null },
            title = { Text("Delete ${entry.name}?") },
            text = {
                Text(
                    if (entry.directory) "This will remove the empty directory. Non-empty directories cannot be deleted here."
                    else "This will permanently delete the file.",
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    deleteTarget = null
                    scope.launch {
                        session?.let {
                            op {
                                if (entry.directory) it.engine.rmdir(entry.path)
                                else it.engine.rm(entry.path)
                            }
                        }
                    }
                }) { Text("Delete", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = { TextButton(onClick = { deleteTarget = null }) { Text("Cancel") } },
        )
    }
}
