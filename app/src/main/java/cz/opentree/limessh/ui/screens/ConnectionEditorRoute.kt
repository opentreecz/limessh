package cz.opentree.limessh.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.crypto.CredentialStore
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.domain.model.*
import kotlinx.coroutines.launch

@Composable
fun ConnectionEditorRoute(
    connectionId: String?,
    onBack: () -> Unit,
    onEditIdentity: ((String) -> Unit)? = null,
    prefillAddress: String = "",
    prefillPort: Int? = null,
    prefillUser: String? = null,
) {
    val context = LocalContext.current
    val repository = remember { ConnectionRepository(AppDatabase.getInstance(context)) }
    val scope = rememberCoroutineScope()
    val identities by repository.observeIdentities().collectAsState(initial = emptyList())
    val groups by repository.observeGroups().collectAsState(initial = emptyList())
    // SSH connections for jump-host picker (excludes current connection)
    val allConnections by repository.observeConnections().collectAsState(initial = emptyList())
    val sshConnections = allConnections.filter { it.type == ConnectionType.SSH && it.id.toString() != connectionId }
    var connection by remember(connectionId) { mutableStateOf<Connection?>(null) }
    var loaded by remember(connectionId) { mutableStateOf(connectionId == null) }
    var error by remember { mutableStateOf<String?>(null) }
    var saving by remember { mutableStateOf(false) }
    LaunchedEffect(connectionId) {
        if (connectionId != null) {
            connection = repository.getConnection(connectionId)
            if (connection == null) error = "Connection no longer exists"
            else loaded = true
        }
    }
    if (loaded) ConnectionEditScreen(
        connection = connection,
        prefillAddress = if (connection == null) prefillAddress else "",
        prefillPort = if (connection == null) prefillPort else null,
        prefillUser = if (connection == null) prefillUser else null,
        identities = identities,
        groups = groups,
        sshConnections = sshConnections,
        onSave = { value, username, password ->
            if (!saving) {
                saving = true
                scope.launch {
                    try {
                        val identity = if (value.identityId == null) {
                            Identity(nickname = value.nickname.ifBlank { value.address }, username = username.trim())
                        } else null
                        if (identity != null) {
                            repository.saveIdentity(identity)
                            CredentialStore(context).storePassword(identity.id.toString(), password.orEmpty())
                        }
                        repository.saveConnection(value.copy(identityId = value.identityId ?: identity?.id))
                        onBack()
                    } catch (e: Exception) { error = e.message; saving = false }
                }
            }
        },
        onDelete = { value -> scope.launch { repository.deleteConnection(value); onBack() } },
        onBack = onBack,
        onEditIdentity = onEditIdentity,
    ) else CircularProgressIndicator()
    error?.let { message ->
        AlertDialog(onDismissRequest = { error = null }, title = { Text("Connection") },
            text = { Text(message) }, confirmButton = { TextButton(onClick = { error = null }) { Text("OK") } })
    }
}
