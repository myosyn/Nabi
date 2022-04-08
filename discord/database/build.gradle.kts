plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

subprojects {
    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
        implementation("org.litote.kmongo:kmongo:4.5.1")
    }
}