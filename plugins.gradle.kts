plugins {
    // Plugins that are needed (For the latest Java Version)
    kotlin("jvm") version "1.6.10" apply false
    id("org.jetbrains.kotlinx:kotlinx-coroutines-core") version "1.6.0"
    id("org.jetbrains.kotlin:kotlin-stdlib:1.6.10") version "1.6.0"
    id("io.gitlab.arturbosch.detekt") version "1.19.0"

    // Plugins for the bot itself
    id("com.kotlindiscord.kord.extensions") version "1.5.2-RC1"
    id("org.litote.kmongo") version "4.4.0"

    // Logging
    id("org.apache.logging.log4j") version "2.17.1"

    // Other libs that the bot needs for it to function. 
    id("org.fusesource.jansi") version "2.4.0"

}

val latestVersion = file("version.txt").readLines().first()

configurations.register("compileClasspath")