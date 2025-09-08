package dev.faizal.network.model.food.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponseDto(
    @SerialName("recipes") val recipes: List<RecipeDto>
)
