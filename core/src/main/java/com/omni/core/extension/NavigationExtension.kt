package com.omni.core.extension

import android.os.Bundle
import androidx.navigation.NavController
import timber.log.Timber


fun NavController.navigateSafe(action: Int, bundle: Bundle) {
    try {
        navigate(action, bundle)
    } catch (e: IllegalArgumentException) {
        Timber.e(e)
    }
}

fun NavController.navigateSafe(action: Int) {
    try {
        navigate(action)
    } catch (e: IllegalArgumentException) {
        Timber.e(e)
    }
}