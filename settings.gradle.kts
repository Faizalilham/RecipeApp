rootProject.name = "RecipeApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        maven("https://s3.amazonaws.com/mirego-maven/public")
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        maven("https://s3.amazonaws.com/mirego-maven/public")
        mavenCentral()
    }
}

include(":composeApp")
include(":navigation")
include(":features:settings")
include(":core:shared")
include(":core:network")
include(":core:database")
include(":core:data")
include(":core:domain")
