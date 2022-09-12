plugins {
    `nabi-modules`
}

repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
}

dependencies {
    implementation(project(":discord:common"))

    implementation(libs.bundles.kotlinLibs.bundle)
    implementation(libs.bundles.ktor.bundle)
    implementation(libs.bundles.kordLibs.bundle)

    // Mongo apparently gets rejected because of Discord's hatred of it so I had to go prostgres
    implementation("org.postgresql:postgresql:42.5.0")

    implementation("org.jetbrains.exposed:exposed-core:0.39.2")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:0.39.2")
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:0.39.2")
}
