plugins {
    application
}

group = "xyz.myosyn"
version = "0.0.1"

repositories {
    mavenCentral()
    mavenLocal()
}

application {
    // This is deprecated, but the Shadow plugin requires it
    mainClassName = "myosyn.nabi.NabibotKt"
}

allprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
        mavenLocal()
        google()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
        maven("https://jitpack.io")
    }

    applications {
        mainClassName = "xyz.myosyn.nabi.NabiBotKt"
    }
}