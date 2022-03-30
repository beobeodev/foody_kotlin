package com.beo.foody.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.beo.foody.models.FoodRecipe
import com.beo.foody.util.Constants

@Entity(tableName = Constants.RECIPES_TABLE)
class RecipesEntity(var foodRecipe: FoodRecipe) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 50
}