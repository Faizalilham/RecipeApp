package dev.faizal.data.network.dto.nutritions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CaloricBreakdownDto(
    @SerialName("percentProtein") val percentProtein: Double,
    @SerialName("percentFat") val percentFat: Double,
    @SerialName("percentCarbs") val percentCarbs: Double
)
