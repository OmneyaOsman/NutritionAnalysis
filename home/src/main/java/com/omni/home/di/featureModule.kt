package com.omni.home.di

import com.google.gson.Gson
import com.omni.home.data.remote.NutritionService
import com.omni.home.data.repository.HomeRepositoryImp
import com.omni.home.domain.repository.HomeRepository
import com.omni.home.domain.usecase.AnalyzeIngredientsUseCase
import com.omni.home.domain.validation.TextValidationRule
import com.omni.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val homeFeatureModule = module {
    factory { provideNutritionServiceAPI(get()) }
    single { provideHomeRepository(get(), get()) }
    single { TextValidationRule() }
    single { provideAnalyzeNutritionUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
}

fun provideNutritionServiceAPI(retrofit: Retrofit): NutritionService =
    retrofit.create(NutritionService::class.java)


fun provideHomeRepository(service: NutritionService, gson: Gson): HomeRepositoryImp =
    HomeRepositoryImp(service, gson)


fun provideAnalyzeNutritionUseCase(repository: HomeRepositoryImp): AnalyzeIngredientsUseCase =
    AnalyzeIngredientsUseCase(repository)

