import mgh.morteza.notimoji.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm") // todo, add this plugin in project's gradle too, Before use JvmLibraryConventionPlugin
            }
            configureKotlinJvm()
        }
    }
}