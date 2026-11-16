package cz.opentree.limessh.ssh

import net.schmizz.sshj.SSHClient
import net.schmizz.sshj.common.Buffer
import net.schmizz.sshj.common.KeyType
import net.schmizz.sshj.userauth.password.PasswordFinder
import net.schmizz.sshj.userauth.password.Resource
import java.security.MessageDigest
import java.util.Base64

/** Result of inspecting user-supplied private-key text. Never contains private key material. */
data class KeyInspection(
    val format: String,
    val encrypted: Boolean,
    val keyType: String,
    val publicKey: String,
    val fingerprint: String,
)

sealed interface KeyImportResult {
    data class Valid(val normalizedPem: String, val inspection: KeyInspection) : KeyImportResult
    /** The key is encrypted and no passphrase was supplied. */
    data class NeedsPassphrase(val normalizedPem: String, val format: String) : KeyImportResult
    data class Invalid(val message: String) : KeyImportResult
}

object KeyImport {
    const val MAX_BYTES = 256 * 1024

    private val privateHeaders = mapOf(
        "-----BEGIN OPENSSH PRIVATE KEY-----" to "OpenSSH",
        "-----BEGIN RSA PRIVATE KEY-----" to "PEM RSA",
        "-----BEGIN EC PRIVATE KEY-----" to "PEM EC",
        "-----BEGIN DSA PRIVATE KEY-----" to "PEM DSA",
        "-----BEGIN PRIVATE KEY-----" to "PKCS#8",
        "-----BEGIN ENCRYPTED PRIVATE KEY-----" to "PKCS#8 encrypted",
    )

    /** Reads at most [MAX_BYTES]; returns null when the stream is larger, without buffering the excess. */
    fun readLimited(input: java.io.InputStream): String? {
        val output = java.io.ByteArrayOutputStream()
        val buffer = ByteArray(8192)
        while (true) {
            val count = input.read(buffer)
            if (count < 0) break
            if (output.size() + count > MAX_BYTES) return null
            output.write(buffer, 0, count)
        }
        return output.toString("UTF-8")
    }

    /** Normalizes line endings and surrounding whitespace for pasted/imported text. */
    fun normalize(text: String): String =
        text.removePrefix("\uFEFF").replace("\r\n", "\n").replace('\r', '\n').trim() + "\n"

    /**
     * Validates [rawText] with the same parser used for login. A wrong passphrase or
     * unsupported format yields [KeyImportResult.Invalid] with user-actionable guidance.
     */
    fun inspect(rawText: String, passphrase: String?): KeyImportResult {
        if (rawText.length > MAX_BYTES) return KeyImportResult.Invalid("That file is too large to be an SSH private key.")
        val pem = normalize(rawText)
        val firstLine = pem.lineSequence().firstOrNull { it.isNotBlank() }.orEmpty().trim()
        if (pem.isBlank() || firstLine.isEmpty()) return KeyImportResult.Invalid("The key is empty.")
        if (firstLine.startsWith("PuTTY-User-Key-File-")) {
            return KeyImportResult.Invalid(
                "This is a PuTTY .ppk key. Convert it to OpenSSH format with PuTTYgen " +
                    "(Conversions → Export OpenSSH key) and import the converted file.")
        }
        if (firstLine.startsWith("ssh-") || firstLine.startsWith("ecdsa-") || firstLine.startsWith("sk-") ||
            firstLine == "-----BEGIN PUBLIC KEY-----" || firstLine.startsWith("---- BEGIN SSH2 PUBLIC KEY")) {
            return KeyImportResult.Invalid("This is a public key. Import the matching private key file (usually without the .pub extension).")
        }
        val format = privateHeaders[firstLine]
            ?: return KeyImportResult.Invalid("Unsupported key file. Use an OpenSSH, PEM or PKCS#8 private key.")
        val maybeEncrypted = firstLine.contains("ENCRYPTED") || pem.contains("Proc-Type: 4,ENCRYPTED") || isOpenSshEncrypted(pem)
        if (maybeEncrypted && passphrase.isNullOrEmpty()) return KeyImportResult.NeedsPassphrase(pem, format)

        SshCrypto.initialize()
        return try {
            val finder = object : PasswordFinder {
                override fun reqPassword(resource: Resource<*>?) = passphrase.orEmpty().toCharArray()
                override fun shouldRetry(resource: Resource<*>?) = false
            }
            val provider = SSHClient().loadKeys(pem, null, finder)
            val publicKey = provider.public
            val wire = Buffer.PlainBuffer().putPublicKey(publicKey).compactData
            val type = KeyType.fromKey(publicKey).toString()
            val line = "$type ${Base64.getEncoder().encodeToString(wire)}"
            val fingerprint = "SHA256:" + Base64.getEncoder().withoutPadding()
                .encodeToString(MessageDigest.getInstance("SHA-256").digest(wire))
            KeyImportResult.Valid(pem, KeyInspection(format, maybeEncrypted, type, line, fingerprint))
        } catch (e: Exception) {
            KeyImportResult.Invalid(
                if (maybeEncrypted) "The key could not be decrypted. Check the passphrase."
                else "The key could not be read. It may be damaged or use an unsupported algorithm.")
        }
    }

    /** Reads the OpenSSH container's cipher name without decrypting or exposing key data. */
    private fun isOpenSshEncrypted(pem: String): Boolean {
        if (!pem.startsWith("-----BEGIN OPENSSH PRIVATE KEY-----")) return false
        return try {
            val body = pem.lineSequence().filter { !it.startsWith("-----") }.joinToString("")
            val bytes = Base64.getMimeDecoder().decode(body)
            val magic = "openssh-key-v1\u0000".toByteArray(Charsets.US_ASCII)
            if (bytes.size < magic.size + 4 || !bytes.copyOfRange(0, magic.size).contentEquals(magic)) return false
            var offset = magic.size
            val length = ((bytes[offset].toInt() and 0xFF) shl 24) or ((bytes[offset + 1].toInt() and 0xFF) shl 16) or
                ((bytes[offset + 2].toInt() and 0xFF) shl 8) or (bytes[offset + 3].toInt() and 0xFF)
            offset += 4
            if (length < 0 || offset + length > bytes.size) return false
            String(bytes, offset, length, Charsets.US_ASCII) != "none"
        } catch (_: Exception) { false }
    }
}
