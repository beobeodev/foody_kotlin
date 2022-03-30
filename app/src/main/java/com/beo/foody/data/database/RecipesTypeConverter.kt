package com.beo.foody.data.database

import androidx.room.TypeConverter
import com.beo.foody.models.FoodRecipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesTypeConverter {
    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): FoodRecipe {
        // get type of class
        val turnType = object: TypeToken<FoodRecipe>(){}.type
        return gson.fromJson(data, turnType)
    }
}