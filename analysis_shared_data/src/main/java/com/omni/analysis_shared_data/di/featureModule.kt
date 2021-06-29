package com.omni.analysis_shared_data.di

import com.google.gson.Gson
import com.omni.analysis_shared_data.data.remote.NutritionService
import org.koin.dsl.module
import retrofit2.Retrofit


val analysisSharedDataModule = module {
    factory { provideNutritionServiceAPI(get()) }

}

fun provideNutritionServiceAPI(retrofit: Retrofit): NutritionService =
    retrofit.create(NutritionService::class.java)




