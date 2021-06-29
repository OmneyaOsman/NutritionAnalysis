package com.omni.home.di

import com.google.gson.Gson
import com.omni.analysis_shared_data.data.remote.NutritionService
import com.omni.home.data.repository.HomeRepositoryImp
import com.omni.home.domain.usecase.AnalyzeIngredientsUseCase
import com.omni.home.domain.validation.TextValidationRule
import com.omni.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val homeFeatureModule = module {
    single { TextValidationRule() }
    single { provideHomeRepository(get(), get()) }
    single { provideAnalyzeNutritionUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
}


fun provideHomeRepository(service: NutritionService, gson: Gson): HomeRepositoryImp =
    HomeRepositoryImp(service, gson)


fun provideAnalyzeNutritionUseCase(repository: HomeRepositoryImp): AnalyzeIngredientsUseCase =
    AnalyzeIngredientsUseCase(repository)