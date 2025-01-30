package mgh.morteza.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    primary = ColorPrimary,
    onPrimary = ColorOnPrimary,
    background = ColorBackground,
    surface = ColorSurface,
    onSurface = ColorOnSurface,
    onSurfaceVariant = ColorOnSurfaceVariant,
    surfaceContainerLowest = ColorSurfaceContainerLowest,
    surfaceContainerLow = ColorSurfaceContainerLow,
    surfaceContainer = ColorSurfaceContainer,
    surfaceContainerHigh = ColorSurfaceContainerHigh,
    surfaceContainerHighest = ColorSurfaceContainerHighest,
    primaryContainer = ColorPrimaryContainer,
    error = ColorError,
)

@Composable
fun NotimojiTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}