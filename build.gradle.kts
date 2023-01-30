import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

plugins {
    kotlin("jvm") version "1.8.0" apply false
    kotlin("plugin.serialization") version "1.8.0" apply false
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
}

tasks.wrapper {
    version = "7.6"
    distributionType = ALL
}

allprojects {
    group = "dev.myosyn.nabi"
    version = "1.0.0-PRE1"

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}