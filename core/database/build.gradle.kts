plugins {
    alias(libs.plugins.notimoji.android.library)
    alias(libs.plugins.notimoji.android.hilt)
    alias(libs.plugins.notimoji.kotlin.serialization)
}

android {
    namespace = "mgh.morteza.core.database"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {

    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}