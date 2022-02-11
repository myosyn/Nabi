pluginManagement {
    repositories {
        maven("https://repo.perfectdreams.net/")
        gradlePluginPortal()
    }
}

rootProject.name = "Nabi"

// The Discord bot's services
include(":discord:api")
include(":discord:commands")
include(":discord:discord-common")