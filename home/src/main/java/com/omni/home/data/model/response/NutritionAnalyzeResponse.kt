package com.omni.home.data.model.response


import com.google.gson.annotations.SerializedName

data class NutritionAnalyzeResponse(
    @SerializedName("calories")
    val calories: Int?,
    @SerializedName("cautions")
    val cautions: List<String>?,
    @SerializedName("dietLabels")
    val dietLabels: List<String>?,
    @SerializedName("healthLabels")
    val healthLabels: List<String>?,
    @SerializedName("totalDaily")
    val totalDaily: TotalDaily?,
    @SerializedName("totalNutrients")
    val totalNutrients: TotalNutrients?,
    @SerializedName("totalNutrientsKCal")
    val totalNutrientsKCal: TotalNutrientsKCal?,
    @SerializedName("totalWeight")
    val totalWeight: Int?,
    @SerializedName("uri")
    val uri: String?
)