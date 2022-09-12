plugins {
    `nabi-modules`
}

dependencies {
    implementation(project(":discord:common"))
    implementation(project(":discord:database"))

    implementation(libs.bundles.kotlinLibs.bundle)
    implementation(libs.bundles.ktor.bundle)
    implementation(libs.bundles.kordLibs.bundle)
}
