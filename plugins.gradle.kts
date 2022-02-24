plugins {
    // Plugins that are needed (For the latest Java Version)
    kotlin("jvm") version "1.6.10" apply false
    kotlin("plugins.serialization") version "1.3.2" apply false
    id("io.gitlab.arturbosch.detekt") version "1.19.0" apply false
    id("org.codehaus.groovy") version "3.0.8" apply false

    // Plugins for the bot itself
    id("com.kotlindiscord.kord.extensions") version "1.5.2-RC1"
    id("org.litote.kmongo") version "4.4.0"

    // Logging
    id("org.apache.logging.log4j") version "2.17.1"

}

val latestVersion = file("version.txt").readLines().first()

configurations.register("compileClasspath")