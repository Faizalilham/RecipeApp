package dev.faizal.home

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.faizal.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import dev.faizal.home.viewmodel.HomeState
import dev.faizal.shared.component.BaseRefreshView
import dev.faizal.shared.component.RecipeSkeletonView
import dev.faizal.ui.RecipeView
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import androidx.compose.runtime.Composable
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone

@Composable
fun HomeScreen(
    navigateToDetails : (Int) -> Unit
){
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

//    LaunchedEffect(Unit) {
//        viewModel.getAllRecipe() // bakal reload pas balik home
//    }

    Scaffold {
        BaseRefreshView(
            isRefreshing = state.isRefreshing,
            onRefresh = { viewModel.getAllRecipe() }
        ) {
            HomeContent{
                RecipeList(
                    state = state,
                    refreshData = viewModel::getAllRecipe,
                    navigateToDetails = navigateToDetails
                )
            }
        }
    }
}

@Composable
fun HomeContent(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = getGreetingMessage(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Let's cook something\nunique today 🔥",
            style = MaterialTheme.typography.titleLarge,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth().weight(1f),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {  },
                        placeholder = {
                            Text(
                                text = "Try 'Italian Lasagna'",
                                color = Color.LightGray,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .clickable {  },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        singleLine = true,
                        readOnly = true,
                        enabled = false
                    )
                }
            }

            Card(
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Filter",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        content()
    }
}

@Composable
fun RecipeList(
    state : HomeState,
    refreshData : () -> Unit,
    navigateToDetails : (Int) -> Unit,
){
    when {
        state.isLoading -> {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(count = 2),
                verticalItemSpacing = 12.dp,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(10) {
                    RecipeSkeletonView()
                }
            }

        }
        state.recipes.isNotEmpty() -> {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(count = 2),
                verticalItemSpacing = 12.dp,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(
                    items = state.recipes,
                    key = { it.id }
                ) {
                    RecipeView(
                        recipe = it,
                        onClick = navigateToDetails
                    )
                }
            }
        }
        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.errorMessage.toString(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = refreshData // viewModel.getAllRecipe(initialLoad = true)
                    ) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Composable
fun getGreetingMessage(): String {
    val currentHour = remember {
        Clock.System.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .hour
    }

    return when (currentHour) {
        in 5..11 -> "Good Morning"
        in 12..16 -> "Good Afternoon"
        in 17..20 -> "Good Evening"
        else -> "Good Night"
    }
}