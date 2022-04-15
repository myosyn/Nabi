import org.gradle.kotlin.dsl.application
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import javax.lang.model.SourceVersion
import kotlin.jvm.internal.Intrinsics.Kotlin


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

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}
