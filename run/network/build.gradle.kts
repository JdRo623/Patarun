plugins {
    alias(libs.plugins.patarun.android.library)
}

android {
    namespace = "com.pb.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)


}