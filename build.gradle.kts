import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20" apply false
    kotlin("plugin.serialization") version "1.6.20" apply false
    kotlin("multiplatform") version "1.6.20" apply false
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
    `maven-publish`
    application
    java
}

allprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.serialization")
        plugin("com.github.johnrengelman.shadow")
        plugin("application")
        plugin("java")
    }

    group = "dev.myosyn.nabi"
    version = "1.0.0-PRE1" + "SNAPSHOT"

    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "17"
                javaParameters = true
                freeCompilerArgs =
                    listOf(
                        "-opt-in=kotlin.RequiresOptIn",
                        "kotlin.ExperimentalStdlibApi",
                        "kotlin.time.ExperimentalTime"
                    )
            }
        }
    }

    application {
        mainClass.set("dev.myosyn.nabi.NabiCoreKt")
        java {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}
