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
    var onOutput: ((ByteArray) -> Unit)? = null,
) {
    // Screen buffer: rows x cols of cells
    private var screen = Array(rows) { Array(cols) { TermCell() } }
    private var altScreen = Array(rows) { Array(cols) { TermCell() } }
    private var useAltScreen = false

    // Scrollback
    private val scrollback = mutableListOf<Array<TermCell>>()
    @Volatile var maxScrollback = 10_000

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
    private var utfRemaining = 0
    private var utfCodePoint = 0
    private var utfMinimum = 0
    private var savedRow = 0
    private var savedCol = 0

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
                }
            } catch (_: Exception) {}
        }
    }

    fun detach() {
        scope.cancel()
    }

    @Synchronized
    fun resize(newCols: Int, newRows: Int) {
        require(newCols in 1..1000 && newRows in 1..1000)
        fun resized(buffer: Array<Array<TermCell>>) = Array(newRows) { r ->
            Array(newCols) { c ->
                buffer.getOrNull(r)?.getOrNull(c) ?: TermCell()
            }
        }
        screen = resized(screen)
        altScreen = resized(altScreen)
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
        emitSnapshot()
    }

    private fun processByte(b: Int) {
        if (parseState == ParseState.GROUND && (utfRemaining > 0 || b >= 0x80)) {
            processUtf8(b)
            return
        }
        when (parseState) {
            ParseState.GROUND -> processGround(b)
            ParseState.ESCAPE -> processEscape(b)
            ParseState.CSI -> processCsi(b)
            ParseState.OSC -> processOsc(b)
            ParseState.OSC_ESCAPE -> { parseState = if (b == 0x5C) ParseState.GROUND else ParseState.OSC }
            ParseState.CHARSET -> { parseState = ParseState.GROUND }
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
            '(', ')' -> { parseState = ParseState.CHARSET }
            '7' -> { savedRow = cursorRow; savedCol = cursorCol; parseState = ParseState.GROUND }
            '8' -> { restoreCursor(); parseState = ParseState.GROUND }
            'D' -> { lineFeed(); parseState = ParseState.GROUND }
            'M' -> { reverseLineFeed(); parseState = ParseState.GROUND }
            'c' -> { reset(); parseState = ParseState.GROUND }
            'Z' -> { sendDeviceAttributes(); parseState = ParseState.GROUND }
            else -> { parseState = ParseState.GROUND }
        }
    }

    private fun processCsi(b: Int) {
        val ch = b.toChar()
        if (ch in '0'..'9' || ch == ';' || ch == '?' || ch == '>' || ch == '!') {
            if (escBuffer.length >= 128) { parseState = ParseState.GROUND; return }
            escBuffer.append(ch)
            return
        }
        // Final character
        val params = escBuffer.toString()
        executeCsi(ch, params)
        parseState = ParseState.GROUND
    }

    private fun processOsc(b: Int) {
        if (b == 0x07) parseState = ParseState.GROUND
        if (b == 0x1B) parseState = ParseState.OSC_ESCAPE
        // OSC content ignored for now (window title, etc.)
    }

    private fun executeCsi(cmd: Char, params: String) {
        val parts = params.replace("?", "").split(";").map { (it.toIntOrNull() ?: 0).coerceIn(0, 32767) }
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
                val top = (p1.coerceAtLeast(1) - 1).coerceIn(0, rows - 1)
                val bottom = ((if (parts.size > 1 && p2 > 0) p2 else rows) - 1).coerceIn(0, rows - 1)
                if (top >= bottom) return
                scrollTop = top
                scrollBottom = bottom
                cursorRow = 0; cursorCol = 0
            }
            'm' -> processSgr(parts) // Set graphic rendition
            'h' -> { // Set mode
                if (params.startsWith("?")) {
                    when (p1) {
                        25 -> cursorVisible = true
                        1049, 47, 1047 -> {
                            savedRow = cursorRow; savedCol = cursorCol
                            useAltScreen = true; altScreen = Array(rows) { Array(cols) { TermCell() } }
                            cursorRow = 0; cursorCol = 0
                        }
                    }
                }
            }
            'l' -> { // Reset mode
                if (params.startsWith("?")) {
                    when (p1) {
                        25 -> cursorVisible = false
                        1049, 47, 1047 -> { useAltScreen = false; restoreCursor() }
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
            'n' -> {
                when (p1) {
                    5 -> sendResponse("\u001b[0n")
                    6 -> sendResponse("\u001b[${cursorRow + 1};${cursorCol + 1}R")
                }
            }
            'c' -> {
                if (p1 == 0 && !params.startsWith("?") && !params.startsWith(">")) {
                    sendDeviceAttributes()
                }
            }
            't' -> {} // Window manipulation (ignore)
            's' -> { savedRow = cursorRow; savedCol = cursorCol }
            'u' -> restoreCursor()
        }
    }

    private fun sendDeviceAttributes() {
        sendResponse("\u001b[?1;2c")
    }

    private fun sendResponse(response: String) {
        onOutput?.invoke(response.toByteArray(Charsets.US_ASCII))
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

    private fun restoreCursor() {
        cursorRow = savedRow.coerceIn(0, rows - 1)
        cursorCol = savedCol.coerceIn(0, cols - 1)
    }

    private fun processUtf8(b: Int) {
        if (utfRemaining > 0) {
            if (b in 0x80..0xBF) {
                utfCodePoint = (utfCodePoint shl 6) or (b and 0x3F)
                utfRemaining--
                if (utfRemaining == 0) {
                    val valid = utfCodePoint >= utfMinimum && utfCodePoint <= 0x10FFFF && utfCodePoint !in 0xD800..0xDFFF
                    putGlyph(if (valid) utfCodePoint else 0xFFFD)
                }
                return
            }
            utfRemaining = 0
            putGlyph(0xFFFD)
            processByte(b)
            return
        }
        when (b) {
            in 0xC2..0xDF -> { utfRemaining = 1; utfCodePoint = b and 0x1F; utfMinimum = 0x80 }
            in 0xE0..0xEF -> { utfRemaining = 2; utfCodePoint = b and 0x0F; utfMinimum = 0x800 }
            in 0xF0..0xF4 -> { utfRemaining = 3; utfCodePoint = b and 7; utfMinimum = 0x10000 }
            else -> putGlyph(0xFFFD)
        }
    }

    private fun putChar(ch: Char) = putGlyph(ch.code)

    private fun putGlyph(codePoint: Int) {
        val glyph = String(Character.toChars(codePoint))
        val combining = Character.getType(codePoint) in listOf(Character.NON_SPACING_MARK.toInt(), Character.COMBINING_SPACING_MARK.toInt())
        if (combining && cursorCol > 0) {
            val previous = (cursorCol - 1).coerceAtMost(cols - 1)
            val cell = currentScreen()[cursorRow][previous]
            currentScreen()[cursorRow][previous] = cell.copy(char = cell.char + glyph)
            return
        }
        val width = if (codePoint in 0x1100..0x115F || codePoint in 0x2E80..0xA4CF ||
            codePoint in 0xAC00..0xD7A3 || codePoint in 0xF900..0xFAFF || codePoint in 0x1F300..0x1FAFF || codePoint >= 0x20000) 2 else 1
        if (cursorCol + width > cols) {
            cursorCol = 0
            lineFeed()
        }
        currentScreen()[cursorRow][cursorCol] = TermCell(glyph, currentAttr)
        if (width == 2 && cursorCol + 1 < cols) currentScreen()[cursorRow][cursorCol + 1] = TermCell("", currentAttr)
        cursorCol += width
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
        for (count in 0 until n.coerceAtMost(rows)) {
            if (!useAltScreen && scrollTop == 0) {
                scrollback.add(scr[scrollTop].copyOf())
                while (scrollback.size > maxScrollback.coerceIn(0, 10000)) scrollback.removeAt(0)
            }
            for (r in scrollTop until scrollBottom) {
                scr[r] = scr[r + 1]
            }
            scr[scrollBottom] = Array(cols) { TermCell() }
        }
    }

    private fun scrollDown(n: Int) {
        val scr = currentScreen()
        for (count in 0 until n.coerceAtMost(rows)) {
            for (r in scrollBottom downTo scrollTop + 1) {
                scr[r] = scr[r - 1]
            }
            scr[scrollTop] = Array(cols) { TermCell() }
        }
    }

    private fun insertLines(n: Int) {
        val scr = currentScreen()
        for (count in 0 until n.coerceAtMost(rows)) {
            for (r in scrollBottom downTo cursorRow + 1) scr[r] = scr[r - 1]
            scr[cursorRow] = Array(cols) { TermCell() }
        }
    }

    private fun deleteLines(n: Int) {
        val scr = currentScreen()
        for (count in 0 until n.coerceAtMost(rows)) {
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
    private fun eraseLineLeft() { for (c in 0..cursorCol.coerceAtMost(cols - 1)) currentScreen()[cursorRow][c] = TermCell() }

    private fun reset() {
        screen = Array(rows) { Array(cols) { TermCell() } }
        altScreen = Array(rows) { Array(cols) { TermCell() } }
        useAltScreen = false
        cursorRow = 0; cursorCol = 0; cursorVisible = true
        currentAttr = CellAttr()
        scrollTop = 0; scrollBottom = rows - 1
        scrollback.clear()
    }

    @Synchronized
    private fun emitSnapshot() {
        _screenState.value = ScreenSnapshot(
            screen = currentScreen().map { it.copyOf() }.toTypedArray(),
            cursorRow = cursorRow,
            cursorCol = cursorCol,
            cursorVisible = cursorVisible,
            scrollbackSize = scrollback.size,
        )
    }

    /**
     * Returns the cells for a display row relative to the current viewport.
     *
     * relRow >= 0 → visible screen row (clamped; null if beyond rows).
     * relRow <  0 → scrollback row; -1 = most recently pushed, -scrollbackSize = oldest.
     * Returns null (caller should treat as a blank row) if out of range.
     */
    @Synchronized
    fun getRow(relRow: Int): Array<TermCell>? {
        return if (relRow >= 0) {
            val scr = currentScreen()
            if (relRow < scr.size) scr[relRow] else null
        } else {
            val idx = scrollback.size + relRow   // e.g. -1 → last element
            if (idx >= 0 && idx < scrollback.size) scrollback[idx] else null
        }
    }

    /**
     * Returns all scrollback rows followed by all visible screen rows as a single string,
     * rows separated by newlines, trailing whitespace trimmed per row.
     */
    @Synchronized
    fun getTranscriptText(): String {
        val sb = StringBuilder()
        for (row in scrollback) {
            sb.append(row.joinToString("") { it.char }.trimEnd())
            sb.append('\n')
        }
        val scr = currentScreen()
        for (row in scr) {
            sb.append(row.joinToString("") { it.char }.trimEnd())
            sb.append('\n')
        }
        return sb.toString().trimEnd('\n')
    }

    enum class ParseState { GROUND, ESCAPE, CSI, OSC, OSC_ESCAPE, CHARSET }
}

data class TermCell(
    val char: String = " ",
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
