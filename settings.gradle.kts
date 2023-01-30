@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}

rootProject.name = "Nabi"

include(
    ":discord"
)

if (JavaVersion.current() < JavaVersion.VERSION_17) {
    throw GradleException("This build requires Java 17 in order to build. You're currently using ${JavaVersion.current()}")
}