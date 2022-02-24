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
    plugins {
        // Update this in libs.version.toml when you change it here
        kotlin("jvm") version "1.6.10"
        kotlin("plugin.serialization") version "1.3.2"

        // Update this in libs.version.toml when you change it here
        id("io.gitlab.arturbosch.detekt") version "1.19.0"

        id("com.github.johnrengelman.shadow") version "7.1.2"
    }
}

rootProject.buildFileName = "plugins.gradle.kts"

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}