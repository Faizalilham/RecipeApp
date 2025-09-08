package dev.faizal.network.model.food.measures

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeasuresDto(
    @SerialName("us") val us: MeasureDto?,
    @SerialName("metric") val metric: MeasureDto?
)

