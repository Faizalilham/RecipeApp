package dev.faizal.data.network.dto.measure

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeasureDto(
    @SerialName("amount") val amount: Double,
    @SerialName("unitShort") val unitShort: String?,
    @SerialName("unitLong") val unitLong: String?
)