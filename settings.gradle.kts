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

// We use this because we're too lazy to write it 15 times for all of the files
rootProject.buildFileName = "plugins.gradle.kts"

include(":discord:commands")
include(":discord:database")
include(":discord:moderation")

// Generalization of the paths idk I just need this so it would work
include(":discord")
include(":common")