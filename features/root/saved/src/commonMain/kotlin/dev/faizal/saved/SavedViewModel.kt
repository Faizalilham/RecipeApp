package dev.faizal.saved

import androidx.lifecycle.ViewModel
import dev.faizal.domain.model.recipe.Recipe
import dev.faizal.domain.repository.RecipeRepository

class SavedViewModel(
    private val repository : RecipeRepository
) : ViewModel() {

    fun getSavedRecipes() = listOf<Recipe>()
}