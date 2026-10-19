package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.domain.model.*
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectionEditScreen(
    connection: Connection? = null,
    identities: List<Identity> = emptyList(),
    groups: List<ConnectionGroup> = emptyList(),
    onSave: (Connection, String?) -> Unit,
    onDelete: ((Connection) -> Unit)? = null,
    onBack: () -> Unit,
) {
    var address by remember { mutableStateOf(connection?.address ?: "") }
    var port by remember { mutableStateOf(connection?.port?.toString() ?: "22") }
    var nickname by remember { mutableStateOf(connection?.nickname ?: "") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf(connection?.type ?: ConnectionType.SSH) }
    var selectedIdentityId by remember { mutableStateOf(connection?.identityId) }
    var selectedGroupId by remember { mutableStateOf(connection?.groupId) }

    val isEdit = connection != null
    val title = if (isEdit) "Edit Connection" else "New Connection"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                },
                actions = {
                    if (isEdit && onDelete != null) {
                        IconButton(onClick = { onDelete(connection!!) }) {
                            Icon(Icons.Default.Delete, "Delete")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                value = nickname,
                onValueChange = { nickname = it },
                label = { Text("Nickname") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Host / IP") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )
            OutlinedTextField(
                value = port,
                onValueChange = { port = it.filter { c -> c.isDigit() } },
                label = { Text("Port") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

            // Connection type selector
            Text("Type", style = MaterialTheme.typography.labelLarge)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ConnectionType.entries.forEach { type ->
                    FilterChip(
                        selected = selectedType == type,
                        onClick = { selectedType = type },
                        label = { Text(type.name) },
                    )
                }
            }

            // Identity selector
            if (identities.isNotEmpty()) {
                Text("Identity", style = MaterialTheme.typography.labelLarge)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = selectedIdentityId == null,
                        onClick = { selectedIdentityId = null },
                        label = { Text("None") },
                    )
                    identities.forEach { identity ->
                        FilterChip(
                            selected = selectedIdentityId == identity.id,
                            onClick = { selectedIdentityId = identity.id },
                            label = { Text(identity.nickname.ifBlank { identity.username }) },
                        )
                    }
                }
            }

            // Quick auth (when no identity selected)
            if (selectedIdentityId == null) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                )
            }

            // Group selector
            if (groups.isNotEmpty()) {
                Text("Group", style = MaterialTheme.typography.labelLarge)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = selectedGroupId == null,
                        onClick = { selectedGroupId = null },
                        label = { Text("None") },
                    )
                    groups.forEach { group ->
                        FilterChip(
                            selected = selectedGroupId == group.id,
                            onClick = { selectedGroupId = group.id },
                            label = { Text(group.name) },
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    val conn = Connection(
                        id = connection?.id ?: UUID.randomUUID(),
                        name = nickname.ifBlank { address },
                        address = address,
                        port = port.toIntOrNull() ?: 22,
                        nickname = nickname,
                        type = selectedType,
                        identityId = selectedIdentityId,
                        groupId = selectedGroupId,
                    )
                    onSave(conn, password.takeIf { it.isNotBlank() })
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = address.isNotBlank(),
            ) {
                Text(if (isEdit) "Save" else "Create")
            }
        }
    }
}
