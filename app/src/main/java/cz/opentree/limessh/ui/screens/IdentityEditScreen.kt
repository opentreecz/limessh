package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.opentree.limessh.domain.model.AuthMethod
import cz.opentree.limessh.ui.theme.LimeDarkBg
import cz.opentree.limessh.ui.theme.LimeTerminalGreen
import cz.opentree.limessh.ui.viewmodel.IdentityEditViewModel
import cz.opentree.limessh.ssh.KeyImport
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdentityEditScreen(
    identityId: String?,
    onSaved: () -> Unit,
    onBack: () -> Unit,
    viewModel: IdentityEditViewModel = viewModel(),
) {
    LaunchedEffect(identityId) { identityId?.let { viewModel.load(it) } }

    val state by viewModel.state.collectAsState()
    val saving by viewModel.saving.collectAsState()
    var error by remember { mutableStateOf<String?>(null) }
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val clipboard = remember { context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager }
    val importLauncher = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) {
            // Oversized files are rejected while reading, without buffering the excess.
            val text = try {
                context.contentResolver.openInputStream(uri)?.use { KeyImport.readLimited(it) }
            } catch (e: Exception) { null }
            if (text == null) viewModel.reportKeyImportProblem("That file could not be read or is too large to be an SSH private key.")
            else viewModel.importKeyText(text)
        }
    }

    // Export private key to file (K-03): reads stored PEM from CredentialStore, writes to chosen URI.
    val exportKeyLauncher = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("application/x-pem-file")) { uri ->
        if (uri != null && identityId != null) {
            val pem = runCatching {
                cz.opentree.limessh.data.local.crypto.CredentialStore(context).getPrivateKey(identityId)
            }.getOrNull()
            if (pem != null) {
                runCatching {
                    context.contentResolver.openOutputStream(uri)?.bufferedWriter()?.use { it.write(pem) }
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (identityId == null) "New identity" else "Edit identity") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.save(onSaved, onError = { error = it })
                        },
                        enabled = !saving && state.username.isNotBlank() &&
                            (state.authMethod != AuthMethod.PUBLIC_KEY || state.privateKeyPem.isNotBlank()),
                    ) {
                        Icon(Icons.Default.Done, contentDescription = "Save")
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
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            OutlinedTextField(
                value = state.nickname,
                onValueChange = { viewModel.updateNickname(it) },
                label = { Text("Nickname (optional)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = state.username,
                onValueChange = { viewModel.updateUsername(it) },
                label = { Text("Username *") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )

            // Auth method selector
            Text(
                text = "Authentication method",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Row(Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AuthMethod.entries.forEach { method ->
                    FilterChip(
                        selected = state.authMethod == method,
                        onClick = { viewModel.updateAuthMethod(method) },
                        label = {
                            Text(when (method) {
                                AuthMethod.PASSWORD -> "Password"
                                AuthMethod.PUBLIC_KEY -> "Public key"
                                AuthMethod.KEYBOARD_INTERACTIVE -> "Keyboard-interactive"
                            })
                        },
                    )
                }
            }

            // Credential fields
            when (state.authMethod) {
                AuthMethod.PASSWORD, AuthMethod.KEYBOARD_INTERACTIVE -> {
                    OutlinedTextField(
                        value = state.password,
                        onValueChange = { viewModel.updatePassword(it) },
                        label = { Text("Password (stored securely)") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
                AuthMethod.PUBLIC_KEY -> {
                    Text(
                        "Import an existing OpenSSH, PEM or PKCS#8 private key (for example id_ed25519 or id_rsa). " +
                            "Choose the private file, not the .pub file. PuTTY .ppk files must first be converted to OpenSSH format.",
                        style = MaterialTheme.typography.bodySmall,
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { importLauncher.launch(arrayOf("*/*")) }, enabled = !state.keyChecking) {
                            Text("Import key file")
                        }
                        OutlinedButton(onClick = {
                            val clip = clipboard.primaryClip
                            val text = if (clip != null && clip.itemCount > 0) clip.getItemAt(0).coerceToText(context)?.toString() else null
                            if (text.isNullOrBlank()) viewModel.reportKeyImportProblem("The clipboard does not contain text.")
                            else viewModel.importKeyText(text)
                        }, enabled = !state.keyChecking) { Text("Paste") }
                    }
                    OutlinedTextField(
                        value = state.privateKeyPem,
                        onValueChange = { viewModel.updatePrivateKey(it) },
                        label = { Text("Private key") },
                        minLines = 4,
                        maxLines = 10,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("-----BEGIN OPENSSH PRIVATE KEY-----\n...") },
                    )
                    OutlinedTextField(
                        value = state.keyPassphrase,
                        onValueChange = { viewModel.updateKeyPassphrase(it) },
                        label = { Text("Key passphrase (if encrypted)") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                    )
                    OutlinedButton(onClick = { viewModel.checkKey() }, enabled = !state.keyChecking && state.privateKeyPem.isNotBlank()) {
                        Text(if (state.keyChecking) "Checking…" else "Check key")
                    }
                    state.keyMessage?.let {
                        Text(it, color = if (state.keyInfo != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error)
                    }
                    state.keyInfo?.let { info ->
                        Text("Type: ${info.keyType} · Format: ${info.format}", style = MaterialTheme.typography.bodySmall)
                        Text("Fingerprint: ${info.fingerprint}", style = MaterialTheme.typography.bodySmall)
                        androidx.compose.foundation.text.selection.SelectionContainer {
                            Text(info.publicKey, style = MaterialTheme.typography.bodySmall)
                        }
                        TextButton(onClick = {
                            clipboard.setPrimaryClip(ClipData.newPlainText("SSH public key", info.publicKey))
                        }) { Text("Copy public key for authorized_keys") }
                        // Export private key to a file — K-03
                        if (identityId != null) {
                            TextButton(onClick = { exportKeyLauncher.launch("private_key.pem") }) {
                                Text("Save private key to file…")
                            }
                        }
                    }
                }
            }
        }
    }
}
