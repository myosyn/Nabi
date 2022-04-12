plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    kotlin("multiplatform")
    application
}

subprojects {
    dependencies {
        api("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-20220318.133517-36")
        api("dev.kord:kord-core:0.8.0-M12")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.20")
    }
}