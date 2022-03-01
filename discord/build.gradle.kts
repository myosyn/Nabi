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

    implementation("org.slf4j:slf4j-simple:1.7.32")

    // I forgot why I even had this
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
}


tasks.withType<KotlinCompile> {
    // Current LTS version of Java
    kotlinOptions.jvmTarget = "17"

    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

java {
    // Current LTS version of Java
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
