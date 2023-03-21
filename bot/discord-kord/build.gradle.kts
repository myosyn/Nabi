plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    api(project(":bot:discordinteraktions"))

    api(libs.kord.common)
    api(libs.kord.rest)
    api(libs.kord.core)
    implementation(libs.logback)
    implementation(libs.dotenv)
    implementation(libs.bundles.database)
    implementation(libs.prometheus)
}