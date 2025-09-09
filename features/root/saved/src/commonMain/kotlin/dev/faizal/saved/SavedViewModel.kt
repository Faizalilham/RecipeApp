package dev.faizal.saved

import androidx.lifecycle.ViewModel
import dev.faizal.shared.domain.RecipeRepository

class SavedViewModel(
    private val repository : RecipeRepository
) : ViewModel() {

    fun getSavedRecipes() = repository.getSavedRecipes()
}