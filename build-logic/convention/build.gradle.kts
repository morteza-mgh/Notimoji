plugins {
    `kotlin-dsl`
}

group = "mgh.morteza.notimoji.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "notimoji.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidApplication") {
            id = "notimoji.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "notimoji.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "notimoji.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeature") {
            id = "notimoji.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidFlavors") {
            id = "notimoji.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }

        register("androidHilt") {
            id = "notimoji.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("jvmLibrary") {
            id = "notimoji.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("kotlinSerialization") {
            id = "notimoji.kotlin.serialization"
            implementationClass = "KotlinSerializationPlugin"
        }
    }
}