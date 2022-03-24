enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://jitpack.io")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}

// We use this because we're too lazy to write it 15 times for all of the files

rootProject.name = "Nabi"
rootProject.buildFileName = "plugins.gradle.kts"

// Generalization of the paths idk I just need this so it would work

include(":discord")
include(":common")


include(":discord:commands")
include(":discord:database")
include(":discord:moderation")

gradle.settingsEvaluated{
    // We have to use Java 11 for this because apparently I can't make it default to Java 17
    if(!JavaVersion.current().isJava11Compatible) {
        throw GradleException("This build requires JDK 17. You're currently using ${getBuildJavaHome()}. Please make sure you're on this version, and try again.")
    }
}

fun getBuildJavaHome(){
    System.getProperty("java.home")
}
