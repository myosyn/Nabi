package dev.myosyn.nabi.enums

import com.kotlindiscord.kord.extensions.DISCORD_FUCHSIA
import com.kotlindiscord.kord.extensions.DISCORD_GREEN
import com.kotlindiscord.kord.extensions.DISCORD_RED
import com.kotlindiscord.kord.extensions.commands.application.slash.converters.ChoiceEnum
import dev.kord.common.Color

enum class SuggestionEnums(override val readableName: String, val color: Color) : ChoiceEnum {
    Denied("Denied", DISCORD_RED),
    Accepted("Accepted", DISCORD_GREEN),

    Implemented("Implemented", DISCORD_FUCHSIA)
}