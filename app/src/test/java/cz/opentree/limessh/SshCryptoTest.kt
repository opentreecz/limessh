package cz.opentree.limessh

import cz.opentree.limessh.ssh.SshCrypto
import cz.opentree.limessh.ssh.SshEngine
import net.schmizz.sshj.common.SecurityUtils
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.security.NoSuchAlgorithmException
import java.security.Provider
import java.security.Security

class SshCryptoTest {
    private var previousProvider: Provider? = null
    private var previousPosition = 1
    private var previousSelection: String? = null

    @Before fun saveProviderState() {
        // Initialize SSHJ first so restoring its selection also restores a real provider.
        previousSelection = SecurityUtils.getSecurityProvider()
        previousProvider = Security.getProvider("BC")
        previousPosition = Security.getProviders().indexOf(previousProvider) + 1
    }

    @After fun restoreProviderState() {
        Security.removeProvider("BC")
        previousProvider?.let { Security.insertProviderAt(it, previousPosition) }
        SecurityUtils.setRegisterBouncyCastle(true)
        SecurityUtils.setSecurityProvider(previousSelection)
    }

    @Test fun engineReplacesSameNameProviderMissingX25519BeforeCreatingSshClient() {
        Security.removeProvider("BC")
        @Suppress("DEPRECATION")
        val reducedAndroidProvider = object : Provider("BC", 1.0, "Simulated reduced Android BC") {}
        Security.addProvider(reducedAndroidProvider)
        SecurityUtils.setSecurityProvider("BC")
        assertThrows(NoSuchAlgorithmException::class.java) {
            SecurityUtils.getKeyAgreement("X25519")
        }

        SshEngine().use {
            assertTrue(Security.getProvider("BC") is BouncyCastleProvider)
            assertEquals("BC", SecurityUtils.getSecurityProvider())
            assertEquals("BC", SecurityUtils.getKeyAgreement("X25519").provider.name)
            assertEquals("BC", SecurityUtils.getKeyFactory("X25519").provider.name)
        }
    }

    @Test fun sshjCanPerformBidirectionalX25519Agreement() {
        SshCrypto.initialize()
        val generator = SecurityUtils.getKeyPairGenerator("X25519")
        val alice = generator.generateKeyPair()
        val bob = generator.generateKeyPair()
        val aliceAgreement = SecurityUtils.getKeyAgreement("X25519").apply {
            init(alice.private); doPhase(bob.public, true)
        }
        val bobAgreement = SecurityUtils.getKeyAgreement("X25519").apply {
            init(bob.private); doPhase(alice.public, true)
        }
        val secret = aliceAgreement.generateSecret()
        assertEquals(32, secret.size)
        assertArrayEquals(secret, bobAgreement.generateSecret())
    }

    @Test fun repeatedInitializationReusesTheBundledProviderAndKeepsOtherProvidersInOrder() {
        SshCrypto.initialize()
        val provider = Security.getProvider("BC")
        val order = Security.getProviders().map { it.name }
        SshCrypto.initialize()
        assertSame(provider, Security.getProvider("BC"))
        assertEquals(order, Security.getProviders().map { it.name })
    }
}
