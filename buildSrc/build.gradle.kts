plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
    implementation(kotlin("gradle-plugin", version = "1.6.10"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

}