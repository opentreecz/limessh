package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cz.opentree.limessh.LimeApp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionListScreen(onOpenTerminal: (String) -> Unit, onBack: () -> Unit) {
    val app = LocalContext.current.applicationContext as LimeApp
    val sessions by app.sessionManager.activeSessions.collectAsState()
    val scope = rememberCoroutineScope()
    Scaffold(topBar = {
        TopAppBar(title = { Text("Active sessions (${sessions.size})") }, navigationIcon = {
            IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") }
        })
    }) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding)) {
            if (sessions.isEmpty()) item { ListItem(headlineContent = { Text("No active sessions") }) }
            items(sessions, key = { it.id }) { session ->
                ListItem(headlineContent = { Text(session.connectionName) },
                    supportingContent = { Text(if (session.engine.isConnected) "Connected" else "Disconnected") },
                    trailingContent = { TextButton(onClick = { scope.launch { app.sessionManager.disconnect(session.id) } }) { Text("Disconnect") } },
                    modifier = Modifier.clickable { onOpenTerminal(session.connectionId.toString()) })
            }
        }
    }
}
