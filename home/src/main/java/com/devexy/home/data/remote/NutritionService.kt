package com.devexy.home.data.remote

import com.devexy.home.data.model.request.IngredientRequestModel
import retrofit2.http.Body
import retrofit2.http.POST

interface NutritionService {

    @POST("nutrition-details")
    suspend fun analyzeFood(@Body ingredientRequestModel: IngredientRequestModel)
}