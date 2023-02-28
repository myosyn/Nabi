plugins {
    kotlin("jvm") version "1.7.21" apply false
    kotlin("plugin.serialization") version "1.7.21" apply false
    id("org.jetbrains.dokka") version "1.7.20"
    id("com.github.johnrengelman.shadow") version "8.1.0" apply false
    application
    java
}

allprojects {
    group = "live.shuuyu"

    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}
