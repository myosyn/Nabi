plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")

    id("com.github.johnrengelman.shadow")
}

group = "xyz.myosyn.nabi"
version = "0.0.1"

repositories {
    mavenLocal()
    google()
    maven("https://maven.kotlindiscord.com/repository/maven-snapshots/")
    maven("https://maven.kotlindiscord.com/repository/maven-public")
    maven("https://jitpack.io")
}

