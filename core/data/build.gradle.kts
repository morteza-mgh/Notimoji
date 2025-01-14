plugins {
    alias(libs.plugins.notimoji.android.library)
    alias(libs.plugins.notimoji.android.hilt)
}

android {
    namespace = "mgh.morteza.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.model)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}