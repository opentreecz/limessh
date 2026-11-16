package cz.opentree.limessh.ssh

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runInterruptible
import kotlinx.coroutines.ensureActive
import net.schmizz.keepalive.KeepAliveProvider
import net.schmizz.sshj.DefaultConfig
import net.schmizz.sshj.SSHClient
import net.schmizz.sshj.connection.channel.direct.Session
import net.schmizz.sshj.transport.verification.HostKeyVerifier
import java.io.Closeable
import java.io.InputStream
import java.io.OutputStream
import java.security.PublicKey
import java.net.ServerSocket
import java.net.InetSocketAddress
import java.util.concurrent.TimeUnit
import java.util.concurrent.CopyOnWriteArrayList
import net.schmizz.sshj.connection.channel.direct.Parameters
import net.schmizz.sshj.sftp.OpenMode
import cz.opentree.limessh.domain.model.AuthMethod
import net.schmizz.sshj.userauth.UserAuthException
import net.schmizz.sshj.userauth.method.AuthKeyboardInteractive
import net.schmizz.sshj.userauth.method.AuthPassword
import net.schmizz.sshj.userauth.method.AuthPublickey
import net.schmizz.sshj.userauth.password.PasswordFinder
import net.schmizz.sshj.userauth.password.Resource

/**
 * Thin adapter around SSHJ providing coroutine-friendly SSH operations.
 * Isolates the SSH library so a future switch to another engine requires changes only here.
 */
class SshEngine : Closeable {

    // Use KeepAliveRunner so the SSH transport proactively pings the server and detects
    // dead connections (KeepAliveProvider.KEEP_ALIVE expects a server reply; HEARTBEAT does not).
    private val client = run {
        SshCrypto.initialize()
        SSHClient(object : DefaultConfig() {
            init { setKeepAliveProvider(KeepAliveProvider.KEEP_ALIVE) }
        })
    }
    private val forwards = CopyOnWriteArrayList<Closeable>()

    init {
        client.connectTimeout = 15_000
        client.timeout = 30_000
    }

    /**
     * Enable SSH keepalive pings. Call after [connect] and before [startShell].
     * The client sends SSH_MSG_GLOBAL_REQUEST every [intervalSeconds] seconds;
     * if the server does not respond after a few missed pings the transport is closed,
     * triggering clean session-drop detection.
     */
    fun enableKeepAlive(intervalSeconds: Int = 60) {
        runCatching { client.connection.keepAlive.setKeepAliveInterval(intervalSeconds) }
    }

    fun setHostKeyVerifier(verifier: HostKeyVerifier) {
        client.addHostKeyVerifier(verifier)
    }

    suspend fun connect(host: String, port: Int = 22) = runInterruptible(Dispatchers.IO) {
        client.connect(host, port)
    }

    suspend fun authPassword(
        username: String,
        password: String?,
        respond: suspend (String, Boolean) -> String = { _, _ -> error("Interactive login requires a prompt") },
    ) = withContext(Dispatchers.IO) {
        authenticate(username, AuthMethod.PASSWORD) {
            val responses = InteractiveResponses(password, { client.userAuth.hadPartialSuccess() }, respond)
            val finder = passwordFinder {
                password?.takeIf { it.isNotEmpty() } ?: respond("SSH account password for $username:", false)
            }
            client.auth(username, AuthPassword(finder), AuthKeyboardInteractive(challengeProvider { prompt, echo -> responses.answer(prompt, echo) }))
        }
    }

    suspend fun authPublicKey(username: String, keyPath: String) = withContext(Dispatchers.IO) {
        client.authPublickey(username, keyPath)
    }

    suspend fun authPublicKey(
        username: String,
        keyProvider: net.schmizz.sshj.userauth.keyprovider.KeyProvider,
    ) = withContext(Dispatchers.IO) {
        client.authPublickey(username, keyProvider)
    }

    val isAuthenticated: Boolean get() = client.isAuthenticated
    val isConnected: Boolean get() = client.isConnected

    suspend fun authPrivateKey(
        username: String,
        pem: String,
        passphrase: String?,
        respond: suspend (String, Boolean) -> String = { _, _ -> error("Encrypted key or second factor requires a prompt") },
    ) = withContext(Dispatchers.IO) {
        val key = try {
            val finder = passwordFinder {
                passphrase?.takeIf { it.isNotEmpty() } ?: respond("Private-key passphrase:", false)
            }
            client.loadKeys(pem.trim() + "\n", null, finder).also {
                checkNotNull(it.private) { "Private key is missing" }
                checkNotNull(it.public) { "Public key is missing" }
            }
        } catch (e: kotlinx.coroutines.CancellationException) { throw e }
        catch (e: Exception) {
            throw IllegalArgumentException("Cannot read the private key. Check that it is a supported private-key file and that its passphrase is correct.", e)
        }
        var keyAccepted = false
        authenticate(username, AuthMethod.PUBLIC_KEY, { keyAccepted || client.userAuth.hadPartialSuccess() }) {
            try {
                client.auth(username, AuthPublickey(key))
            } catch (e: UserAuthException) {
                // Only continue after the server actually accepted the key as a factor.
                if (!client.userAuth.hadPartialSuccess()) throw e
                keyAccepted = true
                client.auth(username,
                    AuthPassword(passwordFinder { respond("SSH account password for $username:", false) }),
                    AuthKeyboardInteractive(challengeProvider(respond)))
            }
        }
    }

    suspend fun authKeyboardInteractive(
        username: String,
        respond: suspend (String, Boolean) -> String,
    ) = withContext(Dispatchers.IO) {
        authenticate(username, AuthMethod.KEYBOARD_INTERACTIVE) {
            client.auth(username, AuthKeyboardInteractive(challengeProvider(respond)))
        }
    }

    private fun challengeProvider(respond: suspend (String, Boolean) -> String) =
        object : net.schmizz.sshj.userauth.method.ChallengeResponseProvider {
            override fun getSubmethods() = emptyList<String>()
            override fun init(resource: net.schmizz.sshj.userauth.password.Resource<*>?, name: String?, instruction: String?) {}
            override fun getResponse(prompt: String, echo: Boolean): CharArray =
                kotlinx.coroutines.runBlocking { kotlinx.coroutines.withTimeout(90_000) { respond(prompt, echo).toCharArray() } }
            override fun shouldRetry() = false
        }

    private fun passwordFinder(value: suspend () -> String) = object : PasswordFinder {
        override fun reqPassword(resource: Resource<*>?) =
            kotlinx.coroutines.runBlocking { kotlinx.coroutines.withTimeout(90_000) { value().toCharArray() } }
        override fun shouldRetry(resource: Resource<*>?) = false
    }

    private fun authenticate(
        username: String,
        method: AuthMethod,
        partialSuccess: () -> Boolean = { client.userAuth.hadPartialSuccess() },
        operation: () -> Unit,
    ) {
        try { operation() }
        catch (e: UserAuthException) {
            throw AuthenticationFailure(username, method, client.userAuth.allowedMethods.orEmpty(), partialSuccess(), e)
        }
    }

    suspend fun startShell(
        term: String = "xterm-256color",
        cols: Int = 80,
        rows: Int = 24,
    ): ShellHandle = withContext(Dispatchers.IO) {
        val session = client.startSession()
        session.allocatePTY(term, cols, rows, 0, 0, emptyMap())
        val shell = session.startShell()
        ShellHandle(session, shell, shell.inputStream, shell.outputStream, shell.errorStream)
    }

    suspend fun exec(command: String): ExecResult = withContext(Dispatchers.IO) {
        client.startSession().use { session ->
            val cmd = session.exec(command)
            coroutineScope {
                // Drain both streams concurrently: sequential reads can deadlock.
                val output = async { runInterruptible(Dispatchers.IO) { readBounded(cmd.inputStream) } }
                val error = async { runInterruptible(Dispatchers.IO) { readBounded(cmd.errorStream) } }
                try {
                    runInterruptible { cmd.join(30, TimeUnit.SECONDS) }
                    check(!cmd.isOpen) { "Command timed out after 30 seconds" }
                    ExecResult(output.await(), error.await(), cmd.exitStatus ?: -1)
                } finally {
                    session.close()
                }
            }
        }
    }

    suspend fun localForward(
        localPort: Int,
        remoteHost: String,
        remotePort: Int,
    ) = withContext(Dispatchers.IO) {
        require(localPort in 1..65535 && remotePort in 1..65535)
        val socket = ServerSocket().apply { bind(InetSocketAddress("127.0.0.1", localPort)) }
        val forwarder = client.newLocalPortForwarder(
            Parameters("127.0.0.1", localPort, remoteHost, remotePort), socket,
        )
        forwards.add(Closeable { forwarder.close() })
        Thread({ runCatching { forwarder.listen() } }, "limessh-forward-$localPort").apply {
            isDaemon = true
            start()
        }
    }

    suspend fun remoteForward(
        remotePort: Int,
        localHost: String,
        localPort: Int,
    ) = withContext(Dispatchers.IO) {
        val params = net.schmizz.sshj.connection.channel.forwarded.SocketForwardingConnectListener(
            java.net.InetSocketAddress(localHost, localPort)
        )
        client.getRemotePortForwarder().bind(
            net.schmizz.sshj.connection.channel.forwarded.RemotePortForwarder.Forward(remotePort),
            params
        )
    }

    suspend fun socksForward(localPort: Int) = withContext(Dispatchers.IO) {
        forwards.add(SocksProxy(localPort) { host, port -> client.newDirectConnection(host, port) })
    }

    suspend fun listFiles(path: String): List<RemoteEntry> = withContext(Dispatchers.IO) {
        client.newSFTPClient().use { sftp ->
            sftp.ls(path).filter { it.name != "." && it.name != ".." }
                .map { RemoteEntry(it.name, it.path, it.isDirectory, it.attributes.size) }
                .sortedWith(compareByDescending<RemoteEntry> { it.directory }.thenBy { it.name })
        }
    }

    suspend fun canonicalPath(path: String): String = withContext(Dispatchers.IO) {
        client.newSFTPClient().use { it.canonicalize(path) }
    }

    suspend fun download(path: String, output: OutputStream) = withContext(Dispatchers.IO) {
        client.newSFTPClient().use { sftp ->
            sftp.open(path).use { remote ->
                val buffer = ByteArray(32768)
                var offset = 0L
                while (true) {
                    kotlinx.coroutines.currentCoroutineContext().ensureActive()
                    val count = remote.read(offset, buffer, 0, buffer.size)
                    if (count < 0) break
                    check(count > 0) { "SFTP read made no progress" }
                    output.write(buffer, 0, count)
                    offset += count
                }
            }
        }
    }

    suspend fun upload(path: String, input: InputStream) = withContext(Dispatchers.IO) {
        client.newSFTPClient().use { sftp ->
            // EXCL prevents accidental replacement of an existing remote file.
            sftp.open(path, setOf(OpenMode.WRITE, OpenMode.CREAT, OpenMode.EXCL)).use { remote ->
                val buffer = ByteArray(32768)
                var offset = 0L
                while (true) {
                    kotlinx.coroutines.currentCoroutineContext().ensureActive()
                    val count = input.read(buffer)
                    if (count < 0) break
                    remote.write(offset, buffer, 0, count)
                    offset += count
                }
            }
        }
    }

    /** Create a remote directory. Fails if it already exists. */
    suspend fun mkdir(path: String) = withContext(Dispatchers.IO) {
        client.newSFTPClient().use { it.mkdir(path) }
    }

    /** Rename/move a remote file or directory. */
    suspend fun rename(oldPath: String, newPath: String) = withContext(Dispatchers.IO) {
        client.newSFTPClient().use { it.rename(oldPath, newPath) }
    }

    /** Remove a remote regular file. */
    suspend fun rm(path: String) = withContext(Dispatchers.IO) {
        client.newSFTPClient().use { it.rm(path) }
    }

    /** Remove an empty remote directory. */
    suspend fun rmdir(path: String) = withContext(Dispatchers.IO) {
        client.newSFTPClient().use { it.rmdir(path) }
    }

    /** Open a direct-tcpip channel to [host]:[port] through this (jump) engine's session. */
    suspend fun newDirectConnection(host: String, port: Int) = withContext(Dispatchers.IO) {
        client.newDirectConnection(host, port).also { forwards.add(it) }
    }

    /** Connect this engine's SSH transport through a pre-opened [directConnection] (jump-host channel). */
    suspend fun connectVia(directConnection: net.schmizz.sshj.connection.channel.direct.DirectConnection) =
        withContext(Dispatchers.IO) {
            client.connectVia(directConnection)
        }

    override fun close() {
        forwards.forEach { runCatching { it.close() } }
        forwards.clear()
        runCatching { client.disconnect() }
        runCatching { client.close() }
    }
}

data class ShellHandle(
    val session: Session,
    val channel: Session.Shell,
    val stdout: InputStream,
    val stdin: OutputStream,
    val stderr: InputStream,
) : Closeable {
    override fun close() {
        runCatching { session.close() }
    }

    fun resize(cols: Int, rows: Int) {
        channel.changeWindowDimensions(cols, rows, 0, 0)
    }
}

data class ExecResult(
    val stdout: String,
    val stderr: String,
    val exitCode: Int,
)

data class RemoteEntry(val name: String, val path: String, val directory: Boolean, val size: Long)

private fun readBounded(input: InputStream): String {
    val output = java.io.ByteArrayOutputStream()
    val buffer = ByteArray(8192)
    var count = input.read(buffer)
    while (count >= 0) {
        check(output.size() + count <= 1_048_576) { "Command output exceeded 1 MiB" }
        output.write(buffer, 0, count)
        count = input.read(buffer)
    }
    return output.toString("UTF-8")
}
