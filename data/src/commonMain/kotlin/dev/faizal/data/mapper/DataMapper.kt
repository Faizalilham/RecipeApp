package dev.faizal.data.mapper

import dev.faizal.data.network.dto.ingredient.IngredientDto
import dev.faizal.data.network.dto.instructions.AnalyzedInstructionDto
import dev.faizal.data.network.dto.instructions.EquipmentDto
import dev.faizal.data.network.dto.instructions.InstructionIngredientDto
import dev.faizal.data.network.dto.instructions.StepDto
import dev.faizal.data.network.dto.measure.MeasureDto
import dev.faizal.data.network.dto.measure.MeasuresDto
import dev.faizal.data.network.dto.nutritions.CaloricBreakdownDto
import dev.faizal.data.network.dto.nutritions.FlavonoidDto
import dev.faizal.data.network.dto.nutritions.IngredientNutritionDto
import dev.faizal.data.network.dto.nutritions.NutrientDto
import dev.faizal.data.network.dto.nutritions.NutritionDto
import dev.faizal.data.network.dto.nutritions.PropertyDto
import dev.faizal.data.network.dto.nutritions.WeightPerServingDto
import dev.faizal.data.network.dto.recipe.RecipeDto
import dev.faizal.domain.model.ingredient.Ingredient
import dev.faizal.domain.model.instructions.AnalyzedInstruction
import dev.faizal.domain.model.instructions.Equipment
import dev.faizal.domain.model.instructions.InstructionIngredient
import dev.faizal.domain.model.instructions.Step
import dev.faizal.domain.model.measure.Measure
import dev.faizal.domain.model.measure.Measures
import dev.faizal.domain.model.nutritions.CaloricBreakdown
import dev.faizal.domain.model.nutritions.Flavonoid
import dev.faizal.domain.model.nutritions.IngredientNutrition
import dev.faizal.domain.model.nutritions.Nutrient
import dev.faizal.domain.model.nutritions.Nutrition
import dev.faizal.domain.model.nutritions.Property
import dev.faizal.domain.model.nutritions.WeightPerServing
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
            spoonacularSourceUrl = spoonacularSourceUrl,
            nutrition = nutrition.toDomain()
        )
    }

    fun NutritionDto.toDomain(): Nutrition {
        return Nutrition(
            nutrients = nutrients.map { it.toDomain() },
            properties = properties.map { it.toDomain() },
            flavonoids = flavonoids.map { it.toDomain() },
            ingredients = ingredients.map { it.toDomain() },
            caloricBreakdown = caloricBreakdown.toDomain(),
            weightPerServing = weightPerServing.toDomain()
        )
    }

    fun NutrientDto.toDomain(): Nutrient {
        return Nutrient(
            name = name,
            amount = amount,
            unit = unit,
            percentOfDailyNeeds = percentOfDailyNeeds
        )
    }

    fun PropertyDto.toDomain(): Property {
        return Property(
            name = name,
            amount = amount,
            unit = unit
        )
    }

    fun FlavonoidDto.toDomain(): Flavonoid {
        return Flavonoid(
            name = name,
            amount = amount,
            unit = unit
        )
    }

    fun IngredientNutritionDto.toDomain(): IngredientNutrition {
        return IngredientNutrition(
            id = id,
            name = name,
            amount = amount,
            unit = unit,
            nutrients = nutrients.map { it.toDomain() }
        )
    }

    fun CaloricBreakdownDto.toDomain(): CaloricBreakdown {
        return CaloricBreakdown(
            percentProtein = percentProtein,
            percentFat = percentFat,
            percentCarbs = percentCarbs
        )
    }

    fun WeightPerServingDto.toDomain(): WeightPerServing {
        return WeightPerServing(
            amount = amount,
            unit = unit
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
            meta = meta,
            measures = measures.toDomain()
        )
    }

    fun MeasuresDto.toDomain(): Measures{
        return Measures(
            us = us?.toDomain(),
            metric = metric?.toDomain()
        )
    }

    fun MeasureDto.toDomain() : Measure{
        return Measure(
            amount = amount,
            unitShort = unitShort,
            unitLong = unitLong
        )
    }

    fun EquipmentDto.toDomain() : Equipment{
        return Equipment(
            id = id,
            name = name,
            localizedName = localizedName,
            image = image
        )
    }


}