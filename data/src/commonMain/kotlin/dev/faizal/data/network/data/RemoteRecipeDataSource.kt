package dev.faizal.data.network.data

import dev.faizal.data.network.dto.recipe.RecipeDto
import dev.faizal.data.network.dto.recipe.RecipeDtoResponse
import dev.faizal.shared.wrapper.DataError
import dev.faizal.shared.wrapper.Result

interface RemoteRecipeDataSource {

    suspend fun getRandomRecipe(
        includeNutrition : Boolean,
        includeTags : String,
        excludeTags : String,
        number : Int
    ): Result<RecipeDtoResponse, DataError.Remote>

    suspend fun getDetailRecipe(recipeId : Int): Result<RecipeDto, DataError.Remote>

}