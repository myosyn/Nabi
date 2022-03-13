plugins {
    kotlin("multiplatform") apply false
    kotlin("plugin.serialization") apply false
    kotlin("jvm") apply false
    java
}

sourceSets {
    repositories {
        maven(url = uri("https://maven.kotlindiscord.com/repository/maven-public/"))
        maven(url = uri("https://jitpack.io"))
        maven(url = uri("https://oss.sonatype.org/content/repositories/snapshots"))
    }

    dependencies {
        implementation("dev.kord:kord-core:0.8.x-SNAPSHOT")
        implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-RC1")

        implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2") // Serialization
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    }
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "xyz.myosyn.commands.NabiBotKt"
        )
    }
}