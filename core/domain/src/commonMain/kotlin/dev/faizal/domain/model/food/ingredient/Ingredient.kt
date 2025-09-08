package dev.faizal.domain.model.food.ingredient

import dev.faizal.domain.model.food.measures.Measures

data class Ingredient(
    val id: Int,
    val aisle: String?,
    val image: String?,
    val consistency: String?,
    val name: String,
    val nameClean: String?,
    val original: String,
    val originalName: String,
    val amount: Double,
    val unit: String?,
    val meta: List<String>,
    val measures: Measures?
)
