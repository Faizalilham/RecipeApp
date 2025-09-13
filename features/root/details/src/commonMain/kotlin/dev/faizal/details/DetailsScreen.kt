package dev.faizal.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import dev.faizal.details.components.DetailSkeletonScreen
import dev.faizal.details.components.SegmentedTabLayout
import dev.faizal.details.viewmodel.DetailState
import dev.faizal.details.viewmodel.DetailViewModel
import dev.faizal.domain.dummy.RecipeDummyData
import dev.faizal.domain.model.recipe.Recipe
import dev.faizal.shared.component.ExpandableText
import dev.faizal.shared.utils.stripHtmlTags
import dev.faizal.utils.getCalories
import dev.faizal.utils.getDifficultyLevel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    id: Int,
    navigateBack: () -> Unit
) {
    val viewModel = koinViewModel<DetailViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    var selectedIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Bahan-bahan", "Instruksi", "PerkakasMasak")

    LaunchedEffect(id) {
        viewModel.getSelectedRecipe(id)
    }

    Scaffold{ paddingValues ->
        when {
            state.isLoading -> {
                DetailSkeletonScreen()
            }

            else -> {
                DetailContent(
                    tabs = tabs,
                    selectedIndex = selectedIndex,
                    onTabSelected = { selectedIndex = it },
                    recipe = RecipeDummyData.getDummyRecipes().first { it.id == id },
                    navigateBack = navigateBack
                )
            }
        }
    }
}

@Composable
fun DetailContent(
    tabs : List<String>,
    selectedIndex : Int,
    onTabSelected: (Int) -> Unit,
    recipe: Recipe,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(Color(0xFFF5F5F5))
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CoilImage(
                    modifier = Modifier
                        .fillMaxWidth(),
                    imageModel = { recipe.image },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
            }
            IconButton(
                onClick = navigateBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.7f))
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.7f))
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Bookmark",
                    tint = Color.Black
                )
            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-48).dp),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            color = Color.White,
            tonalElevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = recipe.title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(1f),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.wrapContentWidth()
                    ) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        val rating = (recipe.spoonacularScore.toDouble().div(100.0)
                            .times(5.0))
                        val roundedRating = (rating.times(10)).toInt().div(10.0)
                        Text(
                            text = roundedRating.toString(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("${recipe.sourceName}", fontSize = 14.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("• ${recipe.readyInMinutes} Mins", fontSize = 14.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("• ${recipe.getDifficultyLevel()}", fontSize = 14.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("• ${recipe.nutrition.getCalories()} Cal", fontSize = 14.sp, color = Color.Gray)
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Description",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(12.dp))

                ExpandableText(
                    text = recipe.summary?.stripHtmlTags() ?:  "something went wrong",
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column {
                    SegmentedTabLayout(
                        tabs = tabs,
                        selectedIndex = selectedIndex,
                        onTabSelected = onTabSelected
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    when (selectedIndex) {
                        0 -> Text("Konten Bahan-bahan")
                        1 -> Text("Konten Instruksi")
                        2 -> Text("Konten Perkakas Masak")
                    }
                }
            }
        }
    }
}