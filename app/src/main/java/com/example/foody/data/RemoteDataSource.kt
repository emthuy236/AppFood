package com.example.foody.data

import com.example.foody.data.network.FoodRecipesApi
import com.example.foody.models.FoodRecipe
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class RemoteDataSource @Inject constructor(
private val foodRecipesApi: FoodRecipesApi
) {
   suspend fun getRecipes(queries:Map<String,String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}