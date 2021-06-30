package com.omni.analysis_shared_data

import androidx.lifecycle.ViewModel
import com.devexy.core.livedata.SingleLiveEvent
import com.omni.analysis_shared_data.domain.entity.IngredientEntity

class AnalysisSharedViewModel : ViewModel() {

    val ingredientEntities = SingleLiveEvent<List<IngredientEntity>>()
    val ingredientRequestModel = SingleLiveEvent<List<String>>()


    fun setIngredientData(list: List<IngredientEntity>, requestModel: List<String>) {
        ingredientEntities.postValue(list)
        ingredientRequestModel.value = requestModel
    }
}
