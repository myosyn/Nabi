pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}

rootProject.name = "Nabi"

// Generalization of the paths idk I just need this so it would work

// You need this because this is the core of the library
include(":discord")

// These are the submodules of the library which are required in order to make the bot function
include(":discord:commands")
include(":discord:database")
include(":discord:common")
include(":discord:phishing")

gradle.settingsEvaluated{
    // We have to use Java 12 for this because apparently I can't make it default to Java 18
    if(!JavaVersion.current().isJava11Compatible) {
        throw GradleException("This build requires JDK 17. You're currently using ${getBuildJavaHome()}. Please make sure you're on this version, and try again.")
    }
}

fun getBuildJavaHome(){
    System.getProperty("java.home")
}