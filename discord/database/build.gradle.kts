plugins {
    java
}

val implementation by configurations

dependencies {
    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2") // Serialization
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")

    implementation("io.ktor:ktor:1.6.7")
    implementation("io.ktor:ktor-client-okhttp:1.6.7")
    implementation("io.ktor:ktor-server-netty:1.6.7")
    implementation("io.ktor:ktor-jackson:1.6.7")
    implementation("io.ktor:ktor-client-jackson:1.6.7")

    implementation("org.jetbrains.exposed", "exposed-core", "0.37.3")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.37.3")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.37.3")
    implementation("org.fusesource.jansi:jansi:2.4.0")

}