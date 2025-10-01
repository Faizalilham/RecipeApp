package dev.faizal.data.repository

import dev.faizal.data.mapper.DataMapper.toDomain
import dev.faizal.data.network.data.KtorRemoteRecipeDataSource
import dev.faizal.domain.model.recipe.Recipe
import dev.faizal.domain.repository.RecipeRepository
import dev.faizal.shared.wrapper.DataError
import dev.faizal.shared.wrapper.Result
import dev.faizal.shared.wrapper.map

class RecipeRepositoryImpl(
    private val recipeRemoteRecipeDataSource: KtorRemoteRecipeDataSource
) : RecipeRepository {

    override suspend fun getRandomRecipe(
        includeNutrition: Boolean,
        includeTags: String,
        excludeTags: String,
        number: Int
    ): Result<List<Recipe>, DataError.Remote> {
        return recipeRemoteRecipeDataSource
            .getRandomRecipe(includeNutrition,includeTags,excludeTags,number).map { dto ->
                dto.recipes.map { it.toDomain() }
            }
    }

    override suspend fun getDetailRecipe(recipeId: Int): Result<Recipe, DataError.Remote> {
        return recipeRemoteRecipeDataSource.getDetailRecipe(recipeId).map { dto -> dto.toDomain() }
    }

    override suspend fun searchRecipe(
        query: String,
        sort: String?,
        number: Int,
        offset: Int
    ): Result<List<Recipe>, DataError.Remote> {
        TODO("Not yet implemented")
    }
}