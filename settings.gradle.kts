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
        mavenCentral()
    }
}
include(":data")
include(":domain")
include(":features:root")
include(":composeApp")
include(":navigation")
include(":features:settings")
include(":features:root:joke")
include(":features:root:home")
include(":features:root:details")
include(":features:root:saved")
include(":di")
include(":features:onboarding")
include(":ui")
include(":shared")
include(":root:search")
include(":features:root:search")
