package dev.faizal.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.faizal.shared.component.RecipeView
import dev.faizal.shared.domain.RecipeRepository
import dev.faizal.shared.domain.foodRecipes
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    navigateToDetails : (Int) -> Unit
){
//    val repository = koinInject<RecipeRepository>()
//    val viewModel = viewModel { HomeViewModel(repository) }
    val viewModel = koinViewModel<HomeViewModel>()
    val allRecipes = viewModel.getAllRecipe()
    Scaffold {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(
                horizontal = 12.dp
            ),
            columns = StaggeredGridCells.Fixed(count = 2),
            verticalItemSpacing = 12.dp,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
           items(
               items = allRecipes,
               key = { it.id }
           ) {
               RecipeView(
                   recipe = it,
                   onClick = navigateToDetails
               )
           }
        }
    }
}