package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.opentree.limessh.R
import cz.opentree.limessh.data.local.entity.ConnectionEntity
import cz.opentree.limessh.ui.theme.LimeDarkBg
import cz.opentree.limessh.ui.theme.LimeGreen
import cz.opentree.limessh.ui.theme.LimeTerminalGreen
import cz.opentree.limessh.ui.viewmodel.ConnectionListViewModel
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import cz.opentree.limessh.ui.MainActivity

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ConnectionListScreen(
    onConnect: (String) -> Unit,
    onNewConnection: () -> Unit,
    onEditConnection: (String) -> Unit,
    onOpenSettings: () -> Unit,
    onOpenIdentities: () -> Unit,
    onOpenSessions: () -> Unit,
    onOpenExtensions: () -> Unit,
    onOpenSnippets: () -> Unit,
    onOpenForwards: () -> Unit,
    onOpenGroups: () -> Unit,
    viewModel: ConnectionListViewModel = viewModel(),
) {
    val connections by viewModel.connections.collectAsState(initial = emptyList())
    val context = LocalContext.current
    var contextMenuTarget by remember { mutableStateOf<ConnectionEntity?>(null) }
    var menuOpen by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("LimeSSH") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LimeDarkBg,
                    titleContentColor = LimeTerminalGreen,
                    actionIconContentColor = LimeTerminalGreen,
                ),
                actions = {
                    Box {
                        IconButton(onClick = { menuOpen = true }) { Icon(Icons.Default.MoreVert, "Tools") }
                        DropdownMenu(expanded = menuOpen, onDismissRequest = { menuOpen = false }) {
                            listOf("Extensions" to onOpenExtensions, "Snippets" to onOpenSnippets,
                                "Port forwards" to onOpenForwards, "Groups" to onOpenGroups).forEach { (label, action) ->
                                DropdownMenuItem(text = { Text(label) }, onClick = { menuOpen = false; action() })
                            }
                        }
                    }
                    IconButton(onClick = onOpenSessions) {
                        Icon(Icons.Default.List, contentDescription = "Active sessions")
                    }
                    IconButton(onClick = onOpenIdentities) {
                        Icon(Icons.Default.Key, contentDescription = "Identities / keys")
                    }
                    IconButton(onClick = onOpenSettings) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNewConnection,
                containerColor = LimeGreen,
                contentColor = LimeDarkBg,
            ) {
                Icon(Icons.Default.Add, contentDescription = stringResource(R.string.new_connection))
            }
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        if (connections.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "> LimeSSH v0.1.0-dev",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "> No connections configured.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        text = "> Tap + to add your first server.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    OutlinedButton(onClick = onNewConnection) {
                        Icon(Icons.Default.Add, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Add connection")
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
            ) {
                items(connections, key = { it.id }) { connection ->
                    ListItem(
                        headlineContent = {
                            Text(
                                text = connection.nickname.ifBlank { connection.address },
                                style = MaterialTheme.typography.titleMedium,
                            )
                        },
                        supportingContent = {
                            Text(
                                text = "${connection.address}:${connection.port}  [${connection.type}]",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        },
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Default.Terminal,
                                contentDescription = null,
                                tint = LimeTerminalGreen,
                            )
                        },
                        trailingContent = {
                            IconButton(onClick = { contextMenuTarget = connection }) {
                                Icon(
                                    Icons.Default.MoreVert,
                                    contentDescription = "More options",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                )
                            }
                        },
                        modifier = Modifier.combinedClickable(
                            onClick = { onConnect(connection.id) },
                            onLongClick = { contextMenuTarget = connection },
                        ),
                    )
                    HorizontalDivider(thickness = 0.5.dp)
                }
            }
        }
    }

    // Context menu for connection
    contextMenuTarget?.let { target ->
        AlertDialog(
            onDismissRequest = { contextMenuTarget = null },
            title = {
                Text(target.nickname.ifBlank { target.address })
            },
            text = {
                Column {
                    TextButton(
                        onClick = {
                            contextMenuTarget = null
                            onConnect(target.id)
                        },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Connect")
                    }
                    TextButton(
                        onClick = {
                            contextMenuTarget = null
                            onEditConnection(target.id)
                        },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Icon(Icons.Default.Edit, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Edit")
                    }
                    TextButton(
                        onClick = {
                            val intent = Intent(context, MainActivity::class.java).setAction(Intent.ACTION_VIEW)
                                .putExtra("connection_id", target.id)
                            val shortcut = ShortcutInfoCompat.Builder(context, target.id)
                                .setShortLabel(target.nickname.ifBlank { target.address }.take(40))
                                .setIcon(IconCompat.createWithResource(context, R.drawable.ic_lime_logo))
                                .setIntent(intent).build()
                            ShortcutManagerCompat.requestPinShortcut(context, shortcut, null)
                            contextMenuTarget = null
                        }, modifier = Modifier.fillMaxWidth(),
                    ) { Text("Pin home-screen shortcut") }
                    TextButton(
                        onClick = {
                            contextMenuTarget = null
                            viewModel.deleteConnection(target.id)
                        },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = null, tint = MaterialTheme.colorScheme.error)
                        Spacer(Modifier.width(8.dp))
                        Text("Delete", color = MaterialTheme.colorScheme.error)
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { contextMenuTarget = null }) { Text("Cancel") }
            },
        )
    }
}
