plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(libs.kord.core)
    implementation(libs.kord.rest)
}