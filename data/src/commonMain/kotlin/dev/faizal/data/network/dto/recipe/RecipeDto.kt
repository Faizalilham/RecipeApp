package dev.faizal.data.network.dto.recipe

import dev.faizal.data.network.dto.ingredient.IngredientDto
import dev.faizal.data.network.dto.instructions.AnalyzedInstructionDto
import dev.faizal.data.network.dto.nutritions.NutritionDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    @SerialName("id") val id: Int,
    @SerialName("image") val image: String?,
    @SerialName("imageType") val imageType: String?,
    @SerialName("title") val title: String,
    @SerialName("vegetarian") val vegetarian: Boolean,
    @SerialName("vegan") val vegan: Boolean,
    @SerialName("readyInMinutes") val readyInMinutes: Int,
    @SerialName("servings") val servings: Int,
    @SerialName("sourceUrl") val sourceUrl: String?,
    @SerialName("cookingMinutes") val cookingMinutes: Int?,
    @SerialName("veryPopular") val veryPopular: Boolean,
    @SerialName("veryHealthy") val veryHealthy: Boolean,
    @SerialName("aggregateLikes") val aggregateLikes: Int,
    @SerialName("healthScore") val healthScore: Double,
    @SerialName("sourceName") val sourceName: String?,
    @SerialName("pricePerServing") val pricePerServing: Double,
    @SerialName("extendedIngredients") val extendedIngredients: List<IngredientDto>,
    @SerialName("nutrition") val nutrition: NutritionDto,
    @SerialName("summary") val summary: String?,
    @SerialName("cuisines") val cuisines: List<String>,
    @SerialName("dishTypes") val dishTypes: List<String>,
    @SerialName("diets") val diets: List<String>,
    @SerialName("occasions") val occasions: List<String>,
    @SerialName("instructions") val instructions: String?,
    @SerialName("analyzedInstructions") val analyzedInstructions: List<AnalyzedInstructionDto>,
    @SerialName("spoonacularScore") val spoonacularScore: Double,
    @SerialName("spoonacularSourceUrl") val spoonacularSourceUrl: String?
)
