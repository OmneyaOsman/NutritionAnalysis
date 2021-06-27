plugins {
    id("com.android.library")
    id("kotlin-android")
    id("nutrition_analysis.plugin")
}

android {
    defaultConfig {

        buildConfigField(
            "String",
            "BASE_URL",
            project.properties["BASE_URL"] as String
        )
    }
}
dependencies {
    implementation(project(":core"))
    retrofit()
}
