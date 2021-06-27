package com.omni.home.data.repository

import com.google.gson.Gson
import com.omni.core.wrapper.ResponseWrapper
import com.omni.core.wrapper.ResponseWrapperHandler
import com.omni.home.data.model.request.IngredientRequestModel
import com.omni.home.data.model.response.NutritionAnalyzeResponse
import com.omni.home.data.remote.NutritionService
import com.omni.home.domain.repository.HomeRepository

class HomeRepositoryImp (
    private val service: NutritionService,
    private val gson: Gson
) : HomeRepository {
    override suspend fun analyzeFood(ingredientRequestModel: IngredientRequestModel): ResponseWrapper =
        ResponseWrapperHandler.handleResponseWithoutMapper<NutritionAnalyzeResponse>(
            {
                service.analyzeFood(ingredientRequestModel)
            }, gson
        )
}