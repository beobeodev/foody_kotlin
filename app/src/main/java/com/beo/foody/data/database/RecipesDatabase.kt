package com.beo.foody.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.beo.foody.data.database.entities.RecipesEntity

@Database(
    entities = [RecipesEntity::class],
    version = 1,
    exportSchema = false,
)

// Specifies additional type converters that Room can use.
// The TypeConverter is added to the scope of the element so if you put it
// on a class / interface, all methods / fields in that class will be able to use the converters.
@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase : RoomDatabase() {

    abstract fun recipesDao(): RecipesDao
}