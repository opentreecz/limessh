package cz.opentree.limessh.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Selectable terminal palettes. The app chrome keeps the limessh green identity;
 * these affect only terminal cells, cursor and the terminal screen's own bars.
 * Palette values follow their publicly documented schemes or are original.
 */
data class TerminalTheme(
    val id: String,
    val name: String,
    val background: Color,
    val foreground: Color,
    val cursor: Color,
    /** ANSI colors 0-7 followed by bright colors 8-15. */
    val ansi: List<Color>,
) {
    init {
        require(ansi.size == 16) { "A terminal theme needs exactly 16 ANSI colors" }
    }
}

object TerminalThemes {
    const val DEFAULT_ID = "retro-green"

    private fun c(rgb: Int) = Color(0xFF000000L or rgb.toLong())

    val retroGreen = TerminalTheme(
        "retro-green", "Retro green", LimeDarkBg, LimeTerminalGreen, LimeTerminalGreen,
        listOf(0x0A1A0A, 0xCC0000, 0x00CC00, 0xCCCC00, 0x0066CC, 0xCC00CC, 0x00CCCC, 0xCCCCCC,
            0x555555, 0xFF5555, 0x55FF55, 0xFFFF55, 0x5555FF, 0xFF55FF, 0x55FFFF, 0xFFFFFF).map(::c),
    )
    val classicDark = TerminalTheme(
        "classic-dark", "Classic dark", c(0x000000), c(0xE5E5E5), c(0xFFFFFF),
        listOf(0x000000, 0xCD0000, 0x00CD00, 0xCDCD00, 0x3A5FCD, 0xCD00CD, 0x00CDCD, 0xE5E5E5,
            0x7F7F7F, 0xFF3333, 0x33FF33, 0xFFFF33, 0x5C5CFF, 0xFF33FF, 0x33FFFF, 0xFFFFFF).map(::c),
    )
    val classicLight = TerminalTheme(
        "classic-light", "Classic light", c(0xFFFFFF), c(0x1A1A1A), c(0x000000),
        listOf(0x000000, 0xB00020, 0x1B7A1B, 0x8A6D00, 0x1A4DB3, 0x8E24AA, 0x00796B, 0xBDBDBD,
            0x616161, 0xD32F2F, 0x2E9E2E, 0xA88400, 0x3366D6, 0xAB47BC, 0x009688, 0xFAFAFA).map(::c),
    )
    val solarizedDark = TerminalTheme(
        "solarized-dark", "Solarized dark", c(0x002B36), c(0x839496), c(0x93A1A1),
        listOf(0x073642, 0xDC322F, 0x859900, 0xB58900, 0x268BD2, 0xD33682, 0x2AA198, 0xEEE8D5,
            0x002B36, 0xCB4B16, 0x586E75, 0x657B83, 0x839496, 0x6C71C4, 0x93A1A1, 0xFDF6E3).map(::c),
    )
    val solarizedLight = TerminalTheme(
        "solarized-light", "Solarized light", c(0xFDF6E3), c(0x657B83), c(0x586E75),
        listOf(0x073642, 0xDC322F, 0x859900, 0xB58900, 0x268BD2, 0xD33682, 0x2AA198, 0xEEE8D5,
            0x002B36, 0xCB4B16, 0x586E75, 0x657B83, 0x839496, 0x6C71C4, 0x93A1A1, 0xFDF6E3).map(::c),
    )
    val monokai = TerminalTheme(
        "monokai", "Monokai", c(0x272822), c(0xF8F8F2), c(0xF8F8F0),
        listOf(0x272822, 0xF92672, 0xA6E22E, 0xF4BF75, 0x66D9EF, 0xAE81FF, 0xA1EFE4, 0xF8F8F2,
            0x75715E, 0xF92672, 0xA6E22E, 0xF4BF75, 0x66D9EF, 0xAE81FF, 0xA1EFE4, 0xF9F8F5).map(::c),
    )
    val amberCrt = TerminalTheme(
        "amber-crt", "Amber CRT", c(0x140C00), c(0xFFB000), c(0xFFCC4D),
        listOf(0x140C00, 0xCC3300, 0x99AA00, 0xCC8800, 0x7A6A2A, 0xB06A00, 0xD9A441, 0xFFB000,
            0x6B4E00, 0xFF5533, 0xBBCC22, 0xFFCC33, 0xA38A3A, 0xE08A00, 0xFFD27A, 0xFFE9B3).map(::c),
    )
    val highContrast = TerminalTheme(
        "high-contrast", "High contrast", c(0x000000), c(0xFFFFFF), c(0xFFFF00),
        listOf(0x000000, 0xFF4040, 0x40FF40, 0xFFFF40, 0x6FA8FF, 0xFF70FF, 0x40FFFF, 0xFFFFFF,
            0x9E9E9E, 0xFF8080, 0x80FF80, 0xFFFF80, 0xA0C4FF, 0xFFA0FF, 0x80FFFF, 0xFFFFFF).map(::c),
    )

    val all = listOf(retroGreen, classicDark, classicLight, solarizedDark, solarizedLight, monokai, amberCrt, highContrast)

    fun byId(id: String?): TerminalTheme = all.firstOrNull { it.id == id } ?: retroGreen
}

/**
 * Resolves terminal color codes used by [cz.opentree.limessh.ssh.CellAttr]:
 * -1 default, 0-15 ANSI, 256-511 indexed color, and 0x1RRGGBB truecolor.
 */
fun resolveTerminalColor(theme: TerminalTheme, colorCode: Int, bold: Boolean, isBackground: Boolean): Color {
    fun default() = if (isBackground) theme.background else theme.foreground
    return when {
        colorCode == -1 -> default()
        colorCode in 0..15 -> theme.ansi[if (!isBackground && bold && colorCode < 8) colorCode + 8 else colorCode]
        colorCode in 256..511 -> {
            val index = colorCode - 256
            when {
                index < 16 -> theme.ansi[index]
                index < 232 -> {
                    val cube = index - 16
                    fun level(value: Int) = if (value == 0) 0 else 55 + value * 40
                    Color(level(cube / 36), level((cube % 36) / 6), level(cube % 6))
                }
                else -> {
                    val gray = (index - 232) * 10 + 8
                    Color(gray, gray, gray)
                }
            }
        }
        colorCode >= 0x1000000 -> Color((colorCode shr 16) and 0xFF, (colorCode shr 8) and 0xFF, colorCode and 0xFF)
        else -> default()
    }
}
