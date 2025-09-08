package dev.faizal.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.faizal.database.dao.food.RecipeDao
import dev.faizal.database.entity.food.recipe.RecipeEntity
import dev.faizal.database.utils.RecipeDatabaseConstructor
import dev.faizal.database.utils.StringListTypeConverter

@Database(
    entities = [RecipeEntity::class],
    version = 1
)
@TypeConverters(
    StringListTypeConverter::class
)
@ConstructedBy(RecipeDatabaseConstructor::class)
abstract class FavoriteFoodDatabase: RoomDatabase() {
    abstract val favoriteRecipeDao: RecipeDao

    companion object {
        const val DB_NAME = "recipe.db"
    }
}