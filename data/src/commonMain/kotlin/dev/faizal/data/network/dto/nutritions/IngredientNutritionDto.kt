package dev.faizal.data.network.dto.nutritions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientNutritionDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("amount") val amount: Double,
    @SerialName("unit") val unit: String,
    @SerialName("nutrients") val nutrients: List<NutrientDto>
)