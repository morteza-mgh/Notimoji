import com.android.build.api.dsl.ApplicationExtension
import mgh.morteza.notimoji.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = BuildVersions.targetSdk
            }

            // uncomment this when you want faster build and do not want test build tasks to run
//            tasks.disableTestBuild()
        }
    }
}