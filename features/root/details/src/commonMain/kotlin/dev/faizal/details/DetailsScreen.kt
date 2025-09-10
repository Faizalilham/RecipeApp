package dev.faizal.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import dev.faizal.details.components.DetailSkeletonScreen
import dev.faizal.details.components.ExpandableCard
import dev.faizal.details.domain.RecipeCard
import dev.faizal.details.viewmodel.DetailState
import dev.faizal.details.viewmodel.DetailViewModel
import dev.faizal.shared.utils.asHtmlText
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    id: Int,
    navigateBack: () -> Unit
) {
    val viewModel = koinViewModel<DetailViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    var expandedRecipeCard: RecipeCard? by remember { mutableStateOf(null) }

    LaunchedEffect(id) {
        viewModel.getSelectedRecipe(id)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            // viewModel.toggleFavorite(id)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Favorite"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        when {
            state.isLoading -> {
                DetailSkeletonScreen()
            }

            else -> {
                DetailContent(
                    paddingValues = paddingValues,
                    state = state,
                    expandedRecipeCard = expandedRecipeCard,
                    onExpandChange = { expandedRecipeCard = it }
                )
            }
        }
    }
}

@Composable
fun DetailContent(
    paddingValues: PaddingValues,
    state: DetailState,
    expandedRecipeCard: RecipeCard?,
    onExpandChange: (RecipeCard?) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = paddingValues.calculateTopPadding(),
                start = 12.dp,
                end = 12.dp
            )
            .verticalScroll(rememberScrollState())
    ) {
        CoilImage(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .height(300.dp)
                .fillMaxWidth(),
            imageModel = { state.recipes?.image },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.alpha(0.5f),
                text = state.recipes?.sourceName.orEmpty(),
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
            SuggestionChip(
                onClick = {},
                label = {
                    Text(
                        text = "${state.recipes?.readyInMinutes ?: "-"} Minutes",
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = state.recipes?.title ?: "Title",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        state.recipes?.summary.orEmpty().asHtmlText()

        Spacer(modifier = Modifier.height(24.dp))

        ExpandableCard(
            expanded = expandedRecipeCard == RecipeCard.Ingredients,
            title = "Ingredients",
            description = state.recipes?.extendedIngredients.toString(),
            onClick = {
                onExpandChange(
                    if (expandedRecipeCard == RecipeCard.Ingredients) null else RecipeCard.Ingredients
                )
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        ExpandableCard(
            expanded = expandedRecipeCard == RecipeCard.Instructions,
            title = "Instructions",
            description = state.recipes?.analyzedInstructions.toString(),
            onClick = {
                onExpandChange(
                    if (expandedRecipeCard == RecipeCard.Instructions) null else RecipeCard.Instructions
                )
            }
        )
    }
}