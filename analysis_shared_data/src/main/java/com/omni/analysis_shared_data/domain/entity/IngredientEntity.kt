package com.omni.analysis_shared_data.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class IngredientEntity(
    var quantity: String = "",
    var unit: String = "",
    var food: String = "",
    var calories: String = "",
    var weight: String = ""
) : Parcelable