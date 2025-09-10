package dev.faizal.data.network.dto.instructions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnalyzedInstructionDto(
    @SerialName("name") val name: String?,
    @SerialName("steps") val steps: List<StepDto>
)
