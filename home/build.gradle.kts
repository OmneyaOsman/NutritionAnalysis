plugins {
    id("com.android.library")
    id("androidx.navigation.safeargs")
    id("nutrition_analysis.plugin")
    id("kotlin-android")
}
dependencies {
    implementation(project(mapOf("path" to ":core")))
    appCompat()
    retrofit()
}