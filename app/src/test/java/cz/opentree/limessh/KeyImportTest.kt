package cz.opentree.limessh

import cz.opentree.limessh.ssh.KeyImport
import cz.opentree.limessh.ssh.KeyImportResult
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters
import org.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil
import org.bouncycastle.openssl.jcajce.JcaPEMWriter
import org.bouncycastle.openssl.jcajce.JcePEMEncryptorBuilder
import org.junit.Assert.*
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.StringWriter
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.SecureRandom
import java.util.Base64

class KeyImportTest {
    private val rsa: KeyPair by lazy { KeyPairGenerator.getInstance("RSA").apply { initialize(2048) }.generateKeyPair() }

    private fun openSshEd25519(): String {
        val key = Ed25519PrivateKeyParameters(SecureRandom())
        return "-----BEGIN OPENSSH PRIVATE KEY-----\n" +
            Base64.getMimeEncoder(70, byteArrayOf(10)).encodeToString(OpenSSHPrivateKeyUtil.encodePrivateKey(key)) +
            "\n-----END OPENSSH PRIVATE KEY-----\n"
    }

    private fun pkcs8(pair: KeyPair) = "-----BEGIN PRIVATE KEY-----\n" +
        Base64.getMimeEncoder(64, byteArrayOf(10)).encodeToString(pair.private.encoded) + "\n-----END PRIVATE KEY-----\n"

    private fun encryptedPem(passphrase: String) = StringWriter().also { text ->
        JcaPEMWriter(text).use { it.writeObject(rsa, JcePEMEncryptorBuilder("AES-256-CBC").build(passphrase.toCharArray())) }
    }.toString()

    @Test fun importsAnUnencryptedOpenSshEd25519KeyAndReportsItsPublicDetails() {
        val result = KeyImport.inspect(openSshEd25519(), null) as KeyImportResult.Valid
        assertEquals("OpenSSH", result.inspection.format)
        assertEquals("ssh-ed25519", result.inspection.keyType)
        assertFalse(result.inspection.encrypted)
        assertTrue(result.inspection.publicKey.startsWith("ssh-ed25519 AAAA"))
        assertTrue(result.inspection.fingerprint.matches(Regex("SHA256:[A-Za-z0-9+/]{43}")))
        assertFalse(result.inspection.toString().contains("PRIVATE KEY"))
    }

    @Test fun importsPkcs8RsaAndMatchesTheRealPublicKeyFingerprint() {
        val result = KeyImport.inspect(pkcs8(rsa), null) as KeyImportResult.Valid
        assertEquals("PKCS#8", result.inspection.format)
        assertEquals("ssh-rsa", result.inspection.keyType)
        val repeated = KeyImport.inspect(pkcs8(rsa), null) as KeyImportResult.Valid
        assertEquals(result.inspection.fingerprint, repeated.inspection.fingerprint)
        val other = KeyImport.inspect(pkcs8(KeyPairGenerator.getInstance("RSA").apply { initialize(2048) }.generateKeyPair()), null) as KeyImportResult.Valid
        assertNotEquals(result.inspection.fingerprint, other.inspection.fingerprint)
    }

    @Test fun windowsLineEndingsBomAndSurroundingWhitespaceAreNormalized() {
        val messy = "\uFEFF  \r\n" + pkcs8(rsa).replace("\n", "\r\n") + "\r\n\r\n"
        val result = KeyImport.inspect(messy, null) as KeyImportResult.Valid
        assertFalse(result.normalizedPem.contains('\r'))
        assertTrue(result.normalizedPem.startsWith("-----BEGIN PRIVATE KEY-----"))
        assertTrue(result.normalizedPem.endsWith("-----END PRIVATE KEY-----\n"))
    }

    @Test fun encryptedKeyRequestsAPassphraseThenAcceptsTheCorrectOneOnly() {
        val pem = encryptedPem("correct horse")
        val needs = KeyImport.inspect(pem, null) as KeyImportResult.NeedsPassphrase
        assertEquals("PEM RSA", needs.format)
        assertTrue(KeyImport.inspect(pem, "") is KeyImportResult.NeedsPassphrase)
        val wrong = KeyImport.inspect(pem, "wrong passphrase") as KeyImportResult.Invalid
        assertTrue(wrong.message.contains("passphrase"))
        assertFalse(wrong.message.contains("wrong passphrase"))
        val valid = KeyImport.inspect(pem, "correct horse") as KeyImportResult.Valid
        assertTrue(valid.inspection.encrypted)
        assertEquals("ssh-rsa", valid.inspection.keyType)
    }

    @Test fun puttyAndPublicKeysAreRejectedWithActionableGuidance() {
        val ppk = KeyImport.inspect("PuTTY-User-Key-File-3: ssh-ed25519\nEncryption: none\n", null) as KeyImportResult.Invalid
        assertTrue(ppk.message.contains("PuTTYgen"))
        listOf("ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIExample user@host", "ecdsa-sha2-nistp256 AAAA user@host",
            "-----BEGIN PUBLIC KEY-----\nMFkw\n-----END PUBLIC KEY-----").forEach {
            val result = KeyImport.inspect(it, null) as KeyImportResult.Invalid
            assertTrue(it, result.message.contains("public key"))
        }
    }

    @Test fun emptyDamagedAndUnknownInputIsRejectedWithoutExposingTheInput() {
        assertTrue(KeyImport.inspect("", null) is KeyImportResult.Invalid)
        assertTrue(KeyImport.inspect(" \n\t ", null) is KeyImportResult.Invalid)
        val unknown = KeyImport.inspect("hello secret-text", null) as KeyImportResult.Invalid
        assertFalse(unknown.message.contains("secret-text"))
        val damaged = KeyImport.inspect("-----BEGIN OPENSSH PRIVATE KEY-----\nAAAA\n-----END OPENSSH PRIVATE KEY-----\n", null) as KeyImportResult.Invalid
        assertTrue(damaged.message.contains("could not be read"))
        val truncated = pkcs8(rsa).lines().take(3).joinToString("\n")
        assertTrue(KeyImport.inspect(truncated, null) is KeyImportResult.Invalid)
    }

    @Test fun oversizedInputIsRefusedWhileReading() {
        assertNull(KeyImport.readLimited(ByteArrayInputStream(ByteArray(KeyImport.MAX_BYTES + 1) { 'a'.code.toByte() })))
        assertEquals("small", KeyImport.readLimited(ByteArrayInputStream("small".toByteArray())))
        val oversized = KeyImport.inspect("a".repeat(KeyImport.MAX_BYTES + 1), null) as KeyImportResult.Invalid
        assertTrue(oversized.message.contains("too large"))
    }
}
