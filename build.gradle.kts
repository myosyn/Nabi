plugins {
    `nabi-modules`
    `maven-publish`
    java
}


repositories {
    mavenCentral()
    mavenLocal()
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

allprojects {
    group = "dev.myosyn.nabi"
    version = "1.0.0-PRE1"

    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}