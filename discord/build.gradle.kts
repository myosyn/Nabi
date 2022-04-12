plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    kotlin("multiplatform")
    id("com.github.johnrengelman.shadow")
    application
}

subprojects {
    dependencies {
        // Nabi's core libraries
        implementation(project(":discord:commands"))
        implementation(project(":discord:database"))
        implementation(project(":discord:common"))
        implementation(project(":discord:phishing"))

        // TODO: Overwrite Kord-Extension's bundling of Kord somehow, because it is bundling M9 indirectly. I don't think this can be done though
        // See:
        implementation("dev.kord:kord-core:0.8.0-M12")
        implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-20220318.133517-36")
        implementation("org.apache.logging.log4j:log4j-core:2.17.2")
    }
}
