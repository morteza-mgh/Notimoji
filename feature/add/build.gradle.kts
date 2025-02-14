plugins {
    alias(libs.plugins.notimoji.android.feature)
    alias(libs.plugins.notimoji.android.library.compose)
}

android {
    namespace = "mgh.morteza.feature.add"
}

dependencies {

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}