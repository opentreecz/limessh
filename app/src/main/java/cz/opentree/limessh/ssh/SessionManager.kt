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
import cz.opentree.limessh.domain.model.ConnectionType
import cz.opentree.limessh.plugin.builtin.AuditLog
import cz.opentree.limessh.plugin.builtin.AuditAction
import cz.opentree.limessh.service.SessionService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

/**
 * Manages multiple concurrent SSH sessions, wiring connections to the SSH engine,
 * authentication, port forwarding, snippet execution, and foreground service lifecycle.
 */
class SessionManager(private val context: Context, val auditLog: AuditLog) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val sessions = ConcurrentHashMap<UUID, SshSession>()
    private val _activeSessions = MutableStateFlow<List<SshSession>>(emptyList())
    val activeSessions: StateFlow<List<SshSession>> = _activeSessions.asStateFlow()

    private val db = AppDatabase.getInstance(context)
    private val credentialStore by lazy { CredentialStore(context) }

    /**
     * Connect to a server, authenticate, optionally set up port forwards and run snippets.
     */
    suspend fun connect(
        connection: Connection,
        identity: Identity?,
        password: String? = null,
        portForwards: List<PortForward> = emptyList(),
        snippets: List<Snippet> = emptyList(),
        challengePrompt: suspend (String, Boolean) -> String = { _, _ ->
            throw IllegalStateException("Interactive authentication requires a prompt")
        },
        hostKeyPrompt: suspend (HostKeyEvent) -> Boolean,
    ): SshSession = withContext(Dispatchers.IO) {
        require(connection.type == ConnectionType.SSH) { "${connection.type} transport is not implemented" }
        val login = requireLoginIdentity(identity)
        val engine = SshEngine()
        try {
        val verifier = DatabaseHostKeyVerifier(db.knownHostDao()) { event ->
            if (event is HostKeyEvent.Changed) auditLog.log("limessh", AuditAction.HOST_KEY_CHANGED, connection.id)
            val accepted = withTimeout(90_000) { hostKeyPrompt(event) }
            auditLog.log("limessh", if (accepted) AuditAction.HOST_KEY_ACCEPTED else AuditAction.HOST_KEY_REJECTED, connection.id)
            accepted
        }
        engine.setHostKeyVerifier(verifier)

        // Jump host (ProxyJump / connect-via): if configured, authenticate a separate engine
        // through the saved jump-host connection, open a direct-tcpip channel to the real target,
        // and use that channel as the transport for this engine.
        val jumpEngine: SshEngine? = connection.jumpHostId?.let { jumpId ->
            val repo = cz.opentree.limessh.data.repository.ConnectionRepository(db)
            val jumpConn = repo.getConnection(jumpId.toString())
                ?: error("Jump host connection $jumpId not found")
            require(jumpConn.type == ConnectionType.SSH) { "Jump host must be SSH type" }
            val jumpIdentity = jumpConn.identityId?.let { repo.getIdentity(it.toString()) }
            val jumpLogin = requireLoginIdentity(jumpIdentity)
            val je = SshEngine()
            je.setHostKeyVerifier(verifier)    // same host-key verifier for both hops
            je.connect(jumpConn.address, jumpConn.port)
            je.enableKeepAlive(60)
            authenticateWithIdentity(je, jumpLogin, challengePrompt)
            je
        }

        // Connect and enable SSH keepalive so dead TCP connections are detected within ~3 minutes.
        if (jumpEngine != null) {
            val directConn = jumpEngine.newDirectConnection(connection.address, connection.port)
            engine.connectVia(directConn)
        } else {
            engine.connect(connection.address, connection.port)
        }
        engine.enableKeepAlive(60)

        // Authenticate target engine
        authenticateWithIdentity(engine, login, challengePrompt, password)

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

        session.emulator.onOutput = { data ->
            scope.launch(Dispatchers.IO) {
                runCatching {
                    synchronized(shell.stdin) {
                        shell.stdin.write(data)
                        shell.stdin.flush()
                    }
                }
            }
        }
        session.emulator.attachInput(shell.stdout)
        sessions[session.id] = session
        updateSessionList()
        updateForegroundService()
        auditLog.log("limessh", AuditAction.SESSION_STARTED, connection.id)
        scope.launch {
            try { shell.channel.join() }
            finally {
                // Signal the UI before removing the session so TerminalScreen can show "Retry".
                session.disconnected.value = true
                disconnect(session.id)
            }
        }

        // Set up port forwards
        for (pf in portForwards) {
            scope.launch {
                try {
                    when (pf.mode) {
                        ForwardMode.LOCAL -> engine.localForward(pf.localPort, pf.host, pf.remotePort)
                        ForwardMode.REMOTE -> engine.remoteForward(pf.remotePort, pf.host, pf.localPort)
                        ForwardMode.SOCKS -> engine.socksForward(pf.localPort)
                    }
                    auditLog.log("limessh", AuditAction.PORT_FORWARD_STARTED, connection.id, pf.id.toString())
                } catch (e: CancellationException) {
                    throw e
                } catch (e: Exception) {
                    session.warnings.value += "Forward ${pf.name}: ${e.message}"
                }
            }
        }

        // Run auto-start snippets
        scope.launch {
            for (snippet in snippets.filter { it.runOnConnect && it.connectionId == connection.id }) {
                try {
                    engine.exec(snippet.content)
                    auditLog.log("limessh", AuditAction.SNIPPET_RUN, connection.id, snippet.id.toString())
                } catch (e: CancellationException) { throw e }
                catch (e: Exception) { session.warnings.value += "Autostart ${snippet.name}: ${e.message}" }
            }
        }

        session
        } catch (error: Throwable) {
            engine.close()
            sessions.entries.removeAll { it.value.engine === engine }
            updateSessionList()
            runCatching { updateForegroundService() }
            auditLog.log("limessh", AuditAction.SESSION_AUTH_FAILED, connection.id)
            throw error
        }
    }

    fun getSession(id: UUID): SshSession? = sessions[id]

    fun findSession(connectionId: String): SshSession? =
        sessions.values.firstOrNull { it.connectionId.toString() == connectionId }

    suspend fun execute(sessionId: UUID, command: String): ExecResult {
        val session = sessions[sessionId] ?: error("Session is no longer active")
        auditLog.log("limessh", AuditAction.COMMAND_EXECUTED, session.connectionId)
        return session.engine.exec(command)
    }

    suspend fun disconnect(sessionId: UUID) {
        withContext(NonCancellable + Dispatchers.IO) {
        sessions.remove(sessionId)?.let { session ->
            withContext(Dispatchers.IO) {
                session.shell.close()
                session.engine.close()
                session.emulator.detach()
            }
            auditLog.log("limessh", AuditAction.SESSION_ENDED, session.connectionId)
        }
        updateSessionList()
        updateForegroundService()
        }
    }

    fun requestDisconnect(sessionId: UUID) { scope.launch { disconnect(sessionId) } }

    suspend fun disconnectAll() {
        val allIds = sessions.keys.toList()
        allIds.forEach { disconnect(it) }
    }

    suspend fun writeToSession(sessionId: UUID, data: ByteArray) = withContext(Dispatchers.IO) {
        sessions[sessionId]?.shell?.stdin?.let { stream ->
            synchronized(stream) { stream.write(data); stream.flush() }
        }
    }

    suspend fun resizeSession(sessionId: UUID, cols: Int, rows: Int) = withContext(Dispatchers.IO) {
        sessions[sessionId]?.shell?.resize(cols, rows)
    }

    /** Authenticate [engine] using the credentials stored for [identity]. */
    private suspend fun authenticateWithIdentity(
        engine: SshEngine,
        identity: Identity,
        challengePrompt: suspend (String, Boolean) -> String,
        explicitPassword: String? = null,
    ) {
        when (identity.authMethod) {
            AuthMethod.PUBLIC_KEY -> {
                val keyPem = credentialStore.getPrivateKey(identity.id.toString())
                    ?.takeIf { it.isNotBlank() }
                    ?: throw IllegalStateException(
                        "No private key is stored for the selected identity. " +
                            "Import or enter its private key in Identities."
                    )
                val passphrase = credentialStore.getKeyPassphrase(identity.id.toString())
                engine.authPrivateKey(identity.username, keyPem, passphrase, challengePrompt)
            }
            AuthMethod.KEYBOARD_INTERACTIVE ->
                engine.authKeyboardInteractive(identity.username, challengePrompt)
            else -> {
                val pwd = explicitPassword ?: credentialStore.getPassword(identity.id.toString())
                engine.authPassword(identity.username, pwd, challengePrompt)
            }
        }
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
            context.stopService(intent)
        }
    }
}

data class SshSession(
    val id: UUID,
    val connectionId: UUID,
    val connectionName: String,
    val engine: SshEngine,
    val shell: ShellHandle,
    val emulator: TerminalEmulator = TerminalEmulator(),
    val warnings: MutableStateFlow<List<String>> = MutableStateFlow(emptyList()),
    /** Becomes true when the SSH channel closes for any reason (clean exit, timeout, or keepalive failure). */
    val disconnected: MutableStateFlow<Boolean> = MutableStateFlow(false),
)
