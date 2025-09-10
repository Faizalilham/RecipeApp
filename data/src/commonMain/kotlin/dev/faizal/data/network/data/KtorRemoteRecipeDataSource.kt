package dev.faizal.data.network.data

import dev.faizal.data.network.config.safeCall
import dev.faizal.data.network.dto.recipe.RecipeDto
import dev.faizal.data.network.dto.recipe.RecipeDtoResponse
import dev.faizal.shared.wrapper.DataError
import dev.faizal.shared.wrapper.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

const val BASE_URL = "https://api.spoonacular.com"
const val API_KEY = "5cfab6728c3646f4a8d586b5ac5ca4dc"

class KtorRemoteRecipeDataSource(
    val httpClient: HttpClient
): RemoteRecipeDataSource {

    override suspend fun getRandomRecipe(
        includeNutrition: Boolean,
        includeTags: String,
        excludeTags: String,
        number: Int
    ): Result<RecipeDtoResponse, DataError.Remote> {
        return safeCall<RecipeDtoResponse> {
            httpClient.get(
                urlString = "$BASE_URL/recipes/random"
            ) {
                parameter("number", 10)
                parameter("apiKey", API_KEY)
            }
        }
    }

    override suspend fun getDetailRecipe(recipeId: Int): Result<RecipeDto, DataError.Remote> {
        return safeCall<RecipeDto> {
            httpClient.get(
                urlString = "$BASE_URL/recipes/${recipeId}/information"
            ) {
                parameter("includeNutrition", false)
                parameter("apiKey", API_KEY)
            }
        }
    }
}