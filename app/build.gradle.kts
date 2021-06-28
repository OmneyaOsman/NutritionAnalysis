plugins {
    id("com.android.application")
    id("nutrition_analysis.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-android")
}


dependencies {
    implementation(project(":di"))
    implementation(project(":core"))
    implementation(project(":home"))
    implementation(project(":navigation"))


    appCompat()
    androidXNavigation()
    implementation(Dependencies.CONSTRAINTLAYOUT)
    implementation(Dependencies.KOTLIN_REFLECT)

}
android {
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
