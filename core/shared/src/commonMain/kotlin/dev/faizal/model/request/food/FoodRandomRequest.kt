package dev.faizal.model.request.food

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoodRandomRequest(
    @SerialName("includeNutrition") val includeNutrition: Boolean,
    @SerialName("include-tags") val includeTags: String,
    @SerialName("exclude-tags") val excludeTags: String,
    @SerialName("number") val number: Int
)
