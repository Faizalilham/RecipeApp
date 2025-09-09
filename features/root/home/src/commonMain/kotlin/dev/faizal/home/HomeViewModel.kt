package dev.faizal.home

import androidx.lifecycle.ViewModel
import dev.faizal.shared.domain.RecipeRepository

class HomeViewModel(
    private val repository : RecipeRepository
) : ViewModel() {

    fun getAllRecipe() = repository.getAllRecipes()
}