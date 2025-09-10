package dev.faizal.domain.model.ingredient

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
    val meta: List<String>
)
