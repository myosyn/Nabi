import org.gradle.kotlin.dsl.application
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import javax.lang.model.SourceVersion
import kotlin.jvm.internal.Intrinsics.Kotlin


plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    application
}

group = "dev.myosyn.nabi"
version = "1.0.0-PRE1"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven("https://maven.kotlindiscord.com/repository/maven-snapshots/")
}

tasks {
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
        }
    }
    "compileJava"(JavaCompile::class) {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}


