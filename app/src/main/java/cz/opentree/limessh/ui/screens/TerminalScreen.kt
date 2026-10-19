package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cz.opentree.limessh.ssh.CellAttr
import cz.opentree.limessh.ssh.ScreenSnapshot
import cz.opentree.limessh.ssh.TermCell
import cz.opentree.limessh.ui.theme.*

// Standard 16-color ANSI palette (retro green-tinted for LimeSSH)
private val ansiColors = arrayOf(
    Color(0xFF0A1A0A), // 0: Black (dark green-black)
    Color(0xFFCC0000), // 1: Red
    Color(0xFF00CC00), // 2: Green (lime)
    Color(0xFFCCCC00), // 3: Yellow
    Color(0xFF0066CC), // 4: Blue
    Color(0xFFCC00CC), // 5: Magenta
    Color(0xFF00CCCC), // 6: Cyan
    Color(0xFFCCCCCC), // 7: White
    Color(0xFF555555), // 8: Bright black
    Color(0xFFFF5555), // 9: Bright red
    Color(0xFF55FF55), // 10: Bright green
    Color(0xFFFFFF55), // 11: Bright yellow
    Color(0xFF5555FF), // 12: Bright blue
    Color(0xFFFF55FF), // 13: Bright magenta
    Color(0xFF55FFFF), // 14: Bright cyan
    Color(0xFFFFFFFF), // 15: Bright white
)

/**
 * Full terminal rendering screen using Compose Canvas.
 * Renders the TerminalEmulator's ScreenSnapshot with retro green CRT aesthetic.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TerminalScreen(
    connectionId: String,
    snapshot: ScreenSnapshot? = null,
    onInput: ((String) -> Unit)? = null,
    onKeyEvent: ((KeyEvent) -> Boolean)? = null,
    onBack: (() -> Unit)? = null,
) {
    val focusRequester = remember { FocusRequester() }
    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current

    // Measure a single monospace character to determine cell size
    val cellSize = remember(textMeasurer) {
        val result = textMeasurer.measure(
            text = AnnotatedString("M"),
            style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 13.sp),
        )
        Size(result.size.width.toFloat(), result.size.height.toFloat())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(snapshot?.let { "Terminal" } ?: "Connecting...") },
                navigationIcon = {
                    if (onBack != null) {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LimeDarkBg,
                    titleContentColor = LimeTerminalGreen,
                    navigationIconContentColor = LimeTerminalGreen,
                ),
            )
        },
    ) { padding ->
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(LimeDarkBg)
                .focusRequester(focusRequester)
                .focusable()
                .onKeyEvent { event ->
                    if (event.type == KeyEventType.KeyDown) {
                        onKeyEvent?.invoke(event) ?: false
                    } else false
                }
                .pointerInput(Unit) {
                    detectTapGestures { focusRequester.requestFocus() }
                },
        ) {
            val snap = snapshot ?: return@Canvas
            val cw = cellSize.width
            val ch = cellSize.height

            for (row in snap.screen.indices) {
                for (col in snap.screen[row].indices) {
                    val cell = snap.screen[row][col]
                    val x = col * cw
                    val y = row * ch

                    // Draw background
                    val bgColor = resolveColor(cell.attr.bg, cell.attr, isBackground = true)
                    if (bgColor != LimeDarkBg) {
                        drawRect(bgColor, Offset(x, y), Size(cw, ch))
                    }

                    // Draw cursor
                    if (row == snap.cursorRow && col == snap.cursorCol && snap.cursorVisible) {
                        drawRect(LimeTerminalGreen.copy(alpha = 0.7f), Offset(x, y), Size(cw, ch))
                    }
                }
            }

            // Draw text on top
            for (row in snap.screen.indices) {
                val line = buildAnnotatedString {
                    for (col in snap.screen[row].indices) {
                        val cell = snap.screen[row][col]
                        val fgColor = if (row == snap.cursorRow && col == snap.cursorCol && snap.cursorVisible) {
                            LimeDarkBg
                        } else {
                            resolveColor(cell.attr.fg, cell.attr, isBackground = false)
                        }
                        withStyle(SpanStyle(
                            color = fgColor,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 13.sp,
                        )) {
                            append(cell.char)
                        }
                    }
                }
                drawText(
                    textMeasurer = textMeasurer,
                    text = line,
                    topLeft = Offset(0f, row * ch),
                )
            }
        }

        LaunchedEffect(Unit) { focusRequester.requestFocus() }
    }
}

private fun resolveColor(colorCode: Int, attr: CellAttr, isBackground: Boolean): Color {
    return when {
        colorCode == -1 -> if (isBackground) LimeDarkBg else LimeTerminalGreen
        colorCode in 0..15 -> {
            val idx = if (!isBackground && attr.bold && colorCode < 8) colorCode + 8 else colorCode
            ansiColors[idx]
        }
        colorCode in 256..511 -> {
            // 256-color: index stored as colorCode - 256
            val idx = colorCode - 256
            when {
                idx < 16 -> ansiColors[idx]
                idx < 232 -> {
                    val c = idx - 16
                    val r = (c / 36) * 51
                    val g = ((c % 36) / 6) * 51
                    val b = (c % 6) * 51
                    Color(r, g, b)
                }
                else -> {
                    val gray = (idx - 232) * 10 + 8
                    Color(gray, gray, gray)
                }
            }
        }
        colorCode >= 0x1000000 -> {
            // Truecolor: 0x1RRGGBB
            val r = (colorCode shr 16) and 0xFF
            val g = (colorCode shr 8) and 0xFF
            val b = colorCode and 0xFF
            Color(r, g, b)
        }
        else -> if (isBackground) LimeDarkBg else LimeTerminalGreen
    }
}

private fun DrawScope.drawText(
    textMeasurer: TextMeasurer,
    text: AnnotatedString,
    topLeft: Offset,
) {
    val result = textMeasurer.measure(text)
    drawContext.canvas.save()
    drawContext.canvas.translate(topLeft.x, topLeft.y)
    result.multiParagraph.paint(drawContext.canvas.nativeCanvas)
    drawContext.canvas.restore()
}
