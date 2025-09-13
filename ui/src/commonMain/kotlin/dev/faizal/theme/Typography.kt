package dev.faizal.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.space_regular
import org.jetbrains.compose.resources.space_medium
import org.jetbrains.compose.resources.space_bold
import org.jetbrains.compose.resources.inter_regular
import recipeapp.ui.generated.resources.Res

val space @Composable get() = FontFamily(
    fonts = Font(
        resource = Res.font.space_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resource = Res.font.space_medium,
        weight = FontWeight.Medium,
    ),
    Font(
        resource = Res.font.space_bold,
        weight = FontWeight.Bold,
    )
)

val inter @Composable get() = FontFamily(
    fonts = Font(
        resource = Res.font.inter_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resource = Res.font.inter_medium,
        weight = FontWeight.Medium,
    ),
)

val Typography : Typography @Composable get() = Typography(
    bodyLarge = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = space,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp,
        lineHeight = 20.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = space,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        lineHeight = 20.sp
    ),
    titleLarge = TextStyle(
        fontFamily = space,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 36.sp
    ),
    titleSmall = TextStyle(
        fontFamily = space,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 24.sp
    )
)