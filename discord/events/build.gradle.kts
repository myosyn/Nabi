plugins {
    `nabi-modules`
}

dependencies {
    implementation(project(":discord:database"))

    implementation("dev.kord:kord-core:0.8.0-M17")
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.3-SNAPSHOT")
}