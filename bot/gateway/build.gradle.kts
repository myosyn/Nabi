plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(project(":bot:discord-jda"))
    implementation(project(":bot:discord-kord"))
    implementation(libs.dotenv)
}