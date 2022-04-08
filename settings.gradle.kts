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
    resolutionStrategy {
        eachPlugin{
            if (requested.id.id == "org.jetbrains.dokka") {
                useModule("org.jetbrains.dokka:dokka-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "Nabi"

// Generalization of the paths idk I just need this so it would work

include(":discord")
include(":discord:commands")
include(":discord:database")

gradle.settingsEvaluated{
    // We have to use Java 11 for this because apparently I can't make it default to Java 18
    if(!JavaVersion.current().isJava11Compatible) {
        throw GradleException("This build requires JDK 18. You're currently using ${getBuildJavaHome()}. Please make sure you're on this version, and try again.")
    }
}

fun getBuildJavaHome(){
    System.getProperty("java.home")
}