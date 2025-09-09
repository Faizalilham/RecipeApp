package dev.faizal.details

import androidx.lifecycle.ViewModel
import dev.faizal.shared.domain.RecipeRepository

class DetailViewModel(
    private val repository : RecipeRepository
) : ViewModel() {

    fun getSelectedRecipe(id : Int) = repository.getSelectedRecipe(id)

    fun toggleFavorite(id : Int) = repository.toggleFavorite(id)
}