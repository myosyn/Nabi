plugins {
    java
}

val implementation by configurations

dependencies {
    // Discord API
    implementation("dev.kord:kord-core:0.8.x-SNAPSHOT")
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-RC1")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2") // Serialization
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
}

repositories {
    mavenCentral()
}