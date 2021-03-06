package com.omni.analysis_shared_data.domain.repository

import com.omni.core.wrapper.ResponseWrapper
import com.omni.analysis_shared_data.data.model.request.IngredientRequestModel

interface NutritionAnalysisRepository {

    suspend fun analyzeFood(ingredientRequestModel: IngredientRequestModel): ResponseWrapper
}