package dev.faizal.details.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun SegmentedTabLayout(
    tabs: List<String>,
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val indicatorOffset = remember { Animatable(selectedIndex.toFloat()) }


    LaunchedEffect(selectedIndex) {
        coroutineScope.launch {
            indicatorOffset.animateTo(
                targetValue = selectedIndex.toFloat(),
                animationSpec = spring(
                    stiffness = Spring.StiffnessLow,
                    dampingRatio = Spring.DampingRatioMediumBouncy
                )
            )
        }
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12))
            .border(1.dp, Color.Gray, RoundedCornerShape(12))
            .background(Color.White)
            .height(50.dp)
            .padding(4.dp)
    ) {
        val tabWidth = remember { mutableStateOf(0f) }

        Box(
            modifier = Modifier
                .offset { IntOffset((indicatorOffset.value * tabWidth.value).toInt(), 0) }
                .width(with(LocalDensity.current) { tabWidth.value.toDp() })
                .fillMaxHeight()
                .clip(RoundedCornerShape(12))
                .background(Color(0xFF4CAF50))
        )

        Row(Modifier.fillMaxSize()) {
            tabs.forEachIndexed { index, title ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .onGloballyPositioned { coordinates ->
                            tabWidth.value = coordinates.size.width.toFloat()
                        }
                        .clickable { onTabSelected(index) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        color = if (index == selectedIndex) Color.White else Color.Black,
                        fontSize = 12.sp,
                        fontWeight = if (index == selectedIndex) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }
    }
}
