package cz.opentree.limessh.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.crypto.CredentialStore
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.domain.model.AuthMethod
import cz.opentree.limessh.domain.model.Identity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.schmizz.sshj.common.Buffer
import org.bouncycastle.openssl.jcajce.JcaPEMWriter
import java.io.StringWriter
import java.security.KeyPairGenerator
import java.security.spec.ECGenParameterSpec
import java.util.Base64

/** Supported key algorithms for generation. */
private enum class KeyAlgorithm(val label: String, val description: String) {
    RSA_3072("RSA-3072", "Widely compatible; 3072-bit key"),
    ED25519("Ed25519", "Recommended; small, fast, modern"),
    ECDSA_P256("ECDSA P-256", "Elliptic curve; good compatibility"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeyGeneratorScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var nickname by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var selectedAlgorithm by remember { mutableStateOf(KeyAlgorithm.ED25519) }
    var algorithmExpanded by remember { mutableStateOf(false) }
    var publicKey by remember { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Generate SSH key") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") }
                },
            )
        },
    ) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                nickname, { nickname = it },
                label = { Text("Identity name") },
                enabled = !busy,
                modifier = Modifier.fillMaxWidth(),
            )
            OutlinedTextField(
                username, { username = it },
                label = { Text("SSH username") },
                enabled = !busy,
                modifier = Modifier.fillMaxWidth(),
            )

            // Algorithm selector
            ExposedDropdownMenuBox(
                expanded = algorithmExpanded,
                onExpandedChange = { if (!busy) algorithmExpanded = it },
            ) {
                OutlinedTextField(
                    value = "${selectedAlgorithm.label} — ${selectedAlgorithm.description}",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Key algorithm") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(algorithmExpanded) },
                    modifier = Modifier.menuAnchor().fillMaxWidth(),
                    enabled = !busy,
                )
                ExposedDropdownMenu(
                    expanded = algorithmExpanded,
                    onDismissRequest = { algorithmExpanded = false },
                ) {
                    KeyAlgorithm.entries.forEach { algo ->
                        DropdownMenuItem(
                            text = { Text("${algo.label} — ${algo.description}") },
                            onClick = { selectedAlgorithm = algo; algorithmExpanded = false },
                        )
                    }
                }
            }

            Button(
                enabled = !busy && nickname.isNotBlank() && username.isNotBlank() && publicKey.isBlank(),
                onClick = {
                    busy = true
                    scope.launch {
                        try {
                            val algo = selectedAlgorithm
                            publicKey = withContext(Dispatchers.IO) {
                                val pair = when (algo) {
                                    KeyAlgorithm.RSA_3072 ->
                                        KeyPairGenerator.getInstance("RSA")
                                            .apply { initialize(3072) }.generateKeyPair()
                                    KeyAlgorithm.ED25519 ->
                                        KeyPairGenerator.getInstance("Ed25519", "BC")
                                            .generateKeyPair()
                                    KeyAlgorithm.ECDSA_P256 ->
                                        KeyPairGenerator.getInstance("EC", "BC")
                                            .apply { initialize(ECGenParameterSpec("secp256r1")) }
                                            .generateKeyPair()
                                }
                                // Serialize private key as PEM (PKCS#8 for RSA/ECDSA, OpenSSH for Ed25519)
                                val pem = StringWriter().also {
                                    JcaPEMWriter(it).use { writer -> writer.writeObject(pair.private) }
                                }.toString()
                                val identity = Identity(
                                    nickname = nickname,
                                    username = username,
                                    authMethod = AuthMethod.PUBLIC_KEY,
                                )
                                CredentialStore(context).storePrivateKey(identity.id.toString(), pem)
                                ConnectionRepository(AppDatabase.getInstance(context)).saveIdentity(identity)
                                // Return authorized_keys public key string
                                "ssh-${algo.name.lowercase().replace('_', '-').substringBefore('-')} " +
                                    Base64.getEncoder().encodeToString(
                                        Buffer.PlainBuffer().putPublicKey(pair.public).compactData
                                    )
                            }
                        } catch (e: Exception) {
                            error = e.message
                        } finally {
                            busy = false
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            ) { Text("Generate and save identity") }

            if (busy) CircularProgressIndicator()
            error?.let { Text(it, color = MaterialTheme.colorScheme.error) }

            if (publicKey.isNotBlank()) {
                Text("Identity saved. Add this public key to the server's authorized_keys file.")
                OutlinedTextField(
                    publicKey, {}, readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                )
                TextButton(
                    onClick = {
                        (context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
                            .setPrimaryClip(ClipData.newPlainText("SSH public key", publicKey))
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) { Text("Copy public key") }
            }
        }
    }
}
