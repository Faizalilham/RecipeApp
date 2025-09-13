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

val freshLightTheme = lightColorScheme(
    primary = FreshGreen,
    primaryContainer = LightGreen,
    surface = Cream,
    surfaceContainerLowest = WarmWhite,
    background = Cream,
    onSurface = TextDark,
    onSurfaceVariant = TextMedium,
    secondary = Color(0xFFFF8A65),
    onPrimary = Color(0xFFFFFFFF)
)

val freshDarkTheme = darkColorScheme(
    primary = LightGreen,
    primaryContainer = DarkGreen,
    surface = Color(0xFF1E2E1E),
    surfaceContainerLowest = Color(0xFF2A3B2A),
    background = Color(0xFF151F15),
    onSurface = Color(0xFFE8F5E8),
    onSurfaceVariant = Color(0xFFC8D5C8),
    secondary = Color(0xFFFFAB40),
    onPrimary = Color(0xFF003300)
)

val warmLightTheme = lightColorScheme(
    primary = WarmOrange,
    primaryContainer = LightOrange,
    surface = Beige,
    surfaceContainerLowest = CreamyWhite,
    background = Beige,
    onSurface = BrownText,
    onSurfaceVariant = MediumBrown,
    secondary = Color(0xFF4CAF50), // Green accent untuk healthy recipes
    onPrimary = Color(0xFFFFFFFF)
)

val warmDarkTheme = darkColorScheme(
    primary = LightOrange,
    primaryContainer = DeepOrange,
    surface = Color(0xFF2E1F1A),
    surfaceContainerLowest = Color(0xFF3B2A24),
    background = Color(0xFF1F1512),
    onSurface = Color(0xFFF5EDE5),
    onSurfaceVariant = Color(0xFFD5C8BD),
    secondary = Color(0xFF81C784),
    onPrimary = Color(0xFF330F00)
)

val culinaryLightTheme = lightColorScheme(
    primary = CulinaryRed,
    primaryContainer = LightRed,
    surface = LightGray,
    surfaceContainerLowest = PureWhite,
    background = LightGray,
    onSurface = CharcoalGray,
    onSurfaceVariant = MediumGray,
    secondary = Color(0xFFFFB74D), // Amber untuk rating/favorites
    onPrimary = Color(0xFFFFFFFF)
)

val culinaryDarkTheme = darkColorScheme(
    primary = LightRed,
    primaryContainer = DarkRed,
    surface = Color(0xFF1C1C1E),
    surfaceContainerLowest = Color(0xFF2C2C2E),
    background = Color(0xFF121212),
    onSurface = Color(0xFFF2F2F7),
    onSurfaceVariant = Color(0xFFAEAEB2),
    secondary = Color(0xFFFFCC02),
    onPrimary = Color(0xFF330A0A)
)

val earthyLightTheme = lightColorScheme(
    primary = EarthyBrown,
    primaryContainer = Color(0xFFBCAAA4),
    surface = LightSage,
    surfaceContainerLowest = OffWhite,
    background = LightSage,
    onSurface = EarthText,
    onSurfaceVariant = SageText,
    secondary = SageGreen,
    onPrimary = Color(0xFFFFFFFF)
)

val earthyDarkTheme = darkColorScheme(
    primary = Color(0xFFBCAAA4),
    primaryContainer = DarkBrown,
    surface = Color(0xFF1F2D1F),
    surfaceContainerLowest = Color(0xFF2D3A2D),
    background = Color(0xFF141A14),
    onSurface = Color(0xFFE8F5E8),
    onSurfaceVariant = Color(0xFFC8D5C8),
    secondary = Color(0xFF9CCC65),
    onPrimary = Color(0xFF2E1B13)
)

val pastryLightTheme = lightColorScheme(
    primary = PastryPurple,
    primaryContainer = SoftPink,
    surface = VanillaCream,
    surfaceContainerLowest = PowderedWhite,
    background = VanillaCream,
    onSurface = DarkText,
    onSurfaceVariant = PurpleGray,
    secondary = Color(0xFFFF4081),
    onPrimary = Color(0xFFFFFFFF)
)

val pastryDarkTheme = darkColorScheme(
    primary = SoftPink,
    primaryContainer = DeepPurple,
    surface = Color(0xFF2D1B2E),
    surfaceContainerLowest = Color(0xFF3A263D),
    background = Color(0xFF1A0F1C),
    onSurface = Color(0xFFF5E8F7),
    onSurfaceVariant = Color(0xFFD5C2D7),
    secondary = Color(0xFFFF6EC7),
    onPrimary = Color(0xFF2A0034)
)

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(5.dp),
    medium = RoundedCornerShape(15.dp),
)

@Composable
fun FoodAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    themeStyle: String = "warm",
    content : @Composable () -> Unit
){

    val colorScheme = when (themeStyle) {
        "fresh" -> if (darkTheme) freshDarkTheme else freshLightTheme
        "warm" -> if (darkTheme) warmDarkTheme else warmLightTheme
        "culinary" -> if (darkTheme) culinaryDarkTheme else culinaryLightTheme
        "earthy" -> if (darkTheme) earthyDarkTheme else earthyLightTheme
        "pastry" -> if (darkTheme) pastryDarkTheme else pastryLightTheme
        else -> if (darkTheme) warmDarkTheme else warmLightTheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}