package dev.faizal.database.entity.food.recipe

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Clock

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val image: String?,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String?,
    val vegetarian: Boolean,
    val vegan: Boolean,
    val glutenFree: Boolean,
    val dairyFree: Boolean,
    val veryHealthy: Boolean,
    val aggregateLikes: Int,
    val healthScore: Double,
    val pricePerServing: Double,
    val summary: String?,
    val instructions: String?,
    val spoonacularScore: Double,
    val cuisinesJson: String, // Store as JSON string
    val dishTypesJson: String, // Store as JSON string
    val dietsJson: String, // Store as JSON string
    val createdAt: Long = Clock.System.now().toEpochMilliseconds(),
    val isFavorite: Boolean = false
)
