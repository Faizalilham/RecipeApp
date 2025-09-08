package dev.faizal.network.data


import dev.faizal.network.model.food.recipe.RecipeResponseDto
import dev.faizal.model.utils.DataError
import dev.faizal.model.utils.Result
import dev.faizal.model.request.food.FoodRandomRequest
import dev.faizal.network.utils.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

const val BASE_URL = "https://api.spoonacular.com"
const val API_KEY = "5cfab6728c3646f4a8d586b5ac5ca4dc"

class KtorFoodRemoteDataSource(
    private val httpClient: HttpClient
): RemoteFoodDataSource {
    override suspend fun getRandomFood(req: FoodRandomRequest): Result<RecipeResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$BASE_URL/recipes/random"
            ) {
                parameter("apiKey", API_KEY)
            }
        }
    }
}