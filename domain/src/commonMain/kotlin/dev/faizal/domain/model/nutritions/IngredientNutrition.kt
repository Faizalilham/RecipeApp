package dev.faizal.domain.model.nutritions

data class IngredientNutrition(
    val id: Int,
    val name: String,
    val amount: Double,
    val unit: String,
    val nutrients: List<Nutrient>
)