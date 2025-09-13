package dev.faizal.data.network.dto.nutritions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NutrientDto(
    @SerialName("name") val name: String,
    @SerialName("amount") val amount: Double,
    @SerialName("unit") val unit: String,
    @SerialName("percentOfDailyNeeds") val percentOfDailyNeeds: Double
)
