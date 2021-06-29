package com.omni.nutritionanalysis

import android.app.Application
import com.devexy.nutritionanalysis.BuildConfig
import com.omni.analysis_shared_data.di.analysisSharedDataModule
import com.omni.di.networkModule
import com.omni.home.di.homeFeatureModule
import com.omni.summary.di.summaryFeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class NutritionAnalysisApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        setupTimber()
        setUpKoin()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement) =
                    "${super.createStackElementTag(element)}:${element.lineNumber}"
            })
        }
    }

    private fun setUpKoin() {
        startKoin {
            androidContext(this@NutritionAnalysisApplication)
            modules(
                listOf(
                    networkModule,
                    analysisSharedDataModule,
                    homeFeatureModule,
                    summaryFeatureModule,
                )
            )
        }
    }
}