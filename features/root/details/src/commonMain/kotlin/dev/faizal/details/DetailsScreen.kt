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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import dev.faizal.details.components.DetailSkeletonScreen
import dev.faizal.details.components.RecipeCategoryTags
import dev.faizal.details.components.SegmentedTabLayout
import dev.faizal.details.viewmodel.DetailViewModel
import dev.faizal.domain.dummy.RecipeDummyData
import dev.faizal.domain.model.instructions.Equipment
import dev.faizal.domain.model.recipe.Recipe
import dev.faizal.shared.component.ExpandableText
import dev.faizal.shared.utils.stripHtmlTags
import dev.faizal.ui.EquipmentView
import dev.faizal.ui.InfoItem
import dev.faizal.ui.IngredientView
import dev.faizal.ui.InstructionView
import dev.faizal.ui.StarRatingBar
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
                state.recipes?.let { recipe ->
                    DetailContent(
                        tabs = tabs,
                        selectedIndex = selectedIndex,
                        onTabSelected = { selectedIndex = it },
                        recipe = recipe,
                        navigateBack = navigateBack
                    )
                } ?: run {
                    Text("Resep tidak ditemukan", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Composable
fun DetailContent(
    tabs: List<String>,
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    recipe: Recipe,
    navigateBack: () -> Unit
) {

    var isFavorite by remember { mutableStateOf(false) }
    val rating = (recipe.spoonacularScore.toDouble() / 100.0 * 5.0)
    val roundedRating = (rating * 10).toInt() / 10.0

    val allEquipments: List<Equipment> = recipe.analyzedInstructions
        .flatMap { it.steps }
        .flatMap { it.equipment }
        .distinct()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            CoilImage(
                imageModel = { recipe.image },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Box(
                modifier = Modifier.weight(1f).fillMaxWidth(),
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    IconButton(
                        onClick = navigateBack,
                        modifier = Modifier
                            .padding(vertical = 24.dp, horizontal = 16.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.7f))
                    ) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                    }

                    IconButton(
                        onClick = { isFavorite = !isFavorite },
                        modifier = Modifier
                            .padding(vertical = 24.dp, horizontal = 16.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.7f))
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) Color.Red else Color.Black
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.8f),
                                Color.White.copy(alpha = 0.9f),
                                Color.White,
                                Color.White,
                                Color.White,
                                Color.White,
                                Color.White,
                                Color.White,
                                Color.White,
                                Color.White,
                                Color.White,
                                Color.White,
                            )
                        ),
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(8.dp)
                            .background(
                                color = Color.White.copy(0.9f),
                                shape = RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = buildAnnotatedString {
                            append("Recipe by ")

                            withStyle(
                                style = SpanStyle(fontWeight = FontWeight.Bold)
                            ) {
                                append(recipe.sourceName ?: "lorem ipsum")
                            }
                        },
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.titleLarge,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        StarRatingBar(rating = roundedRating)
                        Text(
                            text = "$roundedRating",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        InfoItem(
                            iconUrl = "https://res.cloudinary.com/dmhpacb7m/image/upload/v1757991917/nmvr32drme9fltfvmnuy.png",
                            text = "${recipe.readyInMinutes} mins"
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
                            iconUrl = "https://res.cloudinary.com/dmhpacb7m/image/upload/v1757993977/yupvev8rz6l4f5wvlux0.png",
                            text = recipe.getDifficultyLevel()
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
                            text = "${recipe.nutrition.getCalories()} kcal"
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    RecipeCategoryTags(
                        dishTypes = recipe.dishTypes,
                        isVegetarian = recipe.vegetarian,
                        isVegan = recipe.vegan
                    )

                    ExpandableText( text = recipe.summary?.stripHtmlTags() ?: "Not yet")

                    Spacer(modifier = Modifier.height(16.dp))

                    SegmentedTabLayout(
                        tabs = tabs,
                        selectedIndex = selectedIndex,
                        onTabSelected = onTabSelected
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    when (selectedIndex) {
                        0 -> {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                text = "Bahan-bahan",
                                style = MaterialTheme.typography.titleMedium
                                )
                            Spacer(modifier = Modifier.height(8.dp))
                            recipe.extendedIngredients.forEach {
                                IngredientView(ingredient = it)
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(color = Color.LightGray),
                                )
                            }
                        }
                        1 -> {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                text = "Instruksi",
                                style = MaterialTheme.typography.titleMedium
                            )
                            InstructionView(recipe.analyzedInstructions)
                        }
                        2 -> {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                text = "Peralatan Masak",
                                style = MaterialTheme.typography.titleMedium
                            )
                            allEquipments.forEach {
                                EquipmentView(equipment = it)
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(color = Color.LightGray),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

