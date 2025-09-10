package dev.faizal.domain.repository

import dev.faizal.domain.model.recipe.Recipe
import dev.faizal.shared.wrapper.DataError
import dev.faizal.shared.wrapper.Result

interface RecipeRepository {

    suspend fun getRandomRecipe(
        includeNutrition : Boolean,
        includeTags : String,
        excludeTags : String,
        number : Int
    ): Result<List<Recipe>, DataError.Remote>

    suspend fun getDetailRecipe(recipeId : Int): Result<Recipe, DataError.Remote>
}