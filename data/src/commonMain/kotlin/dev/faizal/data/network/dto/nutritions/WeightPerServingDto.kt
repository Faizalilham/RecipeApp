package dev.faizal.data.network.dto.nutritions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WeightPerServingDto(
    @SerialName("amount") val amount: Int,
    @SerialName("unit") val unit: String
)
