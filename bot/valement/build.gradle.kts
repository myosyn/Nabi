plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(libs.kord.rest)
    implementation(libs.kord.core)
}