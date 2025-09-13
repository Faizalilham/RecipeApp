package dev.faizal.data.network.dto.ingredient

import dev.faizal.data.network.dto.measure.MeasuresDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientDto(
    @SerialName("id") val id: Int,
    @SerialName("aisle") val aisle: String?,
    @SerialName("image") val image: String?,
    @SerialName("consistency") val consistency: String?,
    @SerialName("name") val name: String,
    @SerialName("nameClean") val nameClean: String?,
    @SerialName("original") val original: String,
    @SerialName("originalName") val originalName: String,
    @SerialName("amount") val amount: Double,
    @SerialName("unit") val unit: String?,
    @SerialName("meta") val meta: List<String>,
    @SerialName("measures") val measures: MeasuresDto,
)
