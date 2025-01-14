pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Notimoji"
include(":app")

include(":core:ui")

// added because of gradle problem, mentioned in https://issuetracker.google.com/issues/328871352
// test to remove this line after upgrading gradle
gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))