package dev.faizal.data.network.data

import dev.faizal.data.network.config.safeCall
import dev.faizal.data.network.dto.recipe.RecipeDto
import dev.faizal.data.network.dto.recipe.RecipeDtoResponse
import dev.faizal.shared.wrapper.DataError
import dev.faizal.shared.wrapper.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import dev.faizal.data.BuildKonfig
import dev.faizal.data.network.dto.recipe.SearchRecipeDtoResponse

val BASE_URL = BuildKonfig.BASE_URL
val API_KEY = BuildKonfig.API_KEY

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
                parameter("includeNutrition", includeNutrition)
                parameter("apiKey", API_KEY)
            }
        }
    }

    override suspend fun getDetailRecipe(recipeId: Int): Result<RecipeDto, DataError.Remote> {
        return safeCall<RecipeDto> {
            httpClient.get(
                urlString = "$BASE_URL/recipes/${recipeId}/information"
            ) {
                parameter("includeNutrition", true)
                parameter("apiKey", API_KEY)
            }
        }
    }

    override suspend fun searchRecipe(
        query: String,
        sort: String?,
        number: Int,
        offset: Int
    ): Result<SearchRecipeDtoResponse, DataError.Remote> {
        return safeCall<SearchRecipeDtoResponse> {
            httpClient.get(
                urlString = "$BASE_URL/recipes/complexSearch"
            ) {
                parameter("query", query)
                parameter("number", number)
                parameter("offset", offset)
                parameter("apiKey", API_KEY)
                sort?.let { parameter("sort",it) }
            }
        }
    }
}