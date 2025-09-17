package dev.faizal.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val LightTheme = lightColorScheme(
    primary = Primary,
    onPrimary = Color.Black,                 // teks/icon di atas Primary (kuning terang)
    primaryContainer = PrimaryContainer,
    onPrimaryContainer = Color.Black,

    secondary = Secondary,
    onSecondary = Color.Black,

    background = SurfaceLight,
    surface = SurfaceLight,
    surfaceContainerLowest = SurfaceContainerLowestLight,

    onSurface = OnSurfaceLight,
    onSurfaceVariant = OnSurfaceVariantLight
)


val DarkTheme = darkColorScheme(
    primary = Primary,
    onPrimary = Color.Black,                 // kuning tetap terang, teks hitam lebih jelas
    primaryContainer = PrimaryContainer,
    onPrimaryContainer = Color.Black,

    secondary = Secondary,
    onSecondary = Color.Black,

    background = SurfaceDark,
    surface = SurfaceDark,
    surfaceContainerLowest = SurfaceContainerLowestDark,

    onSurface = OnSurfaceDark,
    onSurfaceVariant = OnSurfaceVariantDark
)




val Shapes = Shapes(
    extraSmall = RoundedCornerShape(5.dp),
    medium = RoundedCornerShape(15.dp),
)

@Composable
fun FoodAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content : @Composable () -> Unit
){

    val colorScheme = if (darkTheme) DarkTheme else LightTheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}