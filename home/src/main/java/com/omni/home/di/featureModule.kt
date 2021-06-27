package com.omni.home.di

import com.google.gson.Gson
import com.omni.home.data.remote.NutritionService
import com.omni.home.data.repository.HomeRepositoryImp
import com.omni.home.domain.repository.HomeRepository
import com.omni.home.domain.usecase.AnalyzeIngredientsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
object HomeFeatureModule {

    @Singleton
    @Provides
    fun provideNutritionServiceAPI(retrofit: Retrofit): NutritionService =
        retrofit.create(NutritionService::class.java)

    @Singleton
    @Provides
    fun provideHomeRepository(service: NutritionService, gson: Gson): HomeRepository =
        HomeRepositoryImp(service, gson)

    @Singleton
    @Provides
    fun provideAnalyzeNutritionUseCase(repository: HomeRepositoryImp): AnalyzeIngredientsUseCase =
        AnalyzeIngredientsUseCase(repository)


}