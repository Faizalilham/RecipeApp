package dev.faizal.domain.model.recipe

import dev.faizal.domain.model.ingredient.Ingredient
import dev.faizal.domain.model.instructions.AnalyzedInstruction

data class Recipe(
    val id: Int,
    val image: String?,
    val imageType: String?,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String?,
    val cookingMinutes: Int?,
    val aggregateLikes: Int,
    val healthScore: Double,
    val sourceName: String?,
    val pricePerServing: Double,
    val extendedIngredients: List<Ingredient>,
    val summary: String?,
    val cuisines: List<String>,
    val dishTypes: List<String>,
    val diets: List<String>,
    val occasions: List<String>,
    val instructions: String?,
    val analyzedInstructions: List<AnalyzedInstruction>,
    val spoonacularScore: Double,
    val spoonacularSourceUrl: String?,
    val isFavorite : Boolean = false
)