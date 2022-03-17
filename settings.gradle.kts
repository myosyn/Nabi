enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

includeBuild("build-logic")

// We use this because we're too lazy to write it 15 times for all of the files

rootProject.name = "Nabi"
rootProject.buildFileName = "plugins.gradle.kts"

// Generalization of the paths idk I just need this so it would work

include(":discord")
include(":common")


include(":discord:commands")
include(":discord:database")
include(":discord:moderation")
