package dev.faizal.network.model.food.step

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class LengthDto(
    @SerialName("number") val number: Int,
    @SerialName("unit") val unit: String
)
