import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
}

dependencies {
    implementation(libs.bundles.kord)
    implementation(libs.bundles.database)
}

tasks {
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
        }
    }

    "compileJava"(JavaCompile::class) {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = sourceCompatibility
    }
}