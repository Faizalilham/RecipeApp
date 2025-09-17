package dev.faizal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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

@Composable
fun RecipeView(
    recipe : Recipe,
    onClick : (Int) -> Unit
){

    val rating = (recipe.spoonacularScore.toDouble() / 100.0 * 5.0)
    val roundedRating = (rating * 10).toInt() / 10.0

    Box(
        modifier = Modifier
            .fillMaxWidth()
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
                            Color.Black.copy(alpha = 0.8f)
                        ),
                        startY = 200f
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = recipe.title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 17.sp,
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
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                InfoItem(
                    iconUrl = "https://res.cloudinary.com/dmhpacb7m/image/upload/v1757991917/nmvr32drme9fltfvmnuy.png",
                    text = "${recipe.readyInMinutes} mins",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    iconSize = 15.dp
                )
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(20.dp)
                        .background(
                            color = Color.LightGray
                        )
                )
                InfoItem(
                    iconUrl = "https://res.cloudinary.com/dmhpacb7m/image/upload/v1757991917/xuzpy8dswtoisush7jmc.png",
                    text = "${recipe.nutrition.getCalories()} kcal",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    iconSize = 15.dp
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}