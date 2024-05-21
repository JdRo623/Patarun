plugins {
    alias(libs.plugins.patarun.android.library)
    alias(libs.plugins.patarun.jvm.ktor)

}

android {
    namespace = "com.pb.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)


}