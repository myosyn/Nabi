plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    application
}

subprojects {
    dependencies {
        // Nabi's core libraries

        // TODO: Overwrite Kord-Extension's bundling of Kord somehow, because it is bundling M9 indirectly.
        implementation("dev.kord:kord-core:0.8.0-M12")
        implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-RC1")
        implementation("org.apache.logging.log4j:log4j-core:2.17.2")
    }
}
