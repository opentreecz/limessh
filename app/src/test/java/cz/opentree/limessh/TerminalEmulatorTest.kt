package cz.opentree.limessh

import cz.opentree.limessh.ssh.TerminalEmulator
import org.junit.Assert.*
import org.junit.Test

class TerminalEmulatorTest {
    private fun TerminalEmulator.feed(text: String) {
        val bytes = text.toByteArray()
        processBytes(bytes, 0, bytes.size)
    }

    @Test fun utf8SurvivesArbitraryNetworkChunkBoundaries() {
        val terminal = TerminalEmulator(20, 4)
        "á🙂中".toByteArray().forEach { terminal.processBytes(byteArrayOf(it), 0, 1) }
        val screen = terminal.screenState.value.screen[0]
        assertEquals("á", screen[0].char)
        assertEquals("🙂", screen[1].char)
        assertEquals("", screen[2].char)
        assertEquals("中", screen[3].char)
        assertEquals(5, terminal.cursorCol)
    }

    @Test fun combiningMarksDoNotMoveTheCursor() {
        val terminal = TerminalEmulator(20, 4)
        terminal.feed("e\u0301x")
        assertEquals("e\u0301", terminal.screenState.value.screen[0][0].char)
        assertEquals("x", terminal.screenState.value.screen[0][1].char)
        assertEquals(2, terminal.cursorCol)
    }

    @Test fun resizeWhileInAlternateScreenPreservesTheMainBuffer() {
        val terminal = TerminalEmulator(20, 4)
        terminal.feed("main\u001b[?1049hother")
        terminal.resize(30, 6)
        terminal.feed("\u001b[?1049l")
        val screen = terminal.screenState.value.screen
        assertEquals(6, screen.size)
        assertEquals(30, screen[0].size)
        assertEquals("main", screen[0].take(4).joinToString("") { it.char })
        assertEquals(4, terminal.cursorCol)
    }

    @Test fun oscStringTerminatorDoesNotLeakIntoTheScreen() {
        val terminal = TerminalEmulator(20, 4)
        terminal.feed("\u001b]0;remote title\u001b\\X")
        assertEquals("X", terminal.screenState.value.screen[0][0].char)
    }

    @Test fun malformedUtf8DoesNotConsumeFollowingAscii() {
        val terminal = TerminalEmulator(20, 4)
        terminal.processBytes(byteArrayOf(0xC3.toByte(), 65), 0, 2)
        assertEquals("�", terminal.screenState.value.screen[0][0].char)
        assertEquals("A", terminal.screenState.value.screen[0][1].char)
    }

    @Test(timeout = 1000) fun enormousScrollAndInvalidRegionAreBounded() {
        val terminal = TerminalEmulator(20, 4)
        terminal.feed("\u001b[999999S\u001b[4;1r\u001b[999999Ttext")
        assertEquals(4, terminal.screenState.value.screen.size)
    }

    @Test fun screenSnapshotsAreNotMutatedByLaterInput() {
        val terminal = TerminalEmulator(20, 4)
        terminal.feed("a")
        val before = terminal.screenState.value
        terminal.feed("\rZ")
        assertEquals("a", before.screen[0][0].char)
        assertEquals("Z", terminal.screenState.value.screen[0][0].char)
    }

    @Test fun primaryDeviceAttributesReturnsVt100Response() {
        val outputs = mutableListOf<String>()
        val terminal = TerminalEmulator(20, 4, onOutput = { outputs.add(it.toString(Charsets.US_ASCII)) })

        terminal.feed("\u001b[c")
        assertEquals(listOf("\u001b[?1;2c"), outputs)

        terminal.feed("\u001b[0c")
        assertEquals(listOf("\u001b[?1;2c", "\u001b[?1;2c"), outputs)
    }

    @Test fun decPrivateTerminalIdEscZReturnsDeviceAttributes() {
        val outputs = mutableListOf<String>()
        val terminal = TerminalEmulator(20, 4, onOutput = { outputs.add(it.toString(Charsets.US_ASCII)) })

        terminal.feed("\u001bZ")
        assertEquals(listOf("\u001b[?1;2c"), outputs)
    }

    @Test fun deviceStatusReportReturnsOk() {
        val outputs = mutableListOf<String>()
        val terminal = TerminalEmulator(20, 4, onOutput = { outputs.add(it.toString(Charsets.US_ASCII)) })

        terminal.feed("\u001b[5n")
        assertEquals(listOf("\u001b[0n"), outputs)
    }

    @Test fun cursorPositionReportUsesOneIndexedCoordinates() {
        val outputs = mutableListOf<String>()
        val terminal = TerminalEmulator(20, 4, onOutput = { outputs.add(it.toString(Charsets.US_ASCII)) })

        // Origin (row 0, col 0) -> 1;1R
        terminal.feed("\u001b[6n")
        assertEquals(listOf("\u001b[1;1R"), outputs)

        // Move to row 3, col 7 -> 3;7R
        terminal.feed("\u001b[3;7H\u001b[6n")
        assertEquals(listOf("\u001b[1;1R", "\u001b[3;7R"), outputs)
    }

    @Test fun unsupportedQueriesProduceNoOutput() {
        val outputs = mutableListOf<String>()
        val terminal = TerminalEmulator(20, 4, onOutput = { outputs.add(it.toString(Charsets.US_ASCII)) })

        terminal.feed("\u001b[15n")
        terminal.feed("\u001b[2c")
        terminal.feed("\u001b[>c")
        assertTrue(outputs.isEmpty())
    }

    // R-011-REQ-01: getRow — visible screen rows and scrollback rows
    @Test fun getRowReturnsVisibleScreenRowForNonNegativeIndex() {
        val terminal = TerminalEmulator(cols = 10, rows = 4)
        terminal.feed("HELLO")
        val row = terminal.getRow(0)
        assertNotNull(row)
        assertEquals("H", row!![0].char)
        assertEquals("E", row[1].char)
    }

    @Test fun getRowReturnsNullForOutOfRangePositiveIndex() {
        val terminal = TerminalEmulator(cols = 10, rows = 4)
        assertNull(terminal.getRow(4))
        assertNull(terminal.getRow(100))
    }

    @Test fun getRowReturnsScrollbackRowForNegativeIndex() {
        // 2-row terminal: "ROW0\n" moves cursor to row 1; "ROW1\n" causes ROW0 to scroll into scrollback
        val terminal = TerminalEmulator(cols = 10, rows = 2)
        terminal.feed("ROW0\nROW1\n")    // second LF scrolls ROW0 into scrollback
        val row = terminal.getRow(-1)    // -1 = most recently pushed scrollback row
        assertNotNull("Expected a scrollback row after two-line scroll", row)
        // The pushed row should have contained "ROW0"
        assertEquals("R", row!![0].char)
        assertEquals("O", row[1].char)
        assertEquals("W", row[2].char)
        assertEquals("0", row[3].char)
    }

    @Test fun getRowReturnsNullForOutOfRangeNegativeIndex() {
        val terminal = TerminalEmulator(cols = 10, rows = 4)
        // No scrollback yet
        assertNull(terminal.getRow(-1))
        assertNull(terminal.getRow(-100))
    }

    @Test fun getRowScrollbackSizeMatchesSnapshotScrollbackSize() {
        val terminal = TerminalEmulator(cols = 10, rows = 2)
        repeat(5) { i -> terminal.feed("LINE$i\n") }
        val sbSize = terminal.screenState.value.scrollbackSize
        // getRow(-sbSize) should be the oldest row; getRow(-(sbSize+1)) should be null
        assertTrue(sbSize > 0)
        assertNotNull(terminal.getRow(-sbSize))
        assertNull(terminal.getRow(-(sbSize + 1)))
    }

    @Test fun getTranscriptTextContainsScrollbackAndScreen() {
        val terminal = TerminalEmulator(cols = 10, rows = 2)
        terminal.feed("LINE0\nLINE1\n")   // pushes LINE0 into scrollback
        val transcript = terminal.getTranscriptText()
        assertTrue("Transcript should contain LINE0", transcript.contains("LINE0"))
        assertTrue("Transcript should contain LINE1", transcript.contains("LINE1"))
    }
}
