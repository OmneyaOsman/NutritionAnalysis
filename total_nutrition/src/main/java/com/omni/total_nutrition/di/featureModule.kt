package com.omni.total_nutrition.di

import com.omni.total_nutrition.presentation.viewmodel.TotalNutritionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val totalNutritionFeatureModule = module {
    viewModel { TotalNutritionViewModel(get()) }
}


