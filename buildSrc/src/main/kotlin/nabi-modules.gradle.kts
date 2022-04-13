import org.gradle.kotlin.dsl.application
import org.gradle.kotlin.dsl.dependencies


plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "dev.myosyn.nabi"
version = "1.0.0-PRE1" + "-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
}
