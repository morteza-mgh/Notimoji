plugins {
    alias(libs.plugins.notimoji.android.library)
    alias(libs.plugins.notimoji.android.library.compose)
}

android {
    namespace = "mgh.morteza.core.ui"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.designsystem)

    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}