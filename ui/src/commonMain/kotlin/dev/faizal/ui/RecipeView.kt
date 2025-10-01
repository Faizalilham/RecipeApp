package dev.faizal.ui

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import dev.faizal.domain.model.recipe.Recipe
import dev.faizal.utils.getCalories
import kotlinx.coroutines.delay

@Composable
fun RecipeView(
    recipe : Recipe,
    onClick : (Int) -> Unit
){

    val rating = (recipe.spoonacularScore.toDouble() / 100.0 * 5.0)
    val roundedRating = (rating * 10).toInt() / 10.0

    Box(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick(recipe.id) }
    ) {
        CoilImage(
            modifier = Modifier.fillMaxSize(),
            imageModel = { recipe.image },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.9f)
                        ),
                        startY = 200f
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = recipe.title,
                textAlign = TextAlign.Start, // Ubah ke Start
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                StarRatingBar(rating = roundedRating)
                Text(
                    text = "$roundedRating",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 4.dp),
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                InfoItem(
                    iconUrl = "https://res.cloudinary.com/dmhpacb7m/image/upload/v1757991917/nmvr32drme9fltfvmnuy.png",
                    text = "${recipe.readyInMinutes} mins",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    iconSize = 12.dp
                )
                Spacer(modifier = Modifier.width(16.dp))
                InfoItem(
                    iconUrl = "https://res.cloudinary.com/dmhpacb7m/image/upload/v1757991917/xuzpy8dswtoisush7jmc.png",
                    text = "${recipe.nutrition.getCalories()} kcal",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    iconSize = 12.dp
                )
            }
        }
    }
}

@Composable
fun SnapCarouselRecipeList(
    recipes: List<Recipe>,
    navigateToDetails: (Int) -> Unit
) {
    val listState = rememberLazyListState()
    var currentIndex by remember { mutableStateOf(0) }

    // Detect center item saat user scroll manual
    LaunchedEffect(listState.firstVisibleItemIndex, listState.firstVisibleItemScrollOffset) {
        val layoutInfo = listState.layoutInfo
        val visibleItems = layoutInfo.visibleItemsInfo
        if (visibleItems.isNotEmpty()) {
            val centerItem = visibleItems.minByOrNull { item ->
                val itemCenter = item.offset + item.size / 2
                val listCenter = layoutInfo.viewportSize.width / 2
                kotlin.math.abs(itemCenter - listCenter)
            }
            centerItem?.let { item ->
                currentIndex = item.index
            }
        }
    }

    // Auto scroll
    LaunchedEffect(Unit) {
        while (true) {
            delay(4000)
            if (recipes.isNotEmpty()) {
                val nextIndex = (currentIndex + 1) % recipes.size
                listState.animateScrollToItem(nextIndex)
                currentIndex = nextIndex
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Trending 🔥",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(
                items = recipes,
                key = { _, recipe -> recipe.id }
            ) { index, recipe ->
                val isCenter = index == currentIndex
                val scale by animateFloatAsState(
                    targetValue = if (isCenter) 1f else 0.95f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    ),
                    label = "scale"
                )

                val alpha by animateFloatAsState(
                    targetValue = if (isCenter) 1f else 0.7f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    ),
                    label = "alpha"
                )

                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            this.alpha = alpha
                        }
                        .clickable {
                            currentIndex = index
                        }
                ) {
                    RecipeView(
                        recipe = recipe,
                        onClick = navigateToDetails
                    )
                }
            }
        }
    }
}