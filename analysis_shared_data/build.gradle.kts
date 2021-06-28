plugins {
    id("com.android.library")
    id("androidx.navigation.safeargs")
    id("nutrition_analysis.plugin")
    id("kotlin-android")
}
dependencies {
    implementation(project(mapOf("path" to ":core")))
    retrofit()
    lifecycle()

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.AndroidX.coreTesting)
    testImplementation(TestDependencies.TEST_KOTLINX_COROUTINES) {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
    testImplementation(TestDependencies.TURBIN)
    mockito()

}