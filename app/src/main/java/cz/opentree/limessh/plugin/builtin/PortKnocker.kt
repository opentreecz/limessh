package cz.opentree.limessh.plugin.builtin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket

/**
 * Original port-knocking adapter implementing the researched TCP/UDP workflow.
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
            require(sequence.isNotEmpty() && sequence.size <= 128) { "Use between 1 and 128 knock steps" }
            sequence.forEach { step ->
                when (step) {
                    is KnockStep.Tcp -> require(step.port in 1..65535) { "Invalid TCP port" }
                    is KnockStep.Udp -> require(step.port in 1..65535) { "Invalid UDP port" }
                    is KnockStep.Pause -> require(step.ms in 0..60000) { "Pause must be 0–60000ms" }
                }
            }
            val address = InetAddress.getByName(host)

            for (step in sequence) {
                currentCoroutineContext().ensureActive()
                when (step) {
                    is KnockStep.Tcp -> {
                        onProgress("Sending TCP to port ${step.port}")
                        try {
                            Socket().use { it.connect(InetSocketAddress(address, step.port), SOCKET_TIMEOUT_MS) }
                        } catch (_: Exception) {
                            // Expected — TCP knock often gets connection refused or timeout
                        }
                    }
                    is KnockStep.Udp -> {
                        onProgress("Sending UDP to port ${step.port}")
                        val packet = DatagramPacket(byteArrayOf(1), 1, address, step.port)
                        DatagramSocket().use { it.send(packet) }
                    }
                    is KnockStep.Pause -> {
                        onProgress("Pausing ${step.ms}ms")
                        delay(step.ms.toLong())
                    }
                }
            }

            onProgress("Knock sequence complete")
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
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
            require(spec.isNotBlank()) { "Knock sequence is empty" }
            return spec.split(",").map { part ->
                val (type, value) = part.trim().split(":").let {
                    if (it.size == 2) it[0].lowercase() to it[1].toIntOrNull()
                    else throw IllegalArgumentException("Invalid knock step: $part")
                }
                when (type) {
                    "tcp" -> KnockStep.Tcp(requireNotNull(value) { "Invalid TCP port" }.also { require(it in 1..65535) })
                    "udp" -> KnockStep.Udp(requireNotNull(value) { "Invalid UDP port" }.also { require(it in 1..65535) })
                    "pause", "wait" -> KnockStep.Pause(requireNotNull(value) { "Invalid pause" }.also { require(it in 0..60000) })
                    else -> throw IllegalArgumentException("Unknown knock step: $type")
                }
            }
        }
    }
}
