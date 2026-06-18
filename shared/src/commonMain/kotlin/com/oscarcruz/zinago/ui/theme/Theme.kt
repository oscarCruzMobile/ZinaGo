package com.oscarcruz.zinago.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary             = Primary,
    onPrimary           = OnPrimary,
    primaryContainer    = PrimaryContainer,
    onPrimaryContainer  = OnPrimaryContainer,
    secondary           = Secondary,
    onSecondary         = OnSecondary,
    secondaryContainer  = SecondaryContainer,
    onSecondaryContainer = OnSecondaryContainer,
    tertiary            = Tertiary,
    onTertiary          = OnTertiary,
    tertiaryContainer   = TertiaryContainer,
    onTertiaryContainer = OnTertiaryContainer,
    error               = Error,
    onError             = OnError,
    errorContainer      = ErrorContainer,
    onErrorContainer    = OnErrorContainer,
    background          = Background,
    onBackground        = OnBackground,
    surface             = Surface,
    onSurface           = OnSurface,
    surfaceVariant      = SurfaceVariant,
    onSurfaceVariant    = OnSurfaceVariant,
    outline             = Outline,
    outlineVariant      = OutlineVariant,
)

private val DarkColorScheme = darkColorScheme(
    primary             = Color(0xFF84ABE4),
    onPrimary           = Color(0xFF0D3B7A),
    primaryContainer    = Color(0xFF2A6BBD),
    onPrimaryContainer  = Color(0xFFD0E7FF),
    secondary           = Color(0xFF2DD7A4),
    onSecondary         = Color(0xFF1A3D36),
    secondaryContainer  = Color(0xFF2A5A52),
    onSecondaryContainer = Color(0xFFB2F5E4),
    tertiary            = Color(0xFFF8D675),
    onTertiary          = Color(0xFF3D2800),
    tertiaryContainer   = Color(0xFFB47820),
    onTertiaryContainer = Color(0xFFFFF0DC),
    error               = Color(0xFFFF8A80),
    onError             = Color(0xFF7B0000),
    errorContainer      = Color(0xFFB71C1C),
    onErrorContainer    = Color(0xFFFFDEDE),
    background          = BackgroundDark,
    onBackground        = OnBackgroundDark,
    surface             = SurfaceDark,
    onSurface           = OnSurfaceDark,
    surfaceVariant      = SurfaceVariantDark,
    onSurfaceVariant    = OnSurfaceVariantDark,
    outline             = OutlineDark,
    outlineVariant      = OutlineVariantDark,
)

@Composable
fun AspenTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // 👈 sigue el sistema automáticamente
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography  = aspenTypography(),
        content     = content
    )
}