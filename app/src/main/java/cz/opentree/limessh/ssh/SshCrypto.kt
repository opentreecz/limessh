package cz.opentree.limessh.ssh

import net.schmizz.sshj.common.SecurityUtils
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security

/** Installs the bundled provider before SSHJ selects algorithms by provider name. */
internal object SshCrypto {
    @Synchronized
    fun initialize() {
        val name = BouncyCastleProvider.PROVIDER_NAME
        if (Security.getProvider(name) !is BouncyCastleProvider) {
            // Android ships a reduced, differently packaged provider named "BC".
            // SSHJ otherwise probes a new BC instance but then uses the old one
            // by name, which lacks X25519. Construct first, then replace only BC.
            val provider = BouncyCastleProvider()
            Security.removeProvider(name)
            check(Security.addProvider(provider) != -1) { "Cannot register SSH crypto provider" }
        }
        // Keep AndroidKeyStore/Conscrypt and other providers in their relative order.
        // Select the full bundled BC provider specifically for SSHJ operations.
        SecurityUtils.setRegisterBouncyCastle(false)
        SecurityUtils.setSecurityProvider(name)
    }
}
