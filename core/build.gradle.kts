plugins {
    id("com.android.library")
    id("nutrition_analysis.plugin")
    id("kotlin-android")
}
android{
    defaultConfig{
        buildConfigField(
            "String",
            "API_KEY",
            project.properties["API_KEY"] as String
        )

        buildConfigField(
            "String",
            "APP_ID",
            project.properties["APP_ID"] as String
        )
    }
}
dependencies {
    appCompat()
    implementation(Dependencies.GSON)
}