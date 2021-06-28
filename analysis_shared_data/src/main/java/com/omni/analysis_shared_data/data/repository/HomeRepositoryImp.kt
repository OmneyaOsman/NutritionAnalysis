package com.omni.analysis_shared_data.data.repository

import com.google.gson.Gson
import com.omni.core.wrapper.ResponseWrapper
import com.omni.core.wrapper.ResponseWrapperHandler
import com.omni.analysis_shared_data.data.model.request.IngredientRequestModel
import com.omni.analysis_shared_data.data.model.response.NutritionAnalyzeResponse
import com.omni.analysis_shared_data.data.remote.NutritionService
import com.omni.analysis_shared_data.domain.repository.HomeRepository

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