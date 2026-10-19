package cz.opentree.limessh.ssh

import android.content.Context
import android.content.Intent
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.crypto.CredentialStore
import cz.opentree.limessh.domain.model.AuthMethod
import cz.opentree.limessh.domain.model.Connection
import cz.opentree.limessh.domain.model.Identity
import cz.opentree.limessh.domain.model.PortForward
import cz.opentree.limessh.domain.model.ForwardMode
import cz.opentree.limessh.domain.model.Snippet
import cz.opentree.limessh.service.SessionService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import net.schmizz.sshj.userauth.keyprovider.OpenSSHKeyFile
import java.io.StringReader
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

/**
 * Manages multiple concurrent SSH sessions, wiring connections to the SSH engine,
 * authentication, port forwarding, snippet execution, and foreground service lifecycle.
 */
class SessionManager(private val context: Context) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val sessions = ConcurrentHashMap<UUID, SshSession>()
    private val _activeSessions = MutableStateFlow<List<SshSession>>(emptyList())
    val activeSessions: StateFlow<List<SshSession>> = _activeSessions.asStateFlow()

    private val db = AppDatabase.getInstance(context)
    private val credentialStore = CredentialStore(context)

    /**
     * Connect to a server, authenticate, optionally set up port forwards and run snippets.
     */
    suspend fun connect(
        connection: Connection,
        identity: Identity?,
        password: String? = null,
        portForwards: List<PortForward> = emptyList(),
        snippets: List<Snippet> = emptyList(),
        hostKeyPrompt: suspend (HostKeyEvent) -> Boolean,
    ): SshSession {
        val engine = SshEngine()
        val verifier = DatabaseHostKeyVerifier(db.knownHostDao(), hostKeyPrompt)
        engine.setHostKeyVerifier(verifier)

        // Connect
        engine.connect(connection.address, connection.port)

        // Authenticate
        val username = identity?.username ?: "root"
        when (identity?.authMethod) {
            AuthMethod.PUBLIC_KEY -> {
                val keyPem = credentialStore.getPrivateKey(identity.id.toString())
                    ?: throw IllegalStateException("No private key stored for identity ${identity.nickname}")
                val passphrase = credentialStore.getKeyPassphrase(identity.id.toString())
                val keyFile = OpenSSHKeyFile()
                if (passphrase != null) {
                    keyFile.init(StringReader(keyPem), net.schmizz.sshj.userauth.password.PasswordFinder {
                        passphrase.toCharArray()
                    })
                } else {
                    keyFile.init(StringReader(keyPem), null as net.schmizz.sshj.userauth.password.PasswordFinder?)
                }
                engine.authPublicKey(username, keyFile)
            }
            AuthMethod.KEYBOARD_INTERACTIVE -> {
                // Fall through to password for now; keyboard-interactive needs UI callback
                val pwd = password ?: credentialStore.getPassword(identity.id.toString()) ?: ""
                engine.authPassword(username, pwd)
            }
            else -> {
                val pwd = password
                    ?: identity?.let { credentialStore.getPassword(it.id.toString()) }
                    ?: ""
                engine.authPassword(username, pwd)
            }
        }

        if (!engine.isAuthenticated) {
            engine.close()
            throw SecurityException("Authentication failed for ${connection.address}")
        }

        // Open shell
        val shell = engine.startShell()

        val session = SshSession(
            id = UUID.randomUUID(),
            connectionId = connection.id,
            connectionName = connection.nickname.ifBlank { connection.address },
            engine = engine,
            shell = shell,
        )

        sessions[session.id] = session
        updateSessionList()
        updateForegroundService()

        // Set up port forwards
        for (pf in portForwards) {
            scope.launch {
                try {
                    when (pf.mode) {
                        ForwardMode.LOCAL -> engine.localForward(pf.localPort, pf.host, pf.remotePort)
                        ForwardMode.REMOTE -> engine.remoteForward(pf.remotePort, pf.host, pf.localPort)
                        ForwardMode.SOCKS -> engine.localForward(pf.localPort, "0.0.0.0", 0)
                    }
                } catch (e: Exception) {
                    // Log port forward failure but don't kill the session
                }
            }
        }

        // Run auto-start snippets
        for (snippet in snippets.filter { it.runOnConnect }) {
            scope.launch {
                try {
                    engine.exec(snippet.content)
                } catch (_: Exception) {}
            }
        }

        return session
    }

    fun getSession(id: UUID): SshSession? = sessions[id]

    suspend fun disconnect(sessionId: UUID) {
        sessions.remove(sessionId)?.let { session ->
            withContext(Dispatchers.IO) {
                session.shell.close()
                session.engine.close()
            }
        }
        updateSessionList()
        updateForegroundService()
    }

    suspend fun disconnectAll() {
        val allIds = sessions.keys.toList()
        allIds.forEach { disconnect(it) }
    }

    fun writeToSession(sessionId: UUID, data: ByteArray) {
        sessions[sessionId]?.shell?.stdin?.write(data)
        sessions[sessionId]?.shell?.stdin?.flush()
    }

    fun resizeSession(sessionId: UUID, cols: Int, rows: Int) {
        sessions[sessionId]?.shell?.resize(cols, rows)
    }

    private fun updateSessionList() {
        _activeSessions.value = sessions.values.toList()
    }

    private fun updateForegroundService() {
        val count = sessions.size
        val intent = Intent(context, SessionService::class.java).apply {
            putExtra(SessionService.EXTRA_SESSION_COUNT, count)
        }
        if (count > 0) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent) // Will stop itself when count <= 0
        }
    }
}

data class SshSession(
    val id: UUID,
    val connectionId: UUID,
    val connectionName: String,
    val engine: SshEngine,
    val shell: ShellHandle,
)
