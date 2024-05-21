plugins {
    alias(libs.plugins.patarun.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}