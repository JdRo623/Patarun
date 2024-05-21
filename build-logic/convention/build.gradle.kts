plugins {
    `kotlin-dsl`
}

group = "com.pb.patarun.buildLogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin{
    plugins{
        register("androidApplication"){
            id = "patarun.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose"){
            id = "patarun.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary"){
            id = "patarun.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose"){
            id = "patarun.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeatureUi"){
            id = "patarun.android.feature.ui"
            implementationClass = "AndroidFeatureUiComposeConventionPlugin"
        }

        register("androidRoom"){
            id = "patarun.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}