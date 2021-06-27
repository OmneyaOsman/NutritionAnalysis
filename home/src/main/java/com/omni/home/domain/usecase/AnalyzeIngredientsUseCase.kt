package com.omni.home.domain.usecase

import com.omni.home.data.model.request.IngredientRequestModel
import com.omni.home.domain.repository.HomeRepository
import javax.inject.Inject

class AnalyzeIngredientsUseCase @Inject constructor(private val repository: HomeRepository) {
    suspend operator fun invoke(ingredientRequestModel: IngredientRequestModel) =
        repository.analyzeFood(ingredientRequestModel)
}