package com.omni.home.data.model.response


import com.google.gson.annotations.SerializedName

data class TotalNutrients(
    @SerializedName("CA")
    val cA: CustomDataClass? = null,
    @SerializedName("CHOCDF")
    val cHOCDF: CustomDataClass? = null,
    @SerializedName("CHOLE")
    val cHOLE: CustomDataClass? = null,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: CustomDataClass? = null,
    @SerializedName("FAMS")
    val fAMS: CustomDataClass? = null,
    @SerializedName("FAPU")
    val fAPU: CustomDataClass? = null,
    @SerializedName("FASAT")
    val fASAT: CustomDataClass? = null,
    @SerializedName("FAT")
    val fAT: CustomDataClass? = null,
    @SerializedName("FE")
    val fE: CustomDataClass? = null,
    @SerializedName("FIBTG")
    val fIBTG: CustomDataClass? = null,
    @SerializedName("FOLAC")
    val fOLAC: CustomDataClass? = null,
    @SerializedName("FOLDFE")
    val fOLDFE: CustomDataClass? = null,
    @SerializedName("FOLFD")
    val fOLFD: CustomDataClass? = null,
    @SerializedName("K")
    val k: CustomDataClass? = null,
    @SerializedName("MG")
    val mG: CustomDataClass? = null,
    @SerializedName("NA")
    val nA: CustomDataClass? = null,
    @SerializedName("NIA")
    val nIA: CustomDataClass? = null,
    @SerializedName("P")
    val p: CustomDataClass? = null,
    @SerializedName("PROCNT")
    val pROCNT: CustomDataClass? = null,
    @SerializedName("RIBF")
    val rIBF: CustomDataClass? = null,
    @SerializedName("SUGAR")
    val sUGAR: CustomDataClass? = null,
    @SerializedName("THIA")
    val tHIA: CustomDataClass? = null,
    @SerializedName("TOCPHA")
    val tOCPHA: CustomDataClass? = null,
    @SerializedName("VITA_RAE")
    val vITARAE: CustomDataClass? = null,
    @SerializedName("VITB12")
    val vITB12: CustomDataClass? = null,
    @SerializedName("VITB6A")
    val vITB6A: CustomDataClass? = null,
    @SerializedName("VITC")
    val vITC: CustomDataClass? = null,
    @SerializedName("VITD")
    val vITD: CustomDataClass? = null,
    @SerializedName("VITK1")
    val vITK1: CustomDataClass? = null,
    @SerializedName("WATER")
    val wATER: CustomDataClass? = null,
    @SerializedName("ZN")
    val zN: CustomDataClass? = null,
)