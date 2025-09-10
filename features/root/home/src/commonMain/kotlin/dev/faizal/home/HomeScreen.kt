package dev.faizal.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.faizal.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import dev.faizal.shared.component.BaseRefreshView
import dev.faizal.shared.component.RecipeSkeletonView
import dev.faizal.ui.RecipeView

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
            when {
                state.isLoading -> {
                    LazyVerticalStaggeredGrid(
                        modifier = Modifier.padding(horizontal = 12.dp),
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
                        modifier = Modifier.padding(horizontal = 12.dp),
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
                                onClick = { viewModel.getAllRecipe(initialLoad = true) }
                            ) {
                                Text("Retry")
                            }
                        }
                    }
                }
            }
        }
    }
}