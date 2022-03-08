plugins {
    kotlin("jvm") apply false
    java
}

repositories {
    mavenCentral()
    mavenLocal()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        google()
        mavenCentral()

        maven ("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
        maven("https://maven.kotlindiscord.com/repository/maven-releases/")
    }

    dependencies {
        implementation("dev.kord:kord-core:0.8.x-SNAPSHOT")
        implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-RC1")

        implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2") // Serialization
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    }
}