plugins {
    groovy
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
}

dependencies {

    implementation(kotlin("gradle-plugin"))
    implementation("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.17.2")
    implementation("com.google.devtools.ksp", "com.google.devtools.ksp.gradle.plugin", "1.6.20-1.0.4")

    implementation(kotlin("gradle-plugin", version = "1.6.20"))
    implementation(kotlin("serialization", version = "1.6.20"))

    implementation(gradleApi())
    implementation(localGroovy())
}