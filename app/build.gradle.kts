plugins {
    alias(libs.plugins.notimoji.android.application)
    alias(libs.plugins.notimoji.android.application.compose)
    alias(libs.plugins.notimoji.android.application.flavors)
    alias(libs.plugins.notimoji.android.hilt)
}

android {
    namespace = "mgh.morteza.notimoji"
    compileSdk = BuildVersions.compileSdk

    defaultConfig {
        applicationId = "mgh.morteza.notimoji"
        versionCode = BuildVersions.versionCode
        versionName = BuildVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        buildConfig = true
    }

}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.feature.main)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}