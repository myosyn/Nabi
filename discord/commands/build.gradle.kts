plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    application
    java
}

subprojects {
    dependencies{
        implementation("dev.kord:kord-core:0.8.0-M12")
        implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-RC1")
    }
}


