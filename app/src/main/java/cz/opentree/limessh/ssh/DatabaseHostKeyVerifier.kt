package cz.opentree.limessh.ssh

import cz.opentree.limessh.data.local.dao.KnownHostDao
import cz.opentree.limessh.data.local.entity.KnownHostEntity
import kotlinx.coroutines.runBlocking
import net.schmizz.sshj.transport.verification.HostKeyVerifier
import java.security.PublicKey
import java.util.Base64
import java.security.MessageDigest
import net.schmizz.sshj.common.Buffer

/**
 * Host key verifier backed by Room database instead of ~/.ssh/known_hosts.
 * Defers to [promptCallback] for unknown/changed keys so the UI can ask the user.
 */
class DatabaseHostKeyVerifier(
    private val knownHostDao: KnownHostDao,
    private val promptCallback: suspend (HostKeyEvent) -> Boolean,
) : HostKeyVerifier {

    override fun verify(hostname: String, port: Int, key: PublicKey): Boolean {
        return runBlocking {
            val keyType = net.schmizz.sshj.common.KeyType.fromKey(key).toString()
            val keyEncoded = Base64.getEncoder().encodeToString(key.encoded)
            val wireKey = Buffer.PlainBuffer().putPublicKey(key).compactData
            val fingerprint = "SHA256:" + Base64.getEncoder().withoutPadding()
                .encodeToString(MessageDigest.getInstance("SHA-256").digest(wireKey))
            val existing = knownHostDao.findByHostAndPort(hostname, port)

            when {
                existing.isEmpty() -> {
                    val accepted = promptCallback(
                        HostKeyEvent.Unknown(hostname, port, keyType, fingerprint)
                    )
                    if (accepted) {
                        knownHostDao.upsert(
                            KnownHostEntity(
                                hostname = hostname, port = port,
                                keyType = keyType, publicKey = keyEncoded,
                            )
                        )
                    }
                    accepted
                }

                existing.any { (it.keyType == keyType || it.keyType == key.algorithm) && it.publicKey == keyEncoded } -> true

                else -> {
                    val accepted = promptCallback(
                        HostKeyEvent.Changed(hostname, port, keyType, fingerprint)
                    )
                    if (accepted) {
                        knownHostDao.deleteByHostAndPort(hostname, port)
                        knownHostDao.upsert(
                            KnownHostEntity(
                                hostname = hostname, port = port,
                                keyType = keyType, publicKey = keyEncoded,
                            )
                        )
                    }
                    accepted
                }
            }
        }
    }

    override fun findExistingAlgorithms(hostname: String, port: Int): List<String> {
        return runBlocking {
            knownHostDao.findByHostAndPort(hostname, port).map { it.keyType }
        }
    }
}

sealed class HostKeyEvent {
    abstract val hostname: String
    abstract val port: Int
    abstract val keyType: String
    abstract val keyFingerprint: String

    data class Unknown(
        override val hostname: String, override val port: Int,
        override val keyType: String, override val keyFingerprint: String,
    ) : HostKeyEvent()

    data class Changed(
        override val hostname: String, override val port: Int,
        override val keyType: String, override val keyFingerprint: String,
    ) : HostKeyEvent()
}
