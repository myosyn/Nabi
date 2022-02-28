// Update the dependencies in the Plugins.kt file, not here. We have all of the dependencies inside there.

plugins {
    kotlin("jvm") version Plugins.KOTLIN apply false
    kotlin("plugin.serialization") version Plugins.KOTLIN apply false
    kotlin("multiplatform") version Plugins.KOTLIN apply false

    id("io.gitlab.arturbosch.detekt") version Plugins.DETEKT apply false
    id("com.github.johnrengelman.shadow") version Plugins.SHADOWJAR apply false
}

