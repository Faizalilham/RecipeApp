package dev.faizal.data.mapper

import dev.faizal.model.domain.food.ingredient.Ingredient
import dev.faizal.model.domain.food.recipe.RecipeData
import dev.faizal.network.model.food.ingredient.IngredientDto
import dev.faizal.network.model.food.recipe.RecipeDto
import dev.faizal.database.entity.food.ingredient.IngredientEntity
import dev.faizal.database.entity.food.recipe.RecipeEntity
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

object RecipeMapper {

    fun RecipeDto.toDomain(ingredients: List<Ingredient>, isFavorite: Boolean = false): RecipeData {
        return RecipeData(
            id = id,
            title = title,
            image = image,
            readyInMinutes = readyInMinutes,
            servings = servings,
            sourceUrl = sourceUrl,
            vegetarian = vegetarian,
            vegan = vegan,
            glutenFree = glutenFree,
            dairyFree = dairyFree,
            veryHealthy = veryHealthy,
            aggregateLikes = aggregateLikes,
            healthScore = healthScore,
            pricePerServing = pricePerServing,
            extendedIngredients = ingredients,
            summary = summary,
            cuisines = cuisines,
            dishTypes = dishTypes,
            diets = diets,
            instructions = instructions,
            spoonacularScore = spoonacularScore,
            imageType = imageType,
            creditsText = creditsText,
            license = license,
            sourceName = sourceName,
            occasions = occasions,
            originalId = originalId,
            cheap = cheap,
            analyzedInstructions = listOf(),
            veryPopular = veryPopular,
            sustainable = sustainable,
            lowFodmap = lowFodmap,
            weightWatcherSmartPoints = weightWatcherSmartPoints,
            gaps = null,
            preparationMinutes = null,
            cookingMinutes = null,
            spoonacularSourceUrl = spoonacularSourceUrl,
            isFavorite = isFavorite
        )
    }

    fun IngredientDto.toDomain(): Ingredient {
        return Ingredient(
            id = id,
            name = name,
            original = original,
            amount = amount,
            unit = unit,
            aisle = aisle,
            image = image,
            consistency = consistency,
            nameClean = name,
            originalName = originalName,
            meta = meta,
            measures = null
        )
    }


    fun RecipeEntity.toDomain(ingredients: List<Ingredient>): RecipeData {
        return RecipeData(
            id = id,
            title = title,
            image = image,
            readyInMinutes = readyInMinutes,
            servings = servings,
            sourceUrl = sourceUrl,
            vegetarian = vegetarian,
            vegan = vegan,
            glutenFree = glutenFree,
            dairyFree = dairyFree,
            veryHealthy = veryHealthy,
            aggregateLikes = aggregateLikes,
            healthScore = healthScore,
            pricePerServing = pricePerServing,
            extendedIngredients = ingredients,
            summary = summary,
            cuisines = Json.decodeFromString(cuisinesJson),
            dishTypes = Json.decodeFromString(dishTypesJson),
            diets = Json.decodeFromString(dietsJson),
            instructions = instructions,
            spoonacularScore = spoonacularScore,
            imageType = null,
            creditsText = null,
            license = null,
            sourceName = null,
            occasions = listOf(),
            originalId = null,
            cheap = false,
            analyzedInstructions = listOf(),
            veryPopular = false,
            sustainable = false,
            lowFodmap = false,
            weightWatcherSmartPoints = 0,
            gaps = null,
            preparationMinutes = null,
            cookingMinutes = null,
            spoonacularSourceUrl = null,
            isFavorite = isFavorite
        )
    }

    fun IngredientEntity.toDomain(): Ingredient {
        return Ingredient(
            id = id,
            name = name,
            original = original,
            amount = amount,
            unit = unit,
            aisle = null,
            image = null,
            consistency = null,
            nameClean = name,
            originalName = "",
            meta = listOf(),
            measures = null
        )
    }

    fun RecipeData.toEntity(): RecipeEntity {
        return RecipeEntity(
            id = id,
            title = title,
            image = image,
            readyInMinutes = readyInMinutes,
            servings = servings,
            sourceUrl = sourceUrl,
            vegetarian = vegetarian,
            vegan = vegan,
            glutenFree = glutenFree,
            dairyFree = dairyFree,
            veryHealthy = veryHealthy,
            aggregateLikes = aggregateLikes,
            healthScore = healthScore,
            pricePerServing = pricePerServing,
            summary = summary,
            instructions = instructions,
            spoonacularScore = spoonacularScore,
            cuisinesJson = Json.encodeToString(cuisines),
            dishTypesJson = Json.encodeToString(dishTypes),
            dietsJson = Json.encodeToString(diets),
            isFavorite = false
        )
    }

    fun Ingredient.toEntity(recipeId: Int): IngredientEntity {
        return IngredientEntity(
            recipeId = recipeId,
            id = id,
            name = name,
            original = original,
            amount = amount,
            unit = unit
        )
    }
}