plugins {
    `nabi-modules`
}

dependencies {
    implementation(project(":discord:commands"))
    implementation(project(":discord:database"))
    implementation(project(":discord:events"))
    implementation(project(":discord:common"))
    implementation(project(":discord:phishing"))

    implementation(libs.bundles.kotlinLibs.bundle)
    implementation(libs.bundles.ktor.bundle)
    implementation(libs.bundles.kordLibs.bundle)

    // Used for Logback
    implementation("org.codehaus.groovy:groovy:3.0.12")
    implementation("ch.qos.logback:logback-classic:1.4.0")
}