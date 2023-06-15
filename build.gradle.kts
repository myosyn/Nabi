plugins {
    kotlin("jvm") version "1.8.22" apply false
    kotlin("plugin.serialization") version "1.8.22" apply false
    id("org.jetbrains.dokka") version "1.8.20"
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false
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
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    }
}
