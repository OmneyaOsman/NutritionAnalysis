plugins {
    id("com.android.application")
    id("nutrition_analysis.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
}


dependencies {
    appCompat()
    implementation (Dependencies.KOTLIN_REFLECT)
}