plugins {
    `nabi-modules`
}

repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
}

dependencies {
    implementation(project(":discord:common"))

    implementation("io.ktor:ktor-server-core:2.0.1")
    implementation("io.ktor:ktor-server-netty:2.0.1")
    implementation("org.litote.kmongo:kmongo:4.5.1")

    // I need this so I can snowflake stuff yk yk
    implementation("dev.kord:kord-core:0.8.0-M15")
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.3-SNAPSHOT")
}
