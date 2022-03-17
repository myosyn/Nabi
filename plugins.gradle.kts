// Update the dependencies in the Plugins.kt file, not here. We have all of the dependencies inside there.

plugins {
    kotlin("jvm") version "1.6.10" apply false
    kotlin("plugin.serialization") version "1.6.10" apply false
    kotlin("multiplatform") version "1.6.10" apply false

    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
}

