plugins {
    alias(libs.plugins.notimoji.android.library)
    alias(libs.plugins.notimoji.android.hilt)
}

android {
    namespace = "mgh.morteza.core.domain"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}