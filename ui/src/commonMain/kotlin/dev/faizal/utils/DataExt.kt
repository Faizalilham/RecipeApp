package dev.faizal.utils

import dev.faizal.domain.model.nutritions.Nutrition
import dev.faizal.domain.model.recipe.Recipe

fun Recipe.getDifficultyLevel(): String {
    var difficultyScore = 0
    when {
        readyInMinutes <= 20 -> difficultyScore += 1
        readyInMinutes <= 45 -> difficultyScore += 2
        readyInMinutes <= 90 -> difficultyScore += 3
        else -> difficultyScore += 4
    }


    difficultyScore += when {
        extendedIngredients.size <= 5 -> 1
        extendedIngredients.size <= 10 -> 2
        else -> 3
    }


    val totalSteps = analyzedInstructions.flatMap { it.steps }.size
    difficultyScore += when {
        totalSteps <= 4 -> 1
        totalSteps <= 8 -> 2
        else -> 3
    }

    return when {
        difficultyScore <= 4 -> "Easy"
        difficultyScore <= 7 -> "Medium"
        else -> "Hard"
    }
}

fun Nutrition.getCalories(): Int {
    return nutrients.find { it.name == "Calories" }?.amount?.toInt() ?: 0
}