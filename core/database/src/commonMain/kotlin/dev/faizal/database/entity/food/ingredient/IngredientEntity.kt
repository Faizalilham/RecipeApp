package dev.faizal.database.entity.food.ingredient

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class IngredientEntity(
    @PrimaryKey(autoGenerate = true)
    val ingredientId: Int = 0,
    val recipeId: Int,
    val id: Int,
    val name: String,
    val original: String,
    val amount: Double,
    val unit: String?
)