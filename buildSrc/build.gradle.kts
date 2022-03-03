plugins {
    `kotlin-dsl`
    kotlin("plugin.serialization") version "1.6.10"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}