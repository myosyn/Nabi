package dev.myosyn.nabi

import kotlin.time.Duration

object DurationAttributes {
    fun Duration.formatElapsed() {
        val seconds = inWholeSeconds % 60
        val minutes = inWholeMinutes % 60
        val hours = inWholeHours % 24
        val days = inWholeDays % 365

        return when {
            else -> throw Exception("Could not determine the ")
        }
    }
}