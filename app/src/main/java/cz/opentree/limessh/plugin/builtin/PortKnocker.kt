package cz.opentree.limessh.plugin.builtin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket

/**
 * Built-in Port Knocker — ported from the Apache-2.0 licensed
 * JuiceSSH PortKnocker plugin (github.com/Sonelli/juicessh-portknocker).
 *
 * Sends a sequence of TCP/UDP packets with optional pauses to
 * trigger firewall port opening before SSH connection.
 */
class PortKnocker {

    companion object {
        const val SOCKET_TIMEOUT_MS = 1000
    }

    /**
     * Execute a knock sequence against a target host.
     * Returns progress messages via the callback.
     */
    suspend fun knock(
        host: String,
        sequence: List<KnockStep>,
        onProgress: (String) -> Unit = {},
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val address = InetAddress.getByName(host)

            for (step in sequence) {
                when (step) {
                    is KnockStep.Tcp -> {
                        onProgress("Sending TCP to port ${step.port}")
                        try {
                            val socket = Socket()
                            socket.connect(InetSocketAddress(address, step.port), SOCKET_TIMEOUT_MS)
                            socket.close()
                        } catch (_: Exception) {
                            // Expected — TCP knock often gets connection refused or timeout
                        }
                    }
                    is KnockStep.Udp -> {
                        onProgress("Sending UDP to port ${step.port}")
                        val socket = DatagramSocket()
                        val packet = DatagramPacket(byteArrayOf(1), 1, address, step.port)
                        socket.send(packet)
                        socket.close()
                    }
                    is KnockStep.Pause -> {
                        onProgress("Pausing ${step.ms}ms")
                        delay(step.ms.toLong())
                    }
                }
            }

            onProgress("Knock sequence complete")
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

sealed class KnockStep {
    data class Tcp(val port: Int) : KnockStep()
    data class Udp(val port: Int) : KnockStep()
    data class Pause(val ms: Int) : KnockStep()
}

/**
 * A saved knock sequence associated with a connection.
 */
data class KnockSequence(
    val connectionId: String,
    val connectionName: String = "",
    val steps: List<KnockStep> = emptyList(),
) {
    /**
     * Parse a knock sequence from a compact string format:
     * "tcp:22,pause:500,udp:1194,tcp:443"
     */
    companion object {
        fun parse(spec: String): List<KnockStep> {
            return spec.split(",").mapNotNull { part ->
                val (type, value) = part.trim().split(":").let {
                    if (it.size == 2) it[0].lowercase() to it[1].toIntOrNull()
                    else return@mapNotNull null
                }
                when (type) {
                    "tcp" -> value?.let { KnockStep.Tcp(it) }
                    "udp" -> value?.let { KnockStep.Udp(it) }
                    "pause", "wait" -> value?.let { KnockStep.Pause(it) }
                    else -> null
                }
            }
        }
    }
}
