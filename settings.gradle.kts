pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
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

include(
    ":bot:discord-kord",
    ":bot:discord-jda",
    ":bot:gateway",
    ":bot:common",
    ":commons:locales"
)