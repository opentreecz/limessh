package cz.opentree.limessh

import cz.opentree.limessh.data.backup.OpenSshExporter
import cz.opentree.limessh.domain.model.Connection
import cz.opentree.limessh.domain.model.Identity
import org.junit.Assert.*
import org.junit.Test

class OpenSshExporterTest {
    @Test fun exportPreservesIpv6AndIdentityUser() {
        val identity = Identity(username = "admin")
        val connection = Connection(nickname = "My server", address = "2001:db8::1", port = 2222, identityId = identity.id)
        val text = OpenSshExporter.export(listOf(connection), listOf(identity))
        assertTrue(text.contains("Host My-server-"))
        assertTrue(text.contains("HostName \"2001:db8::1\""))
        assertTrue(text.contains("Port 2222"))
        assertTrue(text.contains("User \"admin\""))
        assertFalse(text.contains("IdentityFile"))
    }

    @Test fun hostFieldsCannotInjectOpenSshDirectives() {
        assertThrows(IllegalArgumentException::class.java) {
            OpenSshExporter.export(listOf(Connection(address = "host\nProxyCommand evil")), emptyList())
        }
    }

    @Test fun duplicateNicknamesGetDistinctStableAliases() {
        val connections = listOf(Connection(nickname = "server", address = "one"), Connection(nickname = "server", address = "two"))
        val aliases = OpenSshExporter.export(connections, emptyList()).lines().filter { it.startsWith("Host ") }
        assertEquals(2, aliases.toSet().size)
    }
}
