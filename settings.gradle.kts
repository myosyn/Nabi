pluginManagement {
    plugins {
        kotlin("jvm") version "1.6.10"
        kotlin("plugin.serialization") version "1.6.10"

        // Update this in libs.version.toml when you change it here
        id("io.gitlab.arturbosch.detekt") version "1.19.0"

        id("com.github.jakemarsden.git-hooks") version "0.0.1"
        id("com.github.johnrengelman.shadow") version "7.1.2"
    }
}

rootProject.name = "Nabi"

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}