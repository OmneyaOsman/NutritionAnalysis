package com.omni.analysis_shared_data.data.model.response


import com.google.gson.annotations.SerializedName
import com.omni.analysis_shared_data.data.model.response.CustomDataClass

data class TotalNutrientsKCal(
    @SerializedName("CHOCDF_KCAL")
    val cHOCDFKCAL: CustomDataClass? = null,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: CustomDataClass? = null,
    @SerializedName("FAT_KCAL")
    val fATKCAL: CustomDataClass? = null,
    @SerializedName("PROCNT_KCAL")
    val pROCNTKCAL: CustomDataClass? = null
)