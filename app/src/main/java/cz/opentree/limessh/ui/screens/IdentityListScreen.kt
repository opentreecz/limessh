package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.opentree.limessh.data.local.entity.IdentityEntity
import cz.opentree.limessh.domain.model.AuthMethod
import cz.opentree.limessh.ui.theme.LimeDarkBg
import cz.opentree.limessh.ui.theme.LimeGreen
import cz.opentree.limessh.ui.theme.LimeTerminalGreen
import cz.opentree.limessh.ui.viewmodel.IdentityListViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun IdentityListScreen(
    onNewIdentity: () -> Unit,
    onEditIdentity: (String) -> Unit,
    onOpenKeyGenerator: () -> Unit,
    onBack: () -> Unit,
    viewModel: IdentityListViewModel = viewModel(),
) {
    val identities by viewModel.identities.collectAsState(initial = emptyList())
    var contextTarget by remember { mutableStateOf<IdentityEntity?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Identities") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onOpenKeyGenerator) {
                        Icon(Icons.Default.VpnKey, contentDescription = "Generate key pair")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LimeDarkBg,
                    titleContentColor = LimeTerminalGreen,
                    navigationIconContentColor = LimeTerminalGreen,
                    actionIconContentColor = LimeTerminalGreen,
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNewIdentity,
                containerColor = LimeGreen,
                contentColor = LimeDarkBg,
            ) {
                Icon(Icons.Default.Add, contentDescription = "New identity")
            }
        },
    ) { padding ->
        if (identities.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Default.Key,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        "No identities configured.",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        "Identities store SSH credentials.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                    Spacer(Modifier.height(24.dp))
                    OutlinedButton(onClick = onNewIdentity) {
                        Icon(Icons.Default.Add, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Add identity")
                    }
                    Spacer(Modifier.height(8.dp))
                    OutlinedButton(onClick = onOpenKeyGenerator) {
                        Icon(Icons.Default.VpnKey, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Generate key pair")
                    }
                }
            }
        } else {
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(identities, key = { it.id }) { identity ->
                    val authLabel = when (AuthMethod.entries.getOrElse(identity.authMethod) { AuthMethod.PASSWORD }) {
                        AuthMethod.PASSWORD -> "Password"
                        AuthMethod.PUBLIC_KEY -> "Public key"
                        AuthMethod.KEYBOARD_INTERACTIVE -> "Keyboard-interactive"
                    }
                    ListItem(
                        headlineContent = {
                            Text(identity.nickname.ifBlank { identity.username })
                        },
                        supportingContent = {
                            Text(
                                "${identity.username}  ·  $authLabel",
                                style = MaterialTheme.typography.bodySmall,
                            )
                        },
                        leadingContent = {
                            Icon(
                                if (identity.authMethod == AuthMethod.PUBLIC_KEY.ordinal)
                                    Icons.Default.VpnKey else Icons.Default.Password,
                                contentDescription = null,
                                tint = LimeTerminalGreen,
                            )
                        },
                        trailingContent = {
                            IconButton(onClick = { contextTarget = identity }) {
                                Icon(Icons.Default.MoreVert, contentDescription = "More")
                            }
                        },
                        modifier = Modifier.combinedClickable(
                            onClick = { onEditIdentity(identity.id) },
                            onLongClick = { contextTarget = identity },
                        ),
                    )
                    HorizontalDivider(thickness = 0.5.dp)
                }
            }
        }
    }

    contextTarget?.let { target ->
        AlertDialog(
            onDismissRequest = { contextTarget = null },
            title = { Text(target.nickname.ifBlank { target.username }) },
            text = {
                Column {
                    TextButton(
                        onClick = { contextTarget = null; onEditIdentity(target.id) },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Icon(Icons.Default.Edit, null)
                        Spacer(Modifier.width(8.dp))
                        Text("Edit")
                    }
                    TextButton(
                        onClick = { contextTarget = null; viewModel.deleteIdentity(target.id) },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Icon(Icons.Default.Delete, null, tint = MaterialTheme.colorScheme.error)
                        Spacer(Modifier.width(8.dp))
                        Text("Delete", color = MaterialTheme.colorScheme.error)
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { contextTarget = null }) { Text("Cancel") }
            },
        )
    }
}
