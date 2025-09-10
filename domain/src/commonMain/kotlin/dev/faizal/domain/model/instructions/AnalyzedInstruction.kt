package dev.faizal.domain.model.instructions

data class AnalyzedInstruction(
    val name: String?,
    val steps: List<Step>
)

data class InstructionIngredient(
    val id: Int,
    val name: String,
    val localizedName: String,
    val image: String
)

data class Step(
    val number: Int,
    val step: String,
    val ingredients: List<InstructionIngredient>,
    val equipment: List<InstructionIngredient>
)




