package dev.faizal.network.model.food.step

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StepDto(
    @SerialName("number") val number: Int,
    @SerialName("step") val step: String,
    @SerialName("ingredients") val ingredients: List<InstructionIngredientDto>,
    @SerialName("equipment") val equipment: List<InstructionIngredientDto>,
    @SerialName("length") val length: LengthDto?
)
