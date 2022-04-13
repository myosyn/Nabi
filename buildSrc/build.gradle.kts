plugins {
    groovy
    `kotlin-dsl`
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
}

repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.17.1")
    implementation("com.google.devtools.ksp", "com.google.devtools.ksp.gradle.plugin", "1.6.20-1.0.4")
    implementation(gradleApi())
}