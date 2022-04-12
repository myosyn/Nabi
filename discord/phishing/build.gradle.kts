plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    kotlin("multiplatform")
    id("com.github.johnrengelman.shadow")
    application
}

kotlin {
    subprojects {
        dependencies {
            
        }
    }
}