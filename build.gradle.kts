import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "Nabi"
version = "0.0.1"

repositories {
    google()
    mavenCentral()

    maven {
        name = "Sonatype Snapshots"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }

    maven {
        name = "Kotlin Discord"
        url = uri("https://maven.kotlindiscord.com/repository/maven-public/")
    }
}

dependencies {
    // Discord API
    implementation("dev.kord:kord-core:0.8.x-SNAPSHOT")
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-RC1")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2") // Serialization
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")

    //idk why I even have these but they're here
    implementation("org.jetbrains.exposed", "exposed-core", "0.37.3")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.37.3")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.37.3")
    implementation("org.fusesource.jansi:jansi:2.4.0")

    // Database so we can isolate each config to their respective server.
    implementation("org.litote.kmongo:kmongo:4.5.0") // The database we use to separate the configs for each server.

    // Logging dependencies
    implementation("org.slf4j:slf4j-simple:1.7.36")

    // I forgot why I even had this
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
}

application {
    // This is deprecated, but the Shadow plugin requires it
    mainClassName = "myosyn.nabi.NabibotKt"
}

tasks.withType<KotlinCompile> {
    // Current LTS version of Java
    kotlinOptions.jvmTarget = "17"

    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "myosyn.nabi.NabibotKt"
        )
    }
}

java {
    // Current LTS version of Java
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

detekt {
    buildUponDefaultConfig = true
    config = rootProject.files("detekt.yml")
}
