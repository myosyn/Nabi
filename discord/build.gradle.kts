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