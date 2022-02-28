pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        flatDir{
            dirs=setOf(file("../../libs"))
        }
    }
}

rootProject.buildFileName = "plugins.gradle.kts"

enableFeaturePreview("VERSION_CATALOGS")

include(":discord:commands")
include(":discord:database")
include(":discord:moderation")

// Generalization of the paths idk I just need this so it would work
include(":discord")