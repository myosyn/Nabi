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
    implementation("com.google.devtools.ksp", "com.google.devtools.ksp.gradle.plugin", "1.8.10-1.0.9")

    implementation(kotlin("gradle-plugin", version = "1.6.21"))
    implementation(kotlin("serialization", version = "1.6.21"))

    implementation(gradleApi())
    implementation(localGroovy())
}