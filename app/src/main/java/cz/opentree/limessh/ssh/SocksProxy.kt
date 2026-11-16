package cz.opentree.limessh.ssh

import net.schmizz.sshj.connection.channel.direct.DirectConnection
import java.io.Closeable
import java.io.DataInputStream
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Semaphore
import kotlin.concurrent.thread

/** Loopback-only SOCKS5 CONNECT proxy. Domain names are resolved by the SSH server. */
class SocksProxy(
    port: Int,
    private val connect: (String, Int) -> DirectConnection,
) : Closeable {
    private val listener = ServerSocket()
    private val resources = ConcurrentHashMap.newKeySet<Closeable>()
    private val permits = Semaphore(16)

    init {
        require(port in 1..65535)
        listener.bind(InetSocketAddress("127.0.0.1", port))
        thread(name = "limessh-socks", isDaemon = true) {
            while (!listener.isClosed) {
                val socket = try { listener.accept() } catch (_: Exception) { break }
                if (!permits.tryAcquire()) {
                    socket.close()
                    continue
                }
                resources.add(socket)
                thread(name = "limessh-socks-client", isDaemon = true) {
                    try { serve(socket) } catch (_: Exception) { /* Peer closed or rejected. */ }
                    finally {
                        resources.remove(socket)
                        runCatching { socket.close() }
                        permits.release()
                    }
                }
            }
        }
    }

    private fun serve(socket: Socket) {
        socket.soTimeout = 15_000
        val input = DataInputStream(socket.getInputStream())
        val output = socket.getOutputStream()
        require(input.readUnsignedByte() == 5) { "SOCKS5 required" }
        val methods = ByteArray(input.readUnsignedByte()).also { input.readFully(it) }
        if (0.toByte() !in methods) {
            output.write(byteArrayOf(5, 0xFF.toByte()))
            return
        }
        output.write(byteArrayOf(5, 0))
        output.flush()
        require(input.readUnsignedByte() == 5)
        val command = input.readUnsignedByte()
        require(input.readUnsignedByte() == 0)
        val host = when (input.readUnsignedByte()) {
            1 -> InetAddress.getByAddress(ByteArray(4).also { input.readFully(it) }).hostAddress!!
            3 -> String(ByteArray(input.readUnsignedByte()).also { input.readFully(it) }, Charsets.US_ASCII)
            4 -> InetAddress.getByAddress(ByteArray(16).also { input.readFully(it) }).hostAddress!!
            else -> { reply(output, 8); return }
        }
        val port = input.readUnsignedShort()
        if (command != 1) { reply(output, 7); return }
        val channel = try { connect(host, port) } catch (_: Exception) { reply(output, 5); return }
        resources.add(channel)
        try {
            reply(output, 0)
            socket.soTimeout = 0
            val writer = thread(name = "limessh-socks-upload", isDaemon = true) {
                try { input.copyTo(channel.outputStream) }
                catch (_: Exception) {}
                finally { runCatching { channel.outputStream.close() } }
            }
            try { channel.inputStream.copyTo(output) }
            finally {
                channel.close()
                socket.close()
                writer.join(1000)
            }
        } finally {
            resources.remove(channel)
            runCatching { channel.close() }
        }
    }

    private fun reply(output: java.io.OutputStream, code: Int) {
        output.write(byteArrayOf(5, code.toByte(), 0, 1, 0, 0, 0, 0, 0, 0))
        output.flush()
    }

    override fun close() {
        listener.close()
        resources.forEach { runCatching { it.close() } }
        resources.clear()
    }
}
