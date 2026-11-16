package cz.opentree.limessh

import androidx.test.ext.junit.runners.AndroidJUnit4
import cz.opentree.limessh.ssh.SshEngine
import net.schmizz.sshj.common.SecurityUtils
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.security.Security

@RunWith(AndroidJUnit4::class)
class SshCryptoAndroidTest {
    @Test fun sshCryptoSupportsX25519WithoutReplacingAndroidKeyStore() {
        val keyStoreProvider = Security.getProvider("AndroidKeyStore")
        assertNotNull(keyStoreProvider)
        SshEngine().use {
            assertSame(keyStoreProvider, Security.getProvider("AndroidKeyStore"))
            assertTrue(Security.getProvider("BC") is BouncyCastleProvider)
            val generator = SecurityUtils.getKeyPairGenerator("X25519")
            val alice = generator.generateKeyPair()
            val bob = generator.generateKeyPair()
            val first = SecurityUtils.getKeyAgreement("X25519").apply {
                init(alice.private); doPhase(bob.public, true)
            }.generateSecret()
            val second = SecurityUtils.getKeyAgreement("X25519").apply {
                init(bob.private); doPhase(alice.public, true)
            }.generateSecret()
            assertEquals(32, first.size)
            assertArrayEquals(first, second)
        }
    }
}
