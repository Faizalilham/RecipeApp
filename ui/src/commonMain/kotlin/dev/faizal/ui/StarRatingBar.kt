package dev.faizal.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlin.math.floor

@Composable
fun StarRatingBar(
    maxStars: Int = 5,
    rating: Double,
) {

    val starSize = 16.dp
    val starSpacing = 2.dp

    Row(
        modifier = Modifier.selectableGroup(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val fullStars = floor(rating).toInt()
        val partialFraction = (rating - fullStars).toFloat()

        for (i in 1..maxStars) {
            when {
                i <= fullStars -> {
                    StarIcon(
                        icon = Icons.Filled.Star,
                        color = Color(0xFFFFC700),
                        size = starSize,
                        onClick = {  }
                    )
                }

                i == fullStars + 1 && partialFraction > 0f -> {
                    Box(modifier = Modifier
                        .width(starSize)
                        .height(starSize)
                        .selectable(
                            selected = false,
                            onClick = {  }
                        )
                    ) {

                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = Color(0x20FFFFFF),
                            modifier = Modifier
                                .matchParentSize()
                        )

                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFC700),
                            modifier = Modifier
                                .matchParentSize()
                                .then(
                                    Modifier.width(starSize * partialFraction)
                                )
                        )
                    }
                }

                else -> {
                    StarIcon(
                        icon = Icons.Filled.Star,
                        color = Color.LightGray,
                        size = starSize,
                        onClick = { }
                    )
                }
            }

            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
            }
        }
    }
}

@Composable
private fun StarIcon(
    icon: ImageVector,
    color: Color,
    size: androidx.compose.ui.unit.Dp,
    onClick: () -> Unit
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = color,
        modifier = Modifier
            .width(size)
            .height(size)
            .selectable(
                selected = false,
                onClick = onClick
            )
    )
}