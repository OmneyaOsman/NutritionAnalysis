package com.omni.nutritionanalysis

import android.app.Application
import com.devexy.nutritionanalysis.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class NutritionAnalysisApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement) =
                    "${super.createStackElementTag(element)}:${element.lineNumber}"
            })
        }
    }
}