package com.omni.home.data.model.response


import com.google.gson.annotations.SerializedName

data class TotalNutrientsKCal(
    @SerializedName("CHOCDF_KCAL")
    val cHOCDFKCAL: CHOCDFKCAL?,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: ENERCKCALXX?,
    @SerializedName("FAT_KCAL")
    val fATKCAL: FATKCAL?,
    @SerializedName("PROCNT_KCAL")
    val pROCNTKCAL: PROCNTKCAL?
)