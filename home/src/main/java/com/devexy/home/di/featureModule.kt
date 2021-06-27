package com.devexy.home.di

import com.devexy.home.data.remote.NutritionService
import retrofit2.Retrofit

fun provideEditEmailAPI(retrofit: Retrofit): NutritionService =
    retrofit.create(NutritionService::class.java)