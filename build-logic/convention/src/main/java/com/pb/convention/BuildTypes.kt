package com.pb.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *>,
    extensionTypes: ExtensionTypes
){
    commonExtension.run {
        buildFeatures{
            buildConfig = true
        }
        val apiKey = gradleLocalProperties(rootDir).getProperty("API_KEY")
        when(extensionTypes){
            ExtensionTypes.LIBRARY ->{
                extensions.configure<LibraryExtension>(){
                    buildTypes{
                        create("Staging"){
                            configureReleaseBuildType(commonExtension, apiKey)
                        }
                        debug {
                            configureDebugBuildType(apiKey)
                        }

                        release {
                            configureReleaseBuildType(commonExtension, apiKey)
                        }
                    }
                }
            }

            ExtensionTypes.APPLICATION -> {
                extensions.configure<ApplicationExtension>(){
                    buildTypes{
                        create("Staging"){
                            configureReleaseBuildType(commonExtension, apiKey)
                        }
                        debug {
                            configureDebugBuildType(apiKey)
                        }

                        release {
                            configureReleaseBuildType(commonExtension, apiKey)
                        }
                    }
                }
            }
        }

    }
}

private fun BuildType.configureDebugBuildType(apiKey:String){
    buildConfigField("String","API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"\$https:runique.pl-coding.com:8080\"")
}

private fun BuildType.configureReleaseBuildType(
    commonException: CommonExtension<*,*,*,*,*>,
    apiKey:String){
    buildConfigField("String","API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"\$https:runique.pl-coding.com:8080\"")
    isMinifyEnabled = false
    proguardFiles(
        commonException.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}