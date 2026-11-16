package cz.opentree.limessh

import cz.opentree.limessh.ssh.AuthenticationFailure
import cz.opentree.limessh.ssh.SshEngine
import kotlinx.coroutines.runBlocking
import net.schmizz.sshj.transport.verification.HostKeyVerifier
import org.apache.sshd.common.keyprovider.KeyPairProvider
import org.apache.sshd.core.CoreModuleProperties
import org.apache.sshd.server.SshServer
import org.apache.sshd.server.auth.keyboard.InteractiveChallenge
import org.apache.sshd.server.auth.keyboard.KeyboardInteractiveAuthenticator
import org.apache.sshd.server.auth.keyboard.UserAuthKeyboardInteractiveFactory
import org.apache.sshd.server.auth.password.UserAuthPasswordFactory
import org.apache.sshd.server.auth.pubkey.UserAuthPublicKeyFactory
import org.apache.sshd.server.session.ServerSession
import org.bouncycastle.openssl.jcajce.JcaPEMWriter
import org.bouncycastle.openssl.jcajce.JcePEMEncryptorBuilder
import org.junit.Assert.*
import org.junit.Test
import java.io.StringWriter
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PublicKey
import java.util.Base64

/** Real SSH transport/auth exchange over loopback; never touches external hosts/accounts. */
class SshAuthenticationIntegrationTest {
    private val hostKey = rsaKey()
    private val userKey = rsaKey()

    private fun withServer(configure: (SshServer) -> Unit = {}, test: suspend (SshEngine) -> Unit) = runBlocking {
        val server = SshServer.setUpDefaultServer().apply {
            host = "127.0.0.1"
            port = 0
            keyPairProvider = KeyPairProvider.wrap(hostKey)
            userAuthFactories = listOf(UserAuthPasswordFactory.INSTANCE)
            passwordAuthenticator = org.apache.sshd.server.auth.password.PasswordAuthenticator { user, password, _ ->
                user == "operator" && password == "test-password"
            }
            publickeyAuthenticator = org.apache.sshd.server.auth.pubkey.PublickeyAuthenticator { user, key, _ ->
                user == "operator" && key.encoded.contentEquals(userKey.public.encoded)
            }
        }
        configure(server)
        val engine = SshEngine()
        try {
            server.start()
            engine.setHostKeyVerifier(object : HostKeyVerifier {
                override fun verify(hostname: String, port: Int, key: PublicKey) = key.encoded.contentEquals(hostKey.public.encoded)
                override fun findExistingAlgorithms(hostname: String, port: Int) = emptyList<String>()
            })
            engine.connect("127.0.0.1", server.port)
            test(engine)
        } finally { engine.close(); server.stop(true) }
    }

    @Test(timeout = 30000) fun passwordAuthenticatesToALocalServer() = withServer { engine ->
        engine.authPassword("operator", "test-password")
        assertTrue(engine.isAuthenticated)
    }

    @Test(timeout = 30000) fun missingPasswordIsRequestedInsteadOfSendingAnEmptyString() = withServer { engine ->
        val prompts = mutableListOf<String>()
        engine.authPassword("operator", null) { prompt, echo ->
            assertFalse(echo)
            prompts += prompt
            "test-password"
        }
        assertTrue(engine.isAuthenticated)
        assertEquals(1, prompts.size)
    }

    @Test(timeout = 30000) fun wrongPasswordReportsTheActualUserAndRemainingMethods() = withServer { engine ->
        try {
            engine.authPassword("operator", "incorrect-test-password")
            fail("Wrong password must not authenticate")
        } catch (e: AuthenticationFailure) {
            assertTrue(e.message!!.contains("operator"))
            assertTrue(e.message!!.contains("password"))
            assertFalse(e.message!!.contains("incorrect-test-password"))
        }
        assertFalse(engine.isAuthenticated)
    }

    @Test(timeout = 30000) fun pkcs8PrivateKeyAuthenticatesToAKeyOnlyServer() = withServer({ server ->
        server.userAuthFactories = listOf(UserAuthPublicKeyFactory.INSTANCE)
    }) { engine ->
        engine.authPrivateKey("operator", pkcs8(userKey), null)
        assertTrue(engine.isAuthenticated)
    }

    @Test(timeout = 30000) fun encryptedPrivateKeyRequestsItsPassphrase() = withServer({ server ->
        server.userAuthFactories = listOf(UserAuthPublicKeyFactory.INSTANCE)
    }) { engine ->
        val pem = StringWriter().also { text ->
            JcaPEMWriter(text).use { writer ->
                writer.writeObject(userKey, JcePEMEncryptorBuilder("AES-256-CBC").build("key-passphrase".toCharArray()))
            }
        }.toString()
        var prompts = 0
        engine.authPrivateKey("operator", pem, null) { _, echo ->
            assertFalse(echo)
            prompts++
            "key-passphrase"
        }
        assertTrue(engine.isAuthenticated)
        assertEquals(1, prompts)
    }

    @Test(timeout = 30000) fun openSshEd25519PrivateKeyAuthenticates() {
        val privateKey = org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters(java.security.SecureRandom())
        val publicEncoding = org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory
            .createSubjectPublicKeyInfo(privateKey.generatePublicKey()).encoded
        val encoded = org.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil.encodePrivateKey(privateKey)
        val pem = "-----BEGIN OPENSSH PRIVATE KEY-----\n" +
            Base64.getMimeEncoder(64, byteArrayOf(10)).encodeToString(encoded) + "\n-----END OPENSSH PRIVATE KEY-----\n"
        withServer({ server ->
            server.userAuthFactories = listOf(UserAuthPublicKeyFactory.INSTANCE)
            server.publickeyAuthenticator = org.apache.sshd.server.auth.pubkey.PublickeyAuthenticator { user, key, _ ->
                user == "operator" && key.encoded.contentEquals(publicEncoding)
            }
        }) { engine ->
            engine.authPrivateKey("operator", pem, null)
            assertTrue(engine.isAuthenticated)
        }
    }

    @Test(timeout = 30000) fun rejectedKeyDoesNotFallBackToAnAccountPassword() = withServer({ server ->
        server.userAuthFactories = listOf(UserAuthPublicKeyFactory.INSTANCE, UserAuthPasswordFactory.INSTANCE)
        CoreModuleProperties.AUTH_METHODS.set(server, "publickey,password")
    }) { engine ->
        var prompts = 0
        try {
            engine.authPrivateKey("operator", pkcs8(rsaKey()), null) { _, _ -> prompts++; "test-password" }
            fail("An unauthorized key must not authenticate")
        } catch (e: AuthenticationFailure) {
            assertTrue(e.message!!.contains("key's public key is authorized"))
        }
        assertEquals(0, prompts)
        assertFalse(engine.isAuthenticated)
    }

    @Test(timeout = 30000) fun keyAcceptedAsFirstFactorCanContinueWithAnAccountPassword() = withServer({ server ->
        server.userAuthFactories = listOf(UserAuthPublicKeyFactory.INSTANCE, UserAuthPasswordFactory.INSTANCE)
        CoreModuleProperties.AUTH_METHODS.set(server, "publickey,password")
    }) { engine ->
        var prompts = 0
        engine.authPrivateKey("operator", pkcs8(userKey), null) { prompt, _ ->
            assertTrue(prompt.contains("account password"))
            prompts++
            "test-password"
        }
        assertTrue(engine.isAuthenticated)
        assertEquals(1, prompts)
    }

    @Test(timeout = 30000) fun rejectedSecondFactorDoesNotMisreportAnAcceptedKeyAsUnauthorized() = withServer({ server ->
        server.userAuthFactories = listOf(UserAuthPublicKeyFactory.INSTANCE, UserAuthPasswordFactory.INSTANCE)
        CoreModuleProperties.AUTH_METHODS.set(server, "publickey,password")
    }) { engine ->
        try {
            engine.authPrivateKey("operator", pkcs8(userKey), null) { _, _ -> "incorrect-second-factor" }
            fail("Wrong second factor must not authenticate")
        } catch (e: AuthenticationFailure) {
            assertTrue(e.message!!.contains("One factor was accepted"))
            assertFalse(e.message!!.contains("this key's public key is authorized"))
            assertFalse(e.message!!.contains("incorrect-second-factor"))
        }
    }

    @Test(timeout = 30000) fun passwordModeHandlesAKeyboardInteractivePasswordAndOtp() = withServer({ server ->
        server.userAuthFactories = listOf(UserAuthKeyboardInteractiveFactory.INSTANCE)
        server.keyboardInteractiveAuthenticator = object : KeyboardInteractiveAuthenticator {
            override fun generateChallenge(session: ServerSession, username: String, lang: String, submethods: String) =
                InteractiveChallenge().apply {
                    interactionName = "Test authentication"
                    interactionInstruction = "Password and OTP"
                    languageTag = "en"
                    addPrompt("Password:", false)
                    addPrompt("Verification code:", false)
                }
            override fun authenticate(session: ServerSession, username: String, responses: List<String>) =
                username == "operator" && responses == listOf("test-password", "123456")
        }
    }) { engine ->
        val prompts = mutableListOf<String>()
        engine.authPassword("operator", "test-password") { prompt, _ -> prompts += prompt; "123456" }
        assertTrue(engine.isAuthenticated)
        assertEquals(listOf("Verification code:"), prompts)
    }

    @Test(timeout = 30000) fun passwordLoginToAKeyOnlyServerExplainsTheMismatch() = withServer({ server ->
        server.userAuthFactories = listOf(UserAuthPublicKeyFactory.INSTANCE)
    }) { engine ->
        try {
            engine.authPassword("operator", "test-password")
            fail("Password authentication must not succeed on a key-only server")
        } catch (e: AuthenticationFailure) {
            assertTrue(e.message!!.contains("publickey"))
            assertTrue(e.message!!.contains("not offering password login"))
        }
    }

    private fun rsaKey() = KeyPairGenerator.getInstance("RSA").apply { initialize(2048) }.generateKeyPair()

    private fun pkcs8(pair: KeyPair) = "-----BEGIN PRIVATE KEY-----\n" +
        Base64.getMimeEncoder(64, byteArrayOf(10)).encodeToString(pair.private.encoded) + "\n-----END PRIVATE KEY-----\n"
}
