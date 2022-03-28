package com.beo.foody.data

import com.beo.foody.data.network.FoodRecipesApi
import com.beo.foody.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

// Use the @Inject annotation on the constructor of a class to tell Hilt how to provide instances of that class
class RemoteDataSource @Inject constructor(private val foodRecipesApi: FoodRecipesApi) {
    suspend fun getRecipes(queries : Map<String, String>) : Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}