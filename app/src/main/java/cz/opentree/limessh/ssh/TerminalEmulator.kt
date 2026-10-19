package cz.opentree.limessh.ssh

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.InputStream

/**
 * VT100/xterm terminal emulator.
 *
 * Processes raw byte stream from SSH shell and maintains a screen buffer.
 * Supports: cursor movement, scrolling, alternate screen, colors (256 + truecolor),
 * wide characters, line wrapping, scroll regions, and common escape sequences.
 */
class TerminalEmulator(
    private var cols: Int = 80,
    private var rows: Int = 24,
) {
    // Screen buffer: rows x cols of cells
    private var screen = Array(rows) { Array(cols) { TermCell() } }
    private var altScreen = Array(rows) { Array(cols) { TermCell() } }
    private var useAltScreen = false

    // Scrollback
    private val scrollback = mutableListOf<Array<TermCell>>()
    val maxScrollback = 10_000

    // Cursor position
    var cursorRow = 0; private set
    var cursorCol = 0; private set
    var cursorVisible = true; private set

    // Scroll region
    private var scrollTop = 0
    private var scrollBottom = rows - 1

    // Current text attributes
    private var currentAttr = CellAttr()

    // Parse state
    private var parseState = ParseState.GROUND
    private val escBuffer = StringBuilder()

    // State flow for UI to observe
    private val _screenState = MutableStateFlow(ScreenSnapshot(screen, cursorRow, cursorCol, cursorVisible, scrollback.size))
    val screenState: StateFlow<ScreenSnapshot> = _screenState.asStateFlow()

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    /**
     * Start reading from an SSH shell input stream and processing bytes.
     */
    fun attachInput(inputStream: InputStream) {
        scope.launch {
            val buf = ByteArray(8192)
            try {
                while (isActive) {
                    val n = inputStream.read(buf)
                    if (n <= 0) break
                    processBytes(buf, 0, n)
                    emitSnapshot()
                }
            } catch (_: Exception) {}
        }
    }

    fun detach() {
        scope.cancel()
    }

    fun resize(newCols: Int, newRows: Int) {
        val newScreen = Array(newRows) { r ->
            Array(newCols) { c ->
                if (r < rows && c < cols) currentScreen()[r][c] else TermCell()
            }
        }
        if (useAltScreen) altScreen = newScreen else screen = newScreen
        cols = newCols
        rows = newRows
        scrollTop = 0
        scrollBottom = rows - 1
        cursorRow = cursorRow.coerceIn(0, rows - 1)
        cursorCol = cursorCol.coerceIn(0, cols - 1)
        emitSnapshot()
    }

    private fun currentScreen() = if (useAltScreen) altScreen else screen

    @Synchronized
    fun processBytes(data: ByteArray, offset: Int, length: Int) {
        for (i in offset until offset + length) {
            processByte(data[i].toInt() and 0xFF)
        }
    }

    private fun processByte(b: Int) {
        when (parseState) {
            ParseState.GROUND -> processGround(b)
            ParseState.ESCAPE -> processEscape(b)
            ParseState.CSI -> processCsi(b)
            ParseState.OSC -> processOsc(b)
        }
    }

    private fun processGround(b: Int) {
        when (b) {
            0x1B -> { parseState = ParseState.ESCAPE; escBuffer.clear() }
            0x07 -> {} // Bell
            0x08 -> { cursorCol = (cursorCol - 1).coerceAtLeast(0) } // Backspace
            0x09 -> { cursorCol = ((cursorCol / 8) + 1) * 8; if (cursorCol >= cols) cursorCol = cols - 1 } // Tab
            0x0A, 0x0B, 0x0C -> lineFeed() // LF, VT, FF
            0x0D -> { cursorCol = 0 } // CR
            else -> {
                if (b >= 0x20) {
                    putChar(b.toChar())
                }
            }
        }
    }

    private fun processEscape(b: Int) {
        when (b.toChar()) {
            '[' -> { parseState = ParseState.CSI; escBuffer.clear() }
            ']' -> { parseState = ParseState.OSC; escBuffer.clear() }
            '(' -> { parseState = ParseState.GROUND } // charset select, skip next byte
            ')' -> { parseState = ParseState.GROUND }
            '7' -> { /* save cursor */ parseState = ParseState.GROUND }
            '8' -> { /* restore cursor */ parseState = ParseState.GROUND }
            'D' -> { lineFeed(); parseState = ParseState.GROUND }
            'M' -> { reverseLineFeed(); parseState = ParseState.GROUND }
            'c' -> { reset(); parseState = ParseState.GROUND }
            else -> { parseState = ParseState.GROUND }
        }
    }

    private fun processCsi(b: Int) {
        val ch = b.toChar()
        if (ch in '0'..'9' || ch == ';' || ch == '?' || ch == '>' || ch == '!') {
            escBuffer.append(ch)
            return
        }
        // Final character
        val params = escBuffer.toString()
        executeCsi(ch, params)
        parseState = ParseState.GROUND
    }

    private fun processOsc(b: Int) {
        if (b == 0x07 || b == 0x1B) { // BEL or ESC terminates OSC
            parseState = ParseState.GROUND
        }
        // OSC content ignored for now (window title, etc.)
    }

    private fun executeCsi(cmd: Char, params: String) {
        val parts = params.replace("?", "").split(";").map { it.toIntOrNull() ?: 0 }
        val p1 = parts.getOrElse(0) { 0 }
        val p2 = parts.getOrElse(1) { 0 }

        when (cmd) {
            'A' -> cursorRow = (cursorRow - p1.coerceAtLeast(1)).coerceAtLeast(0) // Up
            'B' -> cursorRow = (cursorRow + p1.coerceAtLeast(1)).coerceAtMost(rows - 1) // Down
            'C' -> cursorCol = (cursorCol + p1.coerceAtLeast(1)).coerceAtMost(cols - 1) // Right
            'D' -> cursorCol = (cursorCol - p1.coerceAtLeast(1)).coerceAtLeast(0) // Left
            'H', 'f' -> { // Cursor position
                cursorRow = (p1 - 1).coerceIn(0, rows - 1)
                cursorCol = ((if (parts.size > 1) p2 else 1) - 1).coerceIn(0, cols - 1)
            }
            'J' -> { // Erase display
                when (p1) {
                    0 -> eraseBelow()
                    1 -> eraseAbove()
                    2, 3 -> eraseScreen()
                }
            }
            'K' -> { // Erase line
                when (p1) {
                    0 -> eraseLineRight()
                    1 -> eraseLineLeft()
                    2 -> eraseLine()
                }
            }
            'L' -> insertLines(p1.coerceAtLeast(1)) // Insert lines
            'M' -> deleteLines(p1.coerceAtLeast(1)) // Delete lines
            'P' -> deleteChars(p1.coerceAtLeast(1)) // Delete characters
            '@' -> insertChars(p1.coerceAtLeast(1)) // Insert characters
            'S' -> scrollUp(p1.coerceAtLeast(1)) // Scroll up
            'T' -> scrollDown(p1.coerceAtLeast(1)) // Scroll down
            'r' -> { // Set scroll region
                scrollTop = (p1 - 1).coerceIn(0, rows - 1)
                scrollBottom = ((if (parts.size > 1 && p2 > 0) p2 else rows) - 1).coerceIn(0, rows - 1)
                cursorRow = 0; cursorCol = 0
            }
            'm' -> processSgr(parts) // Set graphic rendition
            'h' -> { // Set mode
                if (params.startsWith("?")) {
                    when (p1) {
                        25 -> cursorVisible = true
                        1049, 47, 1047 -> { useAltScreen = true; altScreen = Array(rows) { Array(cols) { TermCell() } } }
                    }
                }
            }
            'l' -> { // Reset mode
                if (params.startsWith("?")) {
                    when (p1) {
                        25 -> cursorVisible = false
                        1049, 47, 1047 -> { useAltScreen = false }
                    }
                }
            }
            'd' -> cursorRow = (p1 - 1).coerceIn(0, rows - 1) // Vertical position absolute
            'G', '`' -> cursorCol = (p1 - 1).coerceIn(0, cols - 1) // Horizontal position absolute
            'X' -> { // Erase characters
                val n = p1.coerceAtLeast(1)
                for (i in 0 until n) {
                    val c = cursorCol + i
                    if (c < cols) currentScreen()[cursorRow][c] = TermCell()
                }
            }
            'n' -> {} // Device status report (ignore, we'd need to write back)
            'c' -> {} // Device attributes (ignore)
            't' -> {} // Window manipulation (ignore)
        }
    }

    private fun processSgr(params: List<Int>) {
        var i = 0
        while (i < params.size) {
            when (val p = params[i]) {
                0 -> currentAttr = CellAttr()
                1 -> currentAttr = currentAttr.copy(bold = true)
                2 -> currentAttr = currentAttr.copy(dim = true)
                3 -> currentAttr = currentAttr.copy(italic = true)
                4 -> currentAttr = currentAttr.copy(underline = true)
                5, 6 -> currentAttr = currentAttr.copy(blink = true)
                7 -> currentAttr = currentAttr.copy(inverse = true)
                8 -> currentAttr = currentAttr.copy(hidden = true)
                9 -> currentAttr = currentAttr.copy(strikethrough = true)
                22 -> currentAttr = currentAttr.copy(bold = false, dim = false)
                23 -> currentAttr = currentAttr.copy(italic = false)
                24 -> currentAttr = currentAttr.copy(underline = false)
                25 -> currentAttr = currentAttr.copy(blink = false)
                27 -> currentAttr = currentAttr.copy(inverse = false)
                28 -> currentAttr = currentAttr.copy(hidden = false)
                29 -> currentAttr = currentAttr.copy(strikethrough = false)
                in 30..37 -> currentAttr = currentAttr.copy(fg = p - 30)
                38 -> {
                    // Extended foreground: 38;5;N or 38;2;R;G;B
                    if (i + 1 < params.size && params[i + 1] == 5 && i + 2 < params.size) {
                        currentAttr = currentAttr.copy(fg = params[i + 2] + 256)
                        i += 2
                    } else if (i + 1 < params.size && params[i + 1] == 2 && i + 4 < params.size) {
                        currentAttr = currentAttr.copy(fg = 0x1000000 or (params[i+2] shl 16) or (params[i+3] shl 8) or params[i+4])
                        i += 4
                    }
                }
                39 -> currentAttr = currentAttr.copy(fg = -1) // Default fg
                in 40..47 -> currentAttr = currentAttr.copy(bg = p - 40)
                48 -> {
                    if (i + 1 < params.size && params[i + 1] == 5 && i + 2 < params.size) {
                        currentAttr = currentAttr.copy(bg = params[i + 2] + 256)
                        i += 2
                    } else if (i + 1 < params.size && params[i + 1] == 2 && i + 4 < params.size) {
                        currentAttr = currentAttr.copy(bg = 0x1000000 or (params[i+2] shl 16) or (params[i+3] shl 8) or params[i+4])
                        i += 4
                    }
                }
                49 -> currentAttr = currentAttr.copy(bg = -1) // Default bg
                in 90..97 -> currentAttr = currentAttr.copy(fg = p - 90 + 8) // Bright fg
                in 100..107 -> currentAttr = currentAttr.copy(bg = p - 100 + 8) // Bright bg
            }
            i++
        }
    }

    private fun putChar(ch: Char) {
        if (cursorCol >= cols) {
            cursorCol = 0
            lineFeed()
        }
        currentScreen()[cursorRow][cursorCol] = TermCell(ch, currentAttr)
        cursorCol++
    }

    private fun lineFeed() {
        if (cursorRow == scrollBottom) {
            scrollUp(1)
        } else if (cursorRow < rows - 1) {
            cursorRow++
        }
    }

    private fun reverseLineFeed() {
        if (cursorRow == scrollTop) {
            scrollDown(1)
        } else if (cursorRow > 0) {
            cursorRow--
        }
    }

    private fun scrollUp(n: Int) {
        val scr = currentScreen()
        for (count in 0 until n) {
            if (!useAltScreen && scrollTop == 0) {
                scrollback.add(scr[scrollTop].copyOf())
                if (scrollback.size > maxScrollback) scrollback.removeFirst()
            }
            for (r in scrollTop until scrollBottom) {
                scr[r] = scr[r + 1]
            }
            scr[scrollBottom] = Array(cols) { TermCell() }
        }
    }

    private fun scrollDown(n: Int) {
        val scr = currentScreen()
        for (count in 0 until n) {
            for (r in scrollBottom downTo scrollTop + 1) {
                scr[r] = scr[r - 1]
            }
            scr[scrollTop] = Array(cols) { TermCell() }
        }
    }

    private fun insertLines(n: Int) {
        val scr = currentScreen()
        for (count in 0 until n) {
            for (r in scrollBottom downTo cursorRow + 1) scr[r] = scr[r - 1]
            scr[cursorRow] = Array(cols) { TermCell() }
        }
    }

    private fun deleteLines(n: Int) {
        val scr = currentScreen()
        for (count in 0 until n) {
            for (r in cursorRow until scrollBottom) scr[r] = scr[r + 1]
            scr[scrollBottom] = Array(cols) { TermCell() }
        }
    }

    private fun insertChars(n: Int) {
        val line = currentScreen()[cursorRow]
        for (c in cols - 1 downTo cursorCol + n) line[c] = line[c - n]
        for (c in cursorCol until (cursorCol + n).coerceAtMost(cols)) line[c] = TermCell()
    }

    private fun deleteChars(n: Int) {
        val line = currentScreen()[cursorRow]
        for (c in cursorCol until cols - n) line[c] = line[c + n]
        for (c in (cols - n).coerceAtLeast(cursorCol) until cols) line[c] = TermCell()
    }

    private fun eraseScreen() { for (r in 0 until rows) for (c in 0 until cols) currentScreen()[r][c] = TermCell() }
    private fun eraseBelow() {
        eraseLineRight()
        for (r in cursorRow + 1 until rows) for (c in 0 until cols) currentScreen()[r][c] = TermCell()
    }
    private fun eraseAbove() {
        eraseLineLeft()
        for (r in 0 until cursorRow) for (c in 0 until cols) currentScreen()[r][c] = TermCell()
    }
    private fun eraseLine() { for (c in 0 until cols) currentScreen()[cursorRow][c] = TermCell() }
    private fun eraseLineRight() { for (c in cursorCol until cols) currentScreen()[cursorRow][c] = TermCell() }
    private fun eraseLineLeft() { for (c in 0..cursorCol) currentScreen()[cursorRow][c] = TermCell() }

    private fun reset() {
        screen = Array(rows) { Array(cols) { TermCell() } }
        altScreen = Array(rows) { Array(cols) { TermCell() } }
        useAltScreen = false
        cursorRow = 0; cursorCol = 0; cursorVisible = true
        currentAttr = CellAttr()
        scrollTop = 0; scrollBottom = rows - 1
        scrollback.clear()
    }

    private fun emitSnapshot() {
        _screenState.value = ScreenSnapshot(
            screen = currentScreen().map { it.copyOf() }.toTypedArray(),
            cursorRow = cursorRow,
            cursorCol = cursorCol,
            cursorVisible = cursorVisible,
            scrollbackSize = scrollback.size,
        )
    }

    enum class ParseState { GROUND, ESCAPE, CSI, OSC }
}

data class TermCell(
    val char: Char = ' ',
    val attr: CellAttr = CellAttr(),
)

data class CellAttr(
    val fg: Int = -1,        // -1 = default, 0-15 = standard, 256+ = 256-color, 0x1RRGGBB = truecolor
    val bg: Int = -1,
    val bold: Boolean = false,
    val dim: Boolean = false,
    val italic: Boolean = false,
    val underline: Boolean = false,
    val blink: Boolean = false,
    val inverse: Boolean = false,
    val hidden: Boolean = false,
    val strikethrough: Boolean = false,
)

data class ScreenSnapshot(
    val screen: Array<Array<TermCell>>,
    val cursorRow: Int,
    val cursorCol: Int,
    val cursorVisible: Boolean,
    val scrollbackSize: Int,
) {
    override fun equals(other: Any?) = this === other
    override fun hashCode() = System.identityHashCode(this)
}
