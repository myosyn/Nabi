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

// You need this because this is the core of the library
include(":discord")

// These are the submodules of the library which are required in order to make the bot function
include(":discord:commands")
include(":discord:database")
include(":discord:common")
include(":discord:automod")
include(":discord:phishing")
include(":discord:core")
include(":discord:events")

if (JavaVersion.current() < JavaVersion.VERSION_17) {
    throw GradleException("This build requires Java 17 in order to build. You're currently using ${JavaVersion.current()}")
}