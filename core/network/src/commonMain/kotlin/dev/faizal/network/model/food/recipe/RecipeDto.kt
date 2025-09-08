package dev.faizal.network.model.food.recipe

import dev.faizal.network.model.food.ingredient.IngredientDto
import dev.faizal.network.model.food.step.AnalyzedInstructionDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    @SerialName("id") val id: Int,
    @SerialName("image") val image: String?,
    @SerialName("imageType") val imageType: String?,
    @SerialName("title") val title: String,
    @SerialName("readyInMinutes") val readyInMinutes: Int,
    @SerialName("servings") val servings: Int,
    @SerialName("sourceUrl") val sourceUrl: String?,
    @SerialName("vegetarian") val vegetarian: Boolean,
    @SerialName("vegan") val vegan: Boolean,
    @SerialName("glutenFree") val glutenFree: Boolean,
    @SerialName("dairyFree") val dairyFree: Boolean,
    @SerialName("veryHealthy") val veryHealthy: Boolean,
    @SerialName("cheap") val cheap: Boolean,
    @SerialName("veryPopular") val veryPopular: Boolean,
    @SerialName("sustainable") val sustainable: Boolean,
    @SerialName("lowFodmap") val lowFodmap: Boolean,
    @SerialName("weightWatcherSmartPoints") val weightWatcherSmartPoints: Int,
    @SerialName("gaps") val gaps: String?,
    @SerialName("preparationMinutes") val preparationMinutes: Int?,
    @SerialName("cookingMinutes") val cookingMinutes: Int?,
    @SerialName("aggregateLikes") val aggregateLikes: Int,
    @SerialName("healthScore") val healthScore: Double,
    @SerialName("creditsText") val creditsText: String?,
    @SerialName("license") val license: String?,
    @SerialName("sourceName") val sourceName: String?,
    @SerialName("pricePerServing") val pricePerServing: Double,
    @SerialName("extendedIngredients") val extendedIngredients: List<IngredientDto>,
    @SerialName("summary") val summary: String?,
    @SerialName("cuisines") val cuisines: List<String>,
    @SerialName("dishTypes") val dishTypes: List<String>,
    @SerialName("diets") val diets: List<String>,
    @SerialName("occasions") val occasions: List<String>,
    @SerialName("instructions") val instructions: String?,
    @SerialName("analyzedInstructions") val analyzedInstructions: List<AnalyzedInstructionDto>,
    @SerialName("originalId") val originalId: Int?,
    @SerialName("spoonacularScore") val spoonacularScore: Double,
    @SerialName("spoonacularSourceUrl") val spoonacularSourceUrl: String?
)
