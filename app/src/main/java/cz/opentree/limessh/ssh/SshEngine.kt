package cz.opentree.limessh.ssh

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.schmizz.sshj.SSHClient
import net.schmizz.sshj.connection.channel.direct.Session
import net.schmizz.sshj.transport.verification.HostKeyVerifier
import java.io.Closeable
import java.io.InputStream
import java.io.OutputStream
import java.security.PublicKey

/**
 * Thin adapter around SSHJ providing coroutine-friendly SSH operations.
 * Isolates the SSH library so a future switch to another engine requires changes only here.
 */
class SshEngine : Closeable {

    private val client = SSHClient()

    fun setHostKeyVerifier(verifier: HostKeyVerifier) {
        client.addHostKeyVerifier(verifier)
    }

    suspend fun connect(host: String, port: Int = 22) = withContext(Dispatchers.IO) {
        client.connect(host, port)
    }

    suspend fun authPassword(username: String, password: String) = withContext(Dispatchers.IO) {
        client.authPassword(username, password)
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

    suspend fun startShell(
        term: String = "xterm-256color",
        cols: Int = 80,
        rows: Int = 24,
    ): ShellHandle = withContext(Dispatchers.IO) {
        val session = client.startSession()
        session.allocatePTY(term, cols, rows, 0, 0, emptyMap())
        val shell = session.startShell()
        ShellHandle(session, shell.inputStream, shell.outputStream, shell.errorStream)
    }

    suspend fun exec(command: String): ExecResult = withContext(Dispatchers.IO) {
        val session = client.startSession()
        val cmd = session.exec(command)
        val output = cmd.inputStream.bufferedReader().readText()
        val error = cmd.errorStream.bufferedReader().readText()
        cmd.join()
        val exitCode = cmd.exitStatus ?: -1
        session.close()
        ExecResult(output, error, exitCode)
    }

    suspend fun localForward(
        localPort: Int,
        remoteHost: String,
        remotePort: Int,
    ) = withContext(Dispatchers.IO) {
        val params = net.schmizz.sshj.connection.channel.forwarded.SocketForwardingConnectListener(
            java.net.InetSocketAddress(remoteHost, remotePort)
        )
        client.newLocalPortForwarder(
            net.schmizz.sshj.connection.channel.direct.LocalPortForwarder.Parameters(
                "127.0.0.1", localPort, remoteHost, remotePort
            ),
            java.net.ServerSocket(localPort)
        ).listen()
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

    override fun close() {
        runCatching { client.disconnect() }
        runCatching { client.close() }
    }
}

data class ShellHandle(
    val session: Session,
    val stdout: InputStream,
    val stdin: OutputStream,
    val stderr: InputStream,
) : Closeable {
    override fun close() {
        runCatching { session.close() }
    }

    fun resize(cols: Int, rows: Int) {
        session.reqWindowChange(cols, rows, 0, 0)
    }
}

data class ExecResult(
    val stdout: String,
    val stderr: String,
    val exitCode: Int,
)
