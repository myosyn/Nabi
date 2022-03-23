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
    }

    dependencies {
        api(kotlin("stdlib"))
    }

    tasks.withType<KotlinCompile> {
        KotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = freeCompilerArgs + arrayOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }
}