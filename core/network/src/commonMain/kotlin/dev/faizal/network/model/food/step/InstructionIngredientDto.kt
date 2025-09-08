package dev.faizal.network.model.food.step

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InstructionIngredientDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("localizedName") val localizedName: String,
    @SerialName("image") val image: String
)
