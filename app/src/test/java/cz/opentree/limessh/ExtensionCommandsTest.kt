package cz.opentree.limessh

import cz.opentree.limessh.plugin.builtin.ExtensionCommands
import cz.opentree.limessh.plugin.builtin.KnockSequence
import cz.opentree.limessh.plugin.builtin.KnockStep
import org.junit.Assert.*
import org.junit.Test

class ExtensionCommandsTest {
    @Test fun vpnCountryCannotInjectShellSyntax() {
        assertEquals("sudo -n openpyn --daemon cz", ExtensionCommands.vpnConnect("CZ"))
        listOf("cz;id", "--help", "c z", "", "cz\n", "$(id)").forEach { input ->
            assertThrows(IllegalArgumentException::class.java) { ExtensionCommands.vpnConnect(input) }
        }
    }

    @Test fun knockParserPreservesProtocolsAndTiming() {
        assertEquals(listOf(KnockStep.Tcp(7000), KnockStep.Pause(200), KnockStep.Udp(8000)),
            KnockSequence.parse("tcp:7000,pause:200,udp:8000"))
    }

    @Test fun malformedKnocksAreRejectedInsteadOfSilentlyChangingTheSequence() {
        listOf("", "tcp:0", "tcp:65536", "pause:-1", "pause:60001", "tcp:22,bad:4", "tcp:22,").forEach { input ->
            assertThrows(IllegalArgumentException::class.java) { KnockSequence.parse(input) }
        }
    }
}
