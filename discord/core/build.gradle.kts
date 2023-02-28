plugins {
    `nabi-modules`
}

dependencies {
    implementation(project(":discord:commands"))
    implementation(project(":discord:database"))
    implementation(project(":discord:phishing"))
    implementation(project(":discord:events"))
    implementation(project(":discord:common"))

    implementation("dev.kord:kord-core:0.8.x-SNAPSHOT")
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.3-SNAPSHOT")

    // Used for Logback
    implementation("org.codehaus.groovy:groovy:3.0.15")
    implementation("ch.qos.logback:logback-classic:1.4.1")
}