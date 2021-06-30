package com.omni.analysis_shared_data.domain.usecase

import com.omni.analysis_shared_data.data.model.request.IngredientRequestModel
import com.omni.analysis_shared_data.domain.repository.NutritionAnalysisRepository

class AnalyzeIngredientsUseCase (private val repository: NutritionAnalysisRepository) {
    suspend operator fun invoke(ingredientRequestModel: IngredientRequestModel) =
        repository.analyzeFood(ingredientRequestModel)
}