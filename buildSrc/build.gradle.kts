import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    groovy
    `kotlin-dsl`
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

repositories {
    google()
    gradlePluginPortal()
}

dependencies {
    implementation("com.google.devtools.ksp", "com.google.devtools.ksp.gradle.plugin", "1.7.10-1.0.6")

    implementation(kotlin("gradle-plugin"))
    implementation(kotlin("serialization"))
    implementation("org.jetbrains.kotlinx", "atomicfu-gradle-plugin", "0.18.2")
    implementation(gradleApi())
    implementation(localGroovy())
}

tasks.withType<KotlinCompile> {
    kotlinOptions.languageVersion = "1.5"
}