plugins {
    `nabi-modules`
    // kotlin("jvm") version "1.6.20"
    // kotlin("plugin.serialization") version "1.6.20"
    // id("com.github.johnrengelman.shadow") version "7.1.2"
    `maven-publish`
    application
    java
}


repositories {
    mavenCentral()
    mavenLocal()
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

allprojects {
    group = "dev.myosyn.nabi"
    version = "1.0.0-PRE1" + "-SNAPSHOT"

    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}

// TODO: Add publication to the project as a whole

