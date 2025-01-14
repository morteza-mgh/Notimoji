plugins {
    alias(libs.plugins.notimoji.android.library)
    alias(libs.plugins.notimoji.android.library.compose)
}


android {
    namespace = "mgh.morteza.core.designsystem"
}

dependencies {

    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    implementation(libs.material)
    api(libs.androidx.material3)
    api(libs.androidx.ui)
    api(libs.constraintlayout.compose)
    debugImplementation(libs.androidx.ui.tooling)
    api(libs.androidx.ui.tooling.preview)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}