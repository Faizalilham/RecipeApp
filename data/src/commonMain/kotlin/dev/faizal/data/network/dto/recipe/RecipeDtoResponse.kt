package dev.faizal.data.network.dto.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDtoResponse(
    @SerialName("recipes") val recipes: List<RecipeDto>
)
