package dev.faizal.data.mapper

import dev.faizal.data.network.dto.ingredient.IngredientDto
import dev.faizal.data.network.dto.instructions.AnalyzedInstructionDto
import dev.faizal.data.network.dto.instructions.InstructionIngredientDto
import dev.faizal.data.network.dto.instructions.StepDto
import dev.faizal.data.network.dto.recipe.RecipeDto
import dev.faizal.domain.model.ingredient.Ingredient
import dev.faizal.domain.model.instructions.AnalyzedInstruction
import dev.faizal.domain.model.instructions.InstructionIngredient
import dev.faizal.domain.model.instructions.Step
import dev.faizal.domain.model.recipe.Recipe

object DataMapper {

    fun RecipeDto.toDomain(): Recipe {
        return Recipe(
            id = id,
            image = image,
            imageType = imageType,
            title = title,
            readyInMinutes = readyInMinutes,
            servings = servings,
            sourceUrl = sourceUrl,
            cookingMinutes = cookingMinutes,
            aggregateLikes = aggregateLikes,
            healthScore = healthScore,
            sourceName = sourceName,
            pricePerServing = pricePerServing,
            extendedIngredients = extendedIngredients.map { it.toDomain() },
            summary = summary,
            cuisines = cuisines,
            dishTypes = dishTypes,
            diets = diets,
            occasions = occasions,
            instructions = instructions,
            analyzedInstructions = analyzedInstructions.map { it.toDomain() },
            spoonacularScore = spoonacularScore,
            spoonacularSourceUrl = spoonacularSourceUrl
        )
    }

    fun AnalyzedInstructionDto.toDomain(): AnalyzedInstruction {
        return AnalyzedInstruction(
            name = name,
            steps = steps.map { it.toDomain() }
        )
    }

    fun StepDto.toDomain(): Step {
        return Step(
            number = number,
            step = step,
            ingredients = ingredients.map { it.toDomain() },
            equipment = equipment.map { it.toDomain() }
        )
    }

    fun InstructionIngredientDto.toDomain(): InstructionIngredient {
        return InstructionIngredient(
            id = id,
            name = name,
            localizedName = localizedName,
            image = image
        )
    }

    fun IngredientDto.toDomain(): Ingredient {
        return Ingredient(
            id = id,
            aisle = aisle,
            image = image,
            consistency = consistency,
            name = name,
            nameClean = nameClean,
            original = original,
            originalName = originalName,
            amount = amount,
            unit = unit,
            meta = meta
        )
    }


}