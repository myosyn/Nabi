plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    api(project(":bot:common"))

    api(libs.kord.common)
    api(libs.kord.rest)
    api(libs.kord.core)
    api(libs.interactions)
    implementation(libs.logback)
    implementation(libs.dotenv)
    implementation(libs.bundles.database)
    implementation(libs.prometheus)
}