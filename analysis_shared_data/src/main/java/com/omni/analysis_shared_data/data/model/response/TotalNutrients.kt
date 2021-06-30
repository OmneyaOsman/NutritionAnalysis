package com.omni.analysis_shared_data.data.model.response


import com.google.gson.annotations.SerializedName

data class TotalNutrients(
    @SerializedName("CA")
    val cA: CustomNutritionDataModel? = null,
    @SerializedName("CHOCDF")
    val cHOCDF: CustomNutritionDataModel? = null,
    @SerializedName("CHOLE")
    val cHOLE: CustomNutritionDataModel? = null,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: CustomNutritionDataModel? = null,
    @SerializedName("FAMS")
    val fAMS: CustomNutritionDataModel? = null,
    @SerializedName("FAPU")
    val fAPU: CustomNutritionDataModel? = null,
    @SerializedName("FASAT")
    val fASAT: CustomNutritionDataModel? = null,
    @SerializedName("FAT")
    val fAT: CustomNutritionDataModel? = null,
    @SerializedName("FE")
    val fE: CustomNutritionDataModel? = null,
    @SerializedName("FIBTG")
    val fIBTG: CustomNutritionDataModel? = null,
    @SerializedName("FOLAC")
    val fOLAC: CustomNutritionDataModel? = null,
    @SerializedName("FOLDFE")
    val fOLDFE: CustomNutritionDataModel? = null,
    @SerializedName("FOLFD")
    val fOLFD: CustomNutritionDataModel? = null,
    @SerializedName("K")
    val k: CustomNutritionDataModel? = null,
    @SerializedName("MG")
    val mG: CustomNutritionDataModel? = null,
    @SerializedName("NA")
    val nA: CustomNutritionDataModel? = null,
    @SerializedName("NIA")
    val nIA: CustomNutritionDataModel? = null,
    @SerializedName("P")
    val p: CustomNutritionDataModel? = null,
    @SerializedName("PROCNT")
    val pROCNT: CustomNutritionDataModel? = null,
    @SerializedName("RIBF")
    val rIBF: CustomNutritionDataModel? = null,
    @SerializedName("SUGAR")
    val sUGAR: CustomNutritionDataModel? = null,
    @SerializedName("THIA")
    val tHIA: CustomNutritionDataModel? = null,
    @SerializedName("TOCPHA")
    val tOCPHA: CustomNutritionDataModel? = null,
    @SerializedName("VITA_RAE")
    val vITARAE: CustomNutritionDataModel? = null,
    @SerializedName("VITB12")
    val vITB12: CustomNutritionDataModel? = null,
    @SerializedName("VITB6A")
    val vITB6A: CustomNutritionDataModel? = null,
    @SerializedName("VITC")
    val vITC: CustomNutritionDataModel? = null,
    @SerializedName("VITD")
    val vITD: CustomNutritionDataModel? = null,
    @SerializedName("VITK1")
    val vITK1: CustomNutritionDataModel? = null,
    @SerializedName("WATER")
    val wATER: CustomNutritionDataModel? = null,
    @SerializedName("ZN")
    val zN: CustomNutritionDataModel? = null,
)