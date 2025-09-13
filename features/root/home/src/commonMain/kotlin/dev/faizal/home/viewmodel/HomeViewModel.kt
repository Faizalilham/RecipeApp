package dev.faizal.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.faizal.domain.dummy.RecipeDummyData
import dev.faizal.domain.repository.RecipeRepository
import dev.faizal.shared.ui.toUiText
import dev.faizal.shared.wrapper.onError
import dev.faizal.shared.wrapper.onSuccess
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository : RecipeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getAllRecipe(initialLoad = true) // Hanya load pertama kali
    }

    fun getAllRecipe(initialLoad: Boolean = false) = viewModelScope.launch {
        _state.update {
            if (initialLoad) it.copy(isLoading = true)
            else it.copy(isRefreshing = true)
        }

        delay(500)
        _state.update {
            it.copy(
                isLoading = false,
                isRefreshing = false,
                errorMessage = null,
                recipes = RecipeDummyData.getDummyRecipes()
            )
        }
//        repository.getRandomRecipe(
//            includeNutrition = true,
//            includeTags = "",
//            excludeTags = "",
//            number = 10
//        ).onSuccess { recipes ->
//            _state.update {
//                it.copy(
//                    isLoading = false,
//                    isRefreshing = false,
//                    errorMessage = null,
//                    recipes = recipes
//                )
//            }
//        }.onError { error ->
//            _state.update {
//                it.copy(
//                    isLoading = false,
//                    isRefreshing = false,
//                    errorMessage = error.toUiText(),
//                    recipes = emptyList()
//                )
//            }
//        }

    }
}