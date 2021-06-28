package com.omni.home.di

import com.omni.home.domain.validation.TextValidationRule
import com.omni.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val homeFeatureModule = module {
    single { TextValidationRule() }
    viewModel { HomeViewModel(get(), get()) }
}


