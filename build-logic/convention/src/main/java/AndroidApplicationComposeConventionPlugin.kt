import com.android.build.api.dsl.ApplicationExtension
import com.pb.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin: Plugin<Project>{
    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("patarun.android.application")
            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }
}