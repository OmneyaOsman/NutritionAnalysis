package com.omni.analysis_shared_data.data.model.response


import com.google.gson.annotations.SerializedName

data class TotalNutrientsKCal(
    @SerializedName("CHOCDF_KCAL")
    val cHOCDFKCAL: CustomNutritionDataModel? = null,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: CustomNutritionDataModel? = null,
    @SerializedName("FAT_KCAL")
    val fATKCAL: CustomNutritionDataModel? = null,
    @SerializedName("PROCNT_KCAL")
    val pROCNTKCAL: CustomNutritionDataModel? = null
)