plugins {
    alias(libs.plugins.patarun.android.library)
    alias(libs.plugins.patarun.jvm.ktor)

}

android {
    namespace = "com.pb.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(projects.core.domain)
    implementation(projects.core.database)
}