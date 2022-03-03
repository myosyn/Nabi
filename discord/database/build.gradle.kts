plugins {
    java
}

val implementation by configurations

repositories {
    mavenLocal()
}

subprojects {
    dependencies {
        implementation("org.jetbrains.exposed", "exposed-core", "0.37.3")
        implementation("org.jetbrains.exposed", "exposed-dao", "0.37.3")
        implementation("org.jetbrains.exposed", "exposed-jdbc", "0.37.3")
    }
}