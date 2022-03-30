package com.beo.foody.data

import com.beo.foody.data.database.RecipesDao
import com.beo.foody.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val recipesDao: RecipesDao) {

    fun readRecipes(): Flow<List<RecipesEntity>>{
        return recipesDao.readRecipes()
    }

    suspend fun insertRecipe(recipesEntity: RecipesEntity) {
        recipesDao.insertRecipes(recipesEntity)
    }
}