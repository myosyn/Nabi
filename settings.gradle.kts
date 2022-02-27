pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        jcenter()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        flatDir{
            dirs=setOf(file("../../libs"))
        }
    }
}

rootProject.buildFileName = "plugins.gradle.kts"

enableFeaturePreview("VERSION_CATALOGS")