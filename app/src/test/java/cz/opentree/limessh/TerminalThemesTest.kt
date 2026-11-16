package cz.opentree.limessh

import androidx.compose.ui.graphics.Color
import cz.opentree.limessh.ui.theme.LimeDarkBg
import cz.opentree.limessh.ui.theme.LimeTerminalGreen
import cz.opentree.limessh.ui.theme.TerminalThemes
import cz.opentree.limessh.ui.theme.resolveTerminalColor
import org.junit.Assert.*
import org.junit.Test

class TerminalThemesTest {
    @Test fun retroGreenRemainsTheDefaultAndKeepsItsOriginalColors() {
        assertEquals("retro-green", TerminalThemes.DEFAULT_ID)
        val theme = TerminalThemes.byId(null)
        assertEquals(TerminalThemes.retroGreen, theme)
        assertEquals(LimeDarkBg, theme.background)
        assertEquals(LimeTerminalGreen, theme.foreground)
        // The original hard-coded palette, so existing remote applications look unchanged.
        assertEquals(Color(0xFF0A1A0A), theme.ansi[0])
        assertEquals(Color(0xFFCC0000), theme.ansi[1])
        assertEquals(Color(0xFFFFFFFF), theme.ansi[15])
    }

    @Test fun unknownOrCorruptSavedThemeFallsBackToRetroGreen() {
        assertSame(TerminalThemes.retroGreen, TerminalThemes.byId("deleted-theme"))
        assertSame(TerminalThemes.retroGreen, TerminalThemes.byId(""))
    }

    @Test fun everyThemeIsCompleteAndDistinct() {
        assertTrue(TerminalThemes.all.size >= 8)
        assertEquals(TerminalThemes.all.size, TerminalThemes.all.map { it.id }.toSet().size)
        assertEquals(TerminalThemes.all.size, TerminalThemes.all.map { it.name }.toSet().size)
        TerminalThemes.all.forEach { theme ->
            assertEquals(theme.id, 16, theme.ansi.size)
            assertEquals(theme.id, 1f, theme.background.alpha, 0f)
            assertNotEquals("${theme.id} foreground equals background", theme.background, theme.foreground)
        }
    }

    @Test fun selectedThemeChangesDefaultAndAnsiColorResolution() {
        val retro = TerminalThemes.retroGreen
        val solarized = TerminalThemes.solarizedDark
        assertEquals(retro.background, resolveTerminalColor(retro, -1, false, true))
        assertEquals(solarized.background, resolveTerminalColor(solarized, -1, false, true))
        assertEquals(solarized.foreground, resolveTerminalColor(solarized, -1, false, false))
        assertNotEquals(resolveTerminalColor(retro, 1, false, false), resolveTerminalColor(solarized, 1, false, false))
    }

    @Test fun boldForegroundUsesBrightAnsiButBackgroundDoesNot() {
        val theme = TerminalThemes.monokai
        assertEquals(theme.ansi[9], resolveTerminalColor(theme, 1, bold = true, isBackground = false))
        assertEquals(theme.ansi[1], resolveTerminalColor(theme, 1, bold = true, isBackground = true))
        assertEquals(theme.ansi[9], resolveTerminalColor(theme, 9, bold = true, isBackground = false))
    }

    @Test fun indexedAndTruecolorCodesAreIndependentOfTheme() {
        val a = TerminalThemes.classicDark
        val b = TerminalThemes.classicLight
        assertEquals(Color(255, 255, 255), resolveTerminalColor(a, 256 + 231, false, false))
        assertEquals(resolveTerminalColor(a, 256 + 100, false, false), resolveTerminalColor(b, 256 + 100, false, false))
        assertEquals(Color(8, 8, 8), resolveTerminalColor(a, 256 + 232, false, false))
        assertEquals(Color(0x12, 0x34, 0x56), resolveTerminalColor(a, 0x1000000 or 0x123456, false, false))
        // Indexed 0-15 follow the active theme palette.
        assertEquals(a.ansi[4], resolveTerminalColor(a, 256 + 4, false, false))
        assertNotEquals(a.ansi[4], resolveTerminalColor(b, 256 + 4, false, false))
    }

    @Test fun unrecognizedCodesFallBackToThemeDefaults() {
        val theme = TerminalThemes.amberCrt
        assertEquals(theme.foreground, resolveTerminalColor(theme, 100, false, false))
        assertEquals(theme.background, resolveTerminalColor(theme, 100, false, true))
    }
}
