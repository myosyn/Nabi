import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
}

dependencies {
    implementation(libs.kordex)
    implementation(libs.logback)
    implementation(libs.bundles.database)
}

tasks {
    // You need this or else Kord-Ex throws an exception for being on 1.8
    "compileJava"(JavaCompile::class) {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = sourceCompatibility
    }

    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}