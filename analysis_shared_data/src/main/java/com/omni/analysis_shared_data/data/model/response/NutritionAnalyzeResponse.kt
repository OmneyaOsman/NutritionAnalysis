package com.omni.analysis_shared_data.data.model.response


import com.google.gson.annotations.SerializedName

data class NutritionAnalyzeResponse(
    @SerializedName("calories")
    val calories: Int? = null,
    @SerializedName("cautions")
    val cautions: List<String>? = emptyList(),
    @SerializedName("dietLabels")
    val dietLabels: List<String>?= emptyList(),
    @SerializedName("healthLabels")
    val healthLabels: List<String>?= emptyList(),
    @SerializedName("totalDaily")
    val totalDaily: TotalDaily? = null,
    @SerializedName("totalNutrients")
    val totalNutrients: TotalNutrients? = null,
    @SerializedName("totalNutrientsKCal")
    val totalNutrientsKCal: TotalNutrientsKCal? = null,
    @SerializedName("totalWeight")
    val totalWeight: Int? = null,
    @SerializedName("uri")
    val uri: String? = null
)