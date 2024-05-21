plugins {
    alias(libs.plugins.patarun.android.library)
}

android {
    namespace = "com.pb.core.database"
}

dependencies {

    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
}