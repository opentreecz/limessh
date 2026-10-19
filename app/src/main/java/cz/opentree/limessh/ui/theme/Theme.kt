package cz.opentree.limessh.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// LimeSSH green palette — lime fruit with green skin and green core
val LimeGreen = Color(0xFF32CD32)          // Primary lime green
val LimeGreenDark = Color(0xFF228B22)       // Forest green for dark surfaces
val LimeGreenLight = Color(0xFF90EE90)      // Light green for highlights
val LimeCore = Color(0xFF7CFC00)            // Bright lime core / accent
val LimeSkin = Color(0xFF3CB371)            // Medium sea green / skin tone
val LimeDarkBg = Color(0xFF0A1A0A)          // Deep dark green-black terminal bg
val LimeSurface = Color(0xFF1A2E1A)         // Dark green surface
val LimeTerminalGreen = Color(0xFF00FF41)   // Retro CRT phosphor green
val RetroAmber = Color(0xFFFFD700)          // Gold accent for retro contrast

// Retro-inspired dark scheme (primary usage for terminal-focused app)
private val LimeDarkColorScheme = darkColorScheme(
    primary = LimeGreen,
    onPrimary = Color.Black,
    primaryContainer = LimeGreenDark,
    onPrimaryContainer = LimeGreenLight,
    secondary = LimeCore,
    onSecondary = Color.Black,
    secondaryContainer = LimeSkin,
    onSecondaryContainer = Color.White,
    tertiary = RetroAmber,
    onTertiary = Color.Black,
    background = LimeDarkBg,
    onBackground = LimeTerminalGreen,
    surface = LimeSurface,
    onSurface = LimeGreenLight,
    surfaceVariant = Color(0xFF2D4A2D),
    onSurfaceVariant = LimeGreenLight,
    outline = LimeSkin,
    error = Color(0xFFFF6B6B),
    onError = Color.Black,
)

// Light scheme for daytime / accessibility
private val LimeLightColorScheme = lightColorScheme(
    primary = LimeGreenDark,
    onPrimary = Color.White,
    primaryContainer = LimeGreenLight,
    onPrimaryContainer = Color(0xFF002200),
    secondary = LimeSkin,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFD4EDDA),
    onSecondaryContainer = Color(0xFF002200),
    tertiary = Color(0xFF6B8F00),
    onTertiary = Color.White,
    background = Color(0xFFF0FFF0),           // Honeydew
    onBackground = Color(0xFF1A1A1A),
    surface = Color.White,
    onSurface = Color(0xFF1A1A1A),
    surfaceVariant = Color(0xFFE8F5E9),
    onSurfaceVariant = Color(0xFF344E34),
    outline = LimeSkin,
)

// Retro monospace typography for that terminal feel
val LimeTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        letterSpacing = (-0.5).sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp,
    ),
)

@Composable
fun LimeSshTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    // LimeSSH uses its own retro green palette, not dynamic Material You colors
    val colorScheme = if (darkTheme) LimeDarkColorScheme else LimeLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = LimeTypography,
        content = content,
    )
}
