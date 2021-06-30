package com.omni.analysis_shared_data.di

import com.google.gson.Gson
import com.omni.analysis_shared_data.data.remote.NutritionService
import com.omni.analysis_shared_data.data.repository.NutritionAnalysisRepositoryImp
import com.omni.analysis_shared_data.domain.usecase.AnalyzeIngredientsUseCase
import org.koin.dsl.module
import retrofit2.Retrofit


val analysisSharedDataModule = module {
    factory { provideNutritionServiceAPI(get()) }
    single { provideHomeRepository(get(), get()) }
    single { provideAnalyzeNutritionUseCase(get()) }
}

fun provideNutritionServiceAPI(retrofit: Retrofit): NutritionService =
    retrofit.create(NutritionService::class.java)

fun provideHomeRepository(service: NutritionService, gson: Gson): NutritionAnalysisRepositoryImp =
    NutritionAnalysisRepositoryImp(service, gson)


fun provideAnalyzeNutritionUseCase(repository: NutritionAnalysisRepositoryImp): AnalyzeIngredientsUseCase =
    AnalyzeIngredientsUseCase(repository)


