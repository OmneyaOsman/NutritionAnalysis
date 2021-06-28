package com.omni.analysis_shared_data.domain.usecase

import com.omni.analysis_shared_data.data.model.request.IngredientRequestModel
import com.omni.analysis_shared_data.domain.repository.HomeRepository

class AnalyzeIngredientsUseCase (private val repository: HomeRepository) {
    suspend operator fun invoke(ingredientRequestModel: IngredientRequestModel) =
        repository.analyzeFood(ingredientRequestModel)
}