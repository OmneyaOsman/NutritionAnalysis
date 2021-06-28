package com.omni.analysis_shared_data.data.remote

import com.omni.analysis_shared_data.data.model.request.IngredientRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NutritionService {

    @POST("nutrition-details")
    suspend fun analyzeFood(@Body ingredientRequestModel: IngredientRequestModel): Response<String>
}