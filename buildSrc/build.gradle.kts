plugins {
    groovy
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.17.2")
    implementation("com.google.devtools.ksp", "com.google.devtools.ksp.gradle.plugin", "1.6.21-1.0.5")

    implementation(kotlin("gradle-plugin", version = "1.6.21"))
    implementation(kotlin("serialization", version = "1.6.21"))

    implementation(gradleApi())
    implementation(localGroovy())
}