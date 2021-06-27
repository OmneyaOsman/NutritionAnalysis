package com.omni.home.data.remote

import com.omni.home.data.model.request.IngredientRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NutritionService {

    @POST("nutrition-details")
    suspend fun analyzeFood(@Body ingredientRequestModel: IngredientRequestModel): Response<String>
}