package dev.faizal.domain.model.food.step



data class Step(
    val number: Int,
    val step: String,
    val ingredients: List<InstructionIngredient>,
    val equipment: List<InstructionIngredient>,
    val length: Length?
)
