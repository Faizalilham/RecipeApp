package dev.faizal.domain.dummy

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


object RecipeDummyData {

    fun getDummyRecipes(): List<Recipe> {
        return listOf(
            createBakedCaramelCustard(),
            createChocolateBrownie(),
            createVegetableStirFry(),
            createChickenTeriyaki(),
            createCaesarSalad()
        )
    }

    private fun createBakedCaramelCustard(): Recipe {
        return Recipe(
            id = 633492,
            image = "https://img.spoonacular.com/recipes/633492-556x370.jpeg",
            imageType = "jpeg",
            title = "Baked Caramel Custard",
            readyInMinutes = 45,
            servings = 6,
            sourceUrl = "https://www.foodista.com/recipe/WFB2KTYC/baked-caramel-custard",
            cookingMinutes = null,
            aggregateLikes = 46,
            healthScore = 8.0,
            sourceName = "Foodista",
            pricePerServing = 76.26,
            extendedIngredients = listOf(
                Ingredient(
                    id = 1226,
                    aisle = "Health Foods",
                    image = "liquid-egg-substitute.jpg",
                    consistency = "SOLID",
                    name = "egg substitute",
                    nameClean = "egg substitute",
                    original = "1 cup egg substitute",
                    originalName = "egg substitute",
                    amount = 1.0,
                    unit = "cup",
                    meta = emptyList(),
                    measures = Measures(
                        us = Measure(1.0, "cup", "cup"),
                        metric = Measure(240.0, "ml", "milliliters")
                    )
                ),
                Ingredient(
                    id = 19335,
                    aisle = "Baking",
                    image = "sugar-in-bowl.png",
                    consistency = "SOLID",
                    name = "sugar",
                    nameClean = "sugar",
                    original = "1 cup sugar plus 2 tablespoons",
                    originalName = "sugar",
                    amount = 1.125,
                    unit = "cup",
                    meta = emptyList(),
                    measures = Measures(
                        us = Measure(1.125, "cup", "cup"),
                        metric = Measure(225.0, "g", "grams")
                    )
                )
            ),
            nutrition = Nutrition(
                nutrients = listOf(
                    Nutrient("Calories", 249.81, "kcal", 12.49),
                    Nutrient("Fat", 1.09, "g", 1.68),
                    Nutrient("Protein", 11.41, "g", 22.83),
                    Nutrient("Carbohydrates", 48.78, "g", 16.26)
                ),
                properties = listOf(
                    Property("Glycemic Index", 28.91, ""),
                    Property("Glycemic Load", 27.06, "")
                ),
                flavonoids = listOf(
                    Flavonoid("Quercetin", 0.03, "mg"),
                    Flavonoid("Catechin", 0.16, "mg")
                ),
                ingredients = listOf(
                    IngredientNutrition(
                        id = 11124,
                        name = "carrots",
                        amount = 37.5,
                        unit = "g",
                        nutrients = listOf(
                            Nutrient("Calories", 15.38, "kcal", 4.76),
                            Nutrient("Carbohydrates", 3.58, "g", 5.5),
                            Nutrient("Sugar", 3.22, "g", 3.58),
                            Nutrient("Fiber", 1.05, "g", 4.2),
                            Nutrient("Protein", 0.35, "g", 7.6),
                            Nutrient("Fat", 0.09, "g", 4.77),
                            Nutrient("Vitamin A", 6157.5, "IU", 123.15),
                            Nutrient("Vitamin C", 2.21, "mg", 2.46),
                            Nutrient("Vitamin K", 4.89, "µg", 4.07),
                            Nutrient("Folate", 7.12, "µg", 1.78),
                            Nutrient("Potassium", 120.0, "mg", 3.43),
                            Nutrient("Calcium", 12.38, "mg", 1.24),
                            Nutrient("Iron", 0.11, "mg", 0.61),
                            Nutrient("Magnesium", 4.5, "mg", 1.07),
                            Nutrient("Phosphorus", 13.12, "mg", 1.31),
                            Nutrient("Sodium", 25.88, "mg", 1.13),
                            Nutrient("Zinc", 0.09, "mg", 0.82),
                            Nutrient("Copper", 0.02, "mg", 2.22),
                            Nutrient("Manganese", 0.05, "mg", 2.61),
                            Nutrient("Selenium", 0.04, "µg", 0.07)
                        )
                    ),
                    IngredientNutrition(
                        id = 11260,
                        name = "mushrooms",
                        amount = 25.0,
                        unit = "g",
                        nutrients = listOf(
                            Nutrient("Calories", 5.5, "kcal", 4.76),
                            Nutrient("Carbohydrates", 1.03, "g", 5.5),
                            Nutrient("Sugar", 0.49, "g", 0.54),
                            Nutrient("Fiber", 0.25, "g", 1.0),
                            Nutrient("Protein", 0.77, "g", 7.6),
                            Nutrient("Fat", 0.09, "g", 4.77),
                            Nutrient("Vitamin D", 0.05, "µg", 0.33),
                            Nutrient("Vitamin B2", 0.1, "mg", 7.69),
                            Nutrient("Vitamin B3", 0.89, "mg", 5.56),
                            Nutrient("Vitamin B5", 0.38, "mg", 7.6),
                            Nutrient("Folate", 4.25, "µg", 1.06),
                            Nutrient("Potassium", 81.25, "mg", 2.32),
                            Nutrient("Phosphorus", 21.5, "mg", 2.15),
                            Nutrient("Selenium", 2.35, "µg", 4.27),
                            Nutrient("Copper", 0.08, "mg", 8.89),
                            Nutrient("Zinc", 0.13, "mg", 1.18)
                        )
                    ),
                    IngredientNutrition(
                        id = 4053,
                        name = "olive oil",
                        amount = 2.5,
                        unit = "ml",
                        nutrients = listOf(
                            Nutrient("Calories", 22.05, "kcal", 4.76),
                            Nutrient("Fat", 2.5, "g", 4.77),
                            Nutrient("Saturated Fat", 0.34, "g", 1.7),
                            Nutrient("Monounsaturated Fat", 1.82, "g", 0.0),
                            Nutrient("Polyunsaturated Fat", 0.26, "g", 0.0),
                            Nutrient("Vitamin E", 0.35, "mg", 2.33),
                            Nutrient("Vitamin K", 1.5, "µg", 1.25),
                            Nutrient("Omega-3", 0.02, "g", 0.0),
                            Nutrient("Omega-6", 0.24, "g", 0.0),
                            Nutrient("Choline", 0.01, "mg", 0.0)
                        )
                    )
                ),
                caloricBreakdown = CaloricBreakdown(18.22, 3.92, 77.86),
                weightPerServing = WeightPerServing(209, "g")
            ),
            summary = "Delicious baked caramel custard that serves 6 people and takes 45 minutes to prepare.",
            cuisines = emptyList(),
            dishTypes = listOf("dessert"),
            diets = listOf("gluten free"),
            occasions = emptyList(),
            instructions = "Preheat oven to 350°F. Mix ingredients and bake for 40 minutes.",
            analyzedInstructions = listOf(
                AnalyzedInstruction(
                    name = "",
                    steps = listOf(
                        Step(
                            number = 1,
                            step = "Pre-heat oven to 325 degrees with rack in middle.",
                            ingredients = emptyList(),
                            equipment = listOf(
                                Equipment(404784, "oven", "oven", "https://spoonacular.com/cdn/equipment_100x100/oven.jpg")
                            )
                        ),
                        Step(
                            number = 2,
                            step = "Mix ground flaxseed with water and set aside. If using a loaf pan: grease & flour a 9x5x3 loaf pan. If making muffins, line with liners or grease & flour muffin pan.",
                            ingredients = listOf(
                                InstructionIngredient(12220, "ground flaxseed", "ground flaxseed", "flax-seeds.png"),
                                InstructionIngredient(20081, "all purpose flour", "all purpose flour", "flour.png"),
                                InstructionIngredient(14412, "water", "water", "water.png")
                            ),
                            equipment = listOf(
                                Equipment(404671, "muffin tray", "muffin tray", "https://spoonacular.com/cdn/equipment_100x100/muffin-tray.jpg"),
                                Equipment(404715, "loaf pan", "loaf pan", "https://spoonacular.com/cdn/equipment_100x100/loaf-pan.png")
                            )
                        ),
                        Step(
                            number = 3,
                            step = "Whisk together flours, baking soda, and salt. In separate large bowl, mix together flaxseed mixture, agave, and apple sauce until combined.",
                            ingredients = listOf(
                                InstructionIngredient(9019, "applesauce", "applesauce", "applesauce.png"),
                                InstructionIngredient(18372, "baking soda", "baking soda", "white-powder.jpg"),
                                InstructionIngredient(10012220, "flaxseed", "flaxseed", "flax-seeds.png"),
                                InstructionIngredient(19912, "agave", "agave", "agave.png"),
                                InstructionIngredient(2047, "salt", "salt", "salt.jpg")
                            ),
                            equipment = listOf(
                                Equipment(404661, "whisk", "whisk", "https://spoonacular.com/cdn/equipment_100x100/whisk.png"),
                                Equipment(404783, "bowl", "bowl", "https://spoonacular.com/cdn/equipment_100x100/bowl.jpg")
                            )
                        ),
                        Step(
                            number = 4,
                            step = "Add flour mixture and when combined add in vanilla, and bananas.",
                            ingredients = listOf(
                                InstructionIngredient(9040, "banana", "banana", "https://spoonacular.com/cdn/ingredients_100x100/bananas.jpg"),
                                InstructionIngredient(1052050, "vanilla", "vanilla", "vanilla.jpg"),
                                InstructionIngredient(20081, "all purpose flour", "all purpose flour", "flour.png")
                            ),
                            equipment = emptyList()
                        ),
                        Step(
                            number = 5,
                            step = "Mix until combined. Fold in 1/2 cup of walnuts and pour into prepared loaf pan. Top with remaining 1/3 cup of nuts. For loaf pan: bake for 45 to 60 minutes",
                            ingredients = listOf(
                                InstructionIngredient(12155, "walnuts", "walnuts", "https://spoonacular.com/cdn/ingredients_100x100/walnuts.jpg"),
                                InstructionIngredient(12135, "nuts", "nuts", "https://spoonacular.com/cdn/ingredients_100x100/nuts-mixed.jpg")
                            ),
                            equipment = listOf(
                                Equipment(404784, "oven", "oven", "https://spoonacular.com/cdn/equipment_100x100/oven.jpg"),
                                Equipment(404715, "loaf pan", "loaf pan", "https://spoonacular.com/cdn/equipment_100x100/loaf-pan.png")
                            )
                        ),
                        Step(
                            number = 6,
                            step = "For muffins: bake for 25-30 minutes",
                            ingredients = emptyList(),
                            equipment = listOf(
                                Equipment(404784, "oven", "oven", "https://spoonacular.com/cdn/equipment_100x100/oven.jpg")
                            )
                        ),
                        Step(
                            number = 7,
                            step = "Or until a thin knife inserted in middle comes out clean. Cool for 10 minutes on wire rack before removing from pan.",
                            ingredients = emptyList(),
                            equipment = listOf(
                                Equipment(405900, "wire rack", "wire rack", "https://spoonacular.com/cdn/equipment_100x100/wire-rack.jpg"),
                                Equipment(404745, "knife", "knife", "https://spoonacular.com/cdn/equipment_100x100/chefs-knife.jpg"),
                                Equipment(404645, "frying pan", "frying pan", "https://spoonacular.com/cdn/equipment_100x100/pan.png")
                            ),
                        )
                    )
                )
            ),
            spoonacularScore = 61.96,
            spoonacularSourceUrl = "https://spoonacular.com/baked-caramel-custard-633492"
        )
    }

    private fun createChocolateBrownie(): Recipe {
        return Recipe(
            id = 123456,
            image = "https://img.spoonacular.com/recipes/123456-556x370.jpeg",
            imageType = "jpeg",
            title = "Fudgy Chocolate Brownies",
            readyInMinutes = 60,
            servings = 12,
            sourceUrl = "https://example.com/chocolate-brownies",
            cookingMinutes = 45,
            aggregateLikes = 234,
            healthScore = 12.5,
            sourceName = "Home Baking",
            pricePerServing = 65.50,
            extendedIngredients = listOf(
                Ingredient(
                    id = 19081,
                    aisle = "Baking",
                    image = "dark-chocolate.jpg",
                    consistency = "SOLID",
                    name = "dark chocolate",
                    nameClean = "dark chocolate",
                    original = "200g dark chocolate, chopped",
                    originalName = "dark chocolate, chopped",
                    amount = 200.0,
                    unit = "g",
                    meta = listOf("chopped"),
                    measures = Measures(
                        us = Measure(7.05, "oz", "ounces"),
                        metric = Measure(200.0, "g", "grams")
                    )
                )
            ),
            nutrition = Nutrition(
                nutrients = listOf(
                    Nutrient("Calories", 320.5, "kcal", 16.03),
                    Nutrient("Fat", 18.2, "g", 28.0),
                    Nutrient("Protein", 4.8, "g", 9.6),
                    Nutrient("Carbohydrates", 38.5, "g", 12.83)
                ),
                properties = listOf(
                    Property("Glycemic Index", 45.2, ""),
                    Property("Glycemic Load", 17.4, "")
                ),
                flavonoids = listOf(
                    Flavonoid("Epicatechin", 2.5, "mg")
                ),
                ingredients = emptyList(),
                caloricBreakdown = CaloricBreakdown(6.0, 51.1, 42.9),
                weightPerServing = WeightPerServing(75, "g")
            ),
            summary = "Rich and fudgy chocolate brownies perfect for chocolate lovers.",
            cuisines = listOf("American"),
            dishTypes = listOf("dessert"),
            diets = listOf("vegetarian"),
            occasions = listOf("birthday"),
            instructions = "Melt chocolate, mix with other ingredients, bake for 45 minutes at 175°C.",
            analyzedInstructions = listOf(
                AnalyzedInstruction(
                    name = "",
                    steps = listOf(
                        Step(
                            number = 1,
                            step = "Preheat oven to 175°C",
                            ingredients = emptyList(),
                            equipment = listOf(
                                Equipment(404784, "oven", "oven", "oven.jpg")
                            ),
                            
                        )
                    )
                )
            ),
            spoonacularScore = 78.5,
            spoonacularSourceUrl = "https://spoonacular.com/chocolate-brownies-123456"
        )
    }

    private fun createVegetableStirFry(): Recipe {
        return Recipe(
            id = 789012,
            image = "https://img.spoonacular.com/recipes/789012-556x370.jpeg",
            imageType = "jpeg",
            title = "Colorful Vegetable Stir Fry",
            readyInMinutes = 25,
            servings = 4,
            sourceUrl = "https://example.com/vegetable-stir-fry",
            cookingMinutes = 10,
            aggregateLikes = 89,
            healthScore = 95.0,
            sourceName = "Healthy Living",
            pricePerServing = 45.75,
            extendedIngredients = listOf(
                Ingredient(
                    id = 11124,
                    aisle = "Produce",
                    image = "sliced-carrot.png",
                    consistency = "SOLID",
                    name = "carrots",
                    nameClean = "carrots",
                    original = "2 large carrots, sliced",
                    originalName = "carrots, sliced",
                    amount = 2.0,
                    unit = "large",
                    meta = listOf("sliced"),
                    measures = Measures(
                        us = Measure(2.0, "large", "large"),
                        metric = Measure(150.0, "g", "grams")
                    )
                )
            ),
            nutrition = Nutrition(
                nutrients = listOf(
                    Nutrient("Calories", 95.2, "kcal", 4.76),
                    Nutrient("Fat", 3.1, "g", 4.77),
                    Nutrient("Protein", 3.8, "g", 7.6),
                    Nutrient("Carbohydrates", 16.5, "g", 5.5)
                ),
                properties = listOf(
                    Property("Glycemic Index", 25.0, ""),
                    Property("Glycemic Load", 4.1, "")
                ),
                flavonoids = listOf(
                    Flavonoid("Beta Carotene", 8.5, "mg")
                ),
                ingredients = emptyList(),
                caloricBreakdown = CaloricBreakdown(15.9, 29.3, 54.8),
                weightPerServing = WeightPerServing(200, "g")
            ),
            summary = "A healthy and colorful vegetable stir fry packed with nutrients.",
            cuisines = listOf("Asian"),
            dishTypes = listOf("side dish", "lunch", "main course"),
            diets = listOf("vegetarian", "vegan", "gluten free", "dairy free"),
            occasions = listOf("weeknight"),
            instructions = "Heat oil in wok, add vegetables, stir fry for 5-7 minutes.",
            analyzedInstructions = listOf(
                AnalyzedInstruction(
                    name = "",
                    steps = listOf(
                        Step(
                            number = 1,
                            step = "Heat oil in a large wok or skillet",
                            ingredients = emptyList(),
                            equipment = listOf(
                                Equipment(404645, "wok", "wok", "wok.jpg")
                            ),
                            
                        )
                    )
                )
            ),
            spoonacularScore = 92.1,
            spoonacularSourceUrl = "https://spoonacular.com/vegetable-stir-fry-789012"
        )
    }

    private fun createChickenTeriyaki(): Recipe {
        return Recipe(
            id = 345678,
            image = "https://img.spoonacular.com/recipes/345678-556x370.jpeg",
            imageType = "jpeg",
            title = "Chicken Teriyaki Bowl",
            readyInMinutes = 35,
            servings = 4,
            sourceUrl = "https://example.com/chicken-teriyaki",
            cookingMinutes = 20,
            aggregateLikes = 456,
            healthScore = 75.0,
            sourceName = "Asian Kitchen",
            pricePerServing = 125.80,
            extendedIngredients = listOf(
                Ingredient(
                    id = 5006,
                    aisle = "Meat",
                    image = "chicken-breast.png",
                    consistency = "SOLID",
                    name = "chicken breast",
                    nameClean = "chicken breast",
                    original = "500g chicken breast, cubed",
                    originalName = "chicken breast, cubed",
                    amount = 500.0,
                    unit = "g",
                    meta = listOf("cubed"),
                    measures = Measures(
                        us = Measure(17.64, "oz", "ounces"),
                        metric = Measure(500.0, "g", "grams")
                    )
                )
            ),
            nutrition = Nutrition(
                nutrients = listOf(
                    Nutrient("Calories", 285.4, "kcal", 14.27),
                    Nutrient("Fat", 8.5, "g", 13.08),
                    Nutrient("Protein", 32.1, "g", 64.2),
                    Nutrient("Carbohydrates", 18.9, "g", 6.3)
                ),
                properties = listOf(
                    Property("Glycemic Index", 35.8, ""),
                    Property("Glycemic Load", 6.8, "")
                ),
                flavonoids = listOf(
                    Flavonoid("Quercetin", 0.15, "mg")
                ),
                ingredients = emptyList(),
                caloricBreakdown = CaloricBreakdown(45.0, 26.8, 26.5),
                weightPerServing = WeightPerServing(250, "g")
            ),
            summary = "Delicious chicken teriyaki served over steamed rice with vegetables.",
            cuisines = listOf("Japanese", "Asian"),
            dishTypes = listOf("lunch", "main course", "dinner"),
            diets = listOf("dairy free"),
            occasions = listOf("weeknight"),
            instructions = "Marinate chicken, cook in teriyaki sauce, serve over rice.",
            analyzedInstructions = listOf(
                AnalyzedInstruction(
                    name = "",
                    steps = listOf(
                        Step(
                            number = 1,
                            step = "Cut chicken into cubes and marinate",
                            ingredients = listOf(
                                InstructionIngredient(5006, "chicken", "chicken", "chicken-breast.png")
                            ),
                            equipment = listOf(
                                Equipment(0,"oven","oven","oven.jpg")
                            ),
                        )
                    )
                )
            ),
            spoonacularScore = 84.7,
            spoonacularSourceUrl = "https://spoonacular.com/chicken-teriyaki-345678"
        )
    }

    private fun createCaesarSalad(): Recipe {
        return Recipe(
            id = 901234,
            image = "https://img.spoonacular.com/recipes/901234-556x370.jpeg",
            imageType = "jpeg",
            title = "Classic Caesar Salad",
            readyInMinutes = 15,
            servings = 2,
            sourceUrl = "https://example.com/caesar-salad",
            cookingMinutes = 0,
            aggregateLikes = 178,
            healthScore = 45.0,
            sourceName = "Classic Recipes",
            pricePerServing = 89.25,
            extendedIngredients = listOf(
                Ingredient(
                    id = 11477,
                    aisle = "Produce",
                    image = "romaine-lettuce.jpg",
                    consistency = "SOLID",
                    name = "romaine lettuce",
                    nameClean = "romaine lettuce",
                    original = "1 large head romaine lettuce, chopped",
                    originalName = "romaine lettuce, chopped",
                    amount = 1.0,
                    unit = "head",
                    meta = listOf("chopped"),
                    measures = Measures(
                        us = Measure(1.0, "head", "head"),
                        metric = Measure(300.0, "g", "grams")
                    )
                )
            ),
            nutrition = Nutrition(
                nutrients = listOf(
                    Nutrient("Calories", 195.8, "kcal", 9.79),
                    Nutrient("Fat", 16.2, "g", 24.92),
                    Nutrient("Protein", 7.5, "g", 15.0),
                    Nutrient("Carbohydrates", 8.1, "g", 2.7)
                ),
                properties = listOf(
                    Property("Glycemic Index", 15.0, ""),
                    Property("Glycemic Load", 1.2, "")
                ),
                flavonoids = listOf(
                    Flavonoid("Quercetin", 1.2, "mg")
                ),
                ingredients = emptyList(),
                caloricBreakdown = CaloricBreakdown(15.3, 74.4, 16.6),
                weightPerServing = WeightPerServing(180, "g")
            ),
            summary = "A classic Caesar salad with crisp romaine lettuce and parmesan cheese.",
            cuisines = listOf("Mediterranean"),
            dishTypes = listOf("salad", "side dish", "antipasti", "starter"),
            diets = listOf("vegetarian"),
            occasions = listOf("lunch"),
            instructions = "Chop lettuce, make dressing, toss together and serve immediately.",
            analyzedInstructions = listOf(
                AnalyzedInstruction(
                    name = "",
                    steps = listOf(
                        Step(
                            number = 1,
                            step = "Wash and chop the romaine lettuce",
                            ingredients = listOf(
                                InstructionIngredient(11477, "romaine lettuce", "romaine lettuce", "romaine-lettuce.jpg")
                            ),
                            equipment = emptyList(),
                            
                        )
                    )
                )
            ),
            spoonacularScore = 67.3,
            spoonacularSourceUrl = "https://spoonacular.com/caesar-salad-901234"
        )
    }
}