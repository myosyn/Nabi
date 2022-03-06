
  
plugins {
    application
}

group = "xyz.myosyn"
version = "0.0.1"

repositories {
    mavenCentral()
    mavenLocal()
}

detekt {
    buildUponDefaultConfig = true
    config = rootProject.files("detekt.yml")
}

application {
    // This is deprecated, but the Shadow plugin requires it
    mainClassName = "myosyn.nabi.NabibotKt"
}

allprojects {
    val splittedPath = this.path.split(":")

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