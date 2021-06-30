package com.omni.summary.di

import com.omni.summary.presentation.viewModel.SummaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val summaryFeatureModule = module {

    viewModel { SummaryViewModel() }
}