package dev.faizal.shared.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 3,
    fontSize: TextUnit = 14.sp,
    animationDuration: Int = 300
) {
    var isExpanded by remember { mutableStateOf(false) }
    var showButton by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        AnimatedContent(
            targetState = isExpanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(animationDuration)) togetherWith
                        fadeOut(animationSpec = tween(animationDuration))
            },
            label = "expandableText"
        ) { expanded ->
            Text(
                text = text,
                maxLines = if (expanded) Int.MAX_VALUE else maxLines,
                overflow = TextOverflow.Ellipsis,
                fontSize = fontSize,
                onTextLayout = { textLayoutResult ->
                    if (textLayoutResult.hasVisualOverflow && !showButton) {
                        showButton = true
                    }
                }
            )
        }

        if (showButton) {
            Text(
                text = if (isExpanded) "Show less" else "Show more",
                color = Color.Blue,
                fontSize = fontSize,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .clickable { isExpanded = !isExpanded }
            )
        }
    }
}
