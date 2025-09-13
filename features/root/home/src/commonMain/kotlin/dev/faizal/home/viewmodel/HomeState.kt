package dev.faizal.home.viewmodel


import dev.faizal.domain.model.recipe.Recipe
import dev.faizal.shared.ui.UiText

data class HomeState(
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val recipes: List<Recipe> = emptyList(),
    val errorMessage: UiText? = null
)