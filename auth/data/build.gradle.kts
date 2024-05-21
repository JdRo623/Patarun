plugins {
    alias(libs.plugins.patarun.android.library)
    alias(libs.plugins.patarun.jvm.ktor)

}

android {
    namespace = "com.pb.auth.data"
}

dependencies {

    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)


}