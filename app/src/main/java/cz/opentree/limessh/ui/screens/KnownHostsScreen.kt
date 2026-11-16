package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.domain.model.KnownHost
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnownHostsScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val repository = remember { ConnectionRepository(AppDatabase.getInstance(context)) }
    val hosts by repository.observeKnownHosts().collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    var pendingDelete by remember { mutableStateOf<KnownHost?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Known Hosts") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                },
            )
        },
    ) { padding ->
        if (hosts.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("No known hosts stored.", style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            LazyColumn(Modifier.fillMaxSize().padding(padding)) {
                items(hosts, key = { "${it.hostname}:${it.port}" }) { host ->
                    KnownHostRow(
                        host = host,
                        onDelete = { pendingDelete = host },
                    )
                    HorizontalDivider()
                }
            }
        }
    }

    // Confirm-delete dialog.
    pendingDelete?.let { host ->
        AlertDialog(
            onDismissRequest = { pendingDelete = null },
            title = { Text("Remove host fingerprint?") },
            text = {
                Text(
                    "Remove the stored key for ${host.hostname}:${host.port} (${host.keyType})?\n\n" +
                        "You will be prompted to trust the host again on next connection.",
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    val target = host
                    pendingDelete = null
                    scope.launch { repository.deleteKnownHost(target) }
                }) { Text("Remove", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = {
                TextButton(onClick = { pendingDelete = null }) { Text("Cancel") }
            },
        )
    }
}

@Composable
private fun KnownHostRow(host: KnownHost, onDelete: () -> Unit) {
    ListItem(
        headlineContent = { Text("${host.hostname}:${host.port}") },
        supportingContent = {
            Column {
                Text(host.keyType, style = MaterialTheme.typography.labelSmall)
                Text(
                    host.publicKey.take(48) + if (host.publicKey.length > 48) "…" else "",
                    fontFamily = FontFamily.Monospace,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        },
        trailingContent = {
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Remove", tint = MaterialTheme.colorScheme.error)
            }
        },
    )
}
