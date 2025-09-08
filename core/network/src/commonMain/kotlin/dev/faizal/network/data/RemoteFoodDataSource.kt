package dev.faizal.network.data

import dev.faizal.network.model.food.recipe.RecipeResponseDto
import dev.faizal.model.utils.DataError
import dev.faizal.model.request.food.FoodRandomRequest
import dev.faizal.model.utils.Result


interface RemoteFoodDataSource {

    suspend fun getRandomFood(req: FoodRandomRequest): Result<RecipeResponseDto, DataError.Remote>

}