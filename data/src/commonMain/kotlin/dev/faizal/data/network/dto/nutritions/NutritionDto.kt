package dev.faizal.data.network.dto.nutritions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NutritionDto(
    @SerialName("nutrients") val nutrients: List<NutrientDto>,
    @SerialName("properties") val properties: List<PropertyDto>,
    @SerialName("flavonoids") val flavonoids: List<FlavonoidDto>,
    @SerialName("ingredients") val ingredients: List<IngredientNutritionDto>,
    @SerialName("caloricBreakdown") val caloricBreakdown: CaloricBreakdownDto,
    @SerialName("weightPerServing") val weightPerServing: WeightPerServingDto
)