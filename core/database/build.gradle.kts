plugins {
    alias(libs.plugins.patarun.android.library)
    alias(libs.plugins.patarun.android.room)
}

android {
    namespace = "com.pb.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
}