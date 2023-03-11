plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(project(":bot:valement"))

    implementation(libs.kord.common)
    implementation(libs.kord.rest)
    implementation(libs.bundles.database)
    implementation(libs.prometheus)
}