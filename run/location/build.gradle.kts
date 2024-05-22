plugins {
    alias(libs.plugins.patarun.android.library)
}

android {
    namespace = "com.pb.run.location"
}

dependencies {

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)

    implementation(projects.core.domain)
    implementation(projects.core.data)

}