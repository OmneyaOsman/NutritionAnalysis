package com.omni.home.domain.repository

import com.omni.core.wrapper.ResponseWrapper
import com.omni.analysis_shared_data.data.model.request.IngredientRequestModel

interface HomeRepository {

    suspend fun analyzeFood(ingredientRequestModel: IngredientRequestModel): ResponseWrapper
}