plugins {
    id("com.android.application")
    id("nutrition_analysis.plugin")
    id("androidx.navigation.safeargs")
}


dependencies {
    implementation(project(":di"))
    implementation(project(":core"))
    appCompat()
    implementation(Dependencies.KOTLIN_REFLECT)

}