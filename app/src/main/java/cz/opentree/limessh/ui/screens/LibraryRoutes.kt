package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.domain.model.Snippet
import kotlinx.coroutines.launch
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState

@Composable
fun SnippetLibraryRoute(onBack: () -> Unit) {
    val context = LocalContext.current
    val repository = remember { ConnectionRepository(AppDatabase.getInstance(context)) }
    val snippets by repository.observeSnippets().collectAsState(initial = emptyList())
    val connections by repository.observeConnections().collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    var editing by remember { mutableStateOf<Snippet?>(null) }
    var error by remember { mutableStateOf<String?>(null) }
    SnippetListScreen(snippets = snippets, onAdd = { editing = Snippet() }, onEdit = { editing = it }, onBack = onBack)
    editing?.let { snippet ->
        var name by remember(snippet.id) { mutableStateOf(snippet.name) }
        var content by remember(snippet.id) { mutableStateOf(snippet.content) }
        var autoRun by remember(snippet.id) { mutableStateOf(snippet.runOnConnect) }
        var connectionId by remember(snippet.id) { mutableStateOf(snippet.connectionId) }
        AlertDialog(onDismissRequest = { editing = null }, title = { Text("Saved command") },
            text = { Column {
                OutlinedTextField(name, { name = it }, label = { Text("Name") })
                OutlinedTextField(content, { content = it }, label = { Text("Command / script") }, minLines = 3)
                Row(Modifier.horizontalScroll(rememberScrollState())) {
                    connections.forEach { connection -> FilterChip(selected = connectionId == connection.id,
                        onClick = { connectionId = connection.id }, label = { Text(connection.nickname.ifBlank { connection.address }) }) }
                }
                Row {
                    Checkbox(checked = autoRun, enabled = connectionId != null, onCheckedChange = { autoRun = it })
                    Text("Run once on login to selected connection")
                }
                error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            } },
            confirmButton = { TextButton(enabled = name.isNotBlank() && content.isNotBlank(), onClick = {
                scope.launch {
                    try { repository.saveSnippet(snippet.copy(name = name, content = content, runOnConnect = autoRun && connectionId != null, connectionId = connectionId)); editing = null }
                    catch (e: Exception) { error = e.message }
                }
            }) { Text("Save") } },
            dismissButton = { Row {
                TextButton(onClick = { scope.launch { repository.deleteSnippet(snippet); editing = null } }) { Text("Delete") }
                TextButton(onClick = { editing = null }) { Text("Cancel") }
            } })
    }
}

@Composable
fun PortForwardRoute(onBack: () -> Unit) {
    val context = LocalContext.current
    val repository = remember { ConnectionRepository(AppDatabase.getInstance(context)) }
    val forwards by repository.observePortForwards().collectAsState(initial = emptyList())
    val connections by repository.observeConnections().collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    var error by remember { mutableStateOf<String?>(null) }
    PortForwardScreen(forwards = forwards, connections = connections,
        onSave = { scope.launch { try { repository.savePortForward(it) } catch (e: Exception) { error = e.message } } },
        onDelete = { scope.launch { try { repository.deletePortForward(it) } catch (e: Exception) { error = e.message } } },
        onBack = onBack)
    error?.let { message -> AlertDialog(onDismissRequest = { error = null }, title = { Text("Port forward") },
        text = { Text(message) }, confirmButton = { TextButton(onClick = { error = null }) { Text("OK") } }) }
}
