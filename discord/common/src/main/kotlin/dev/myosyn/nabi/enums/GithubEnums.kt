package dev.myosyn.nabi.enums

import com.kotlindiscord.kord.extensions.DISCORD_FUCHSIA
import com.kotlindiscord.kord.extensions.DISCORD_GREEN
import com.kotlindiscord.kord.extensions.DISCORD_RED
import com.kotlindiscord.kord.extensions.commands.application.slash.converters.ChoiceEnum
import dev.kord.common.Color

enum class GithubEnums(override val readableName: String, color: Color) : ChoiceEnum {
    OpenPullRequest("OpenPR", DISCORD_GREEN),
    ClosedPullRequests("ClosePR", DISCORD_RED),
    MergedPullRequest("MergedPR", DISCORD_FUCHSIA),

    OpenIssue("OpenIssue", DISCORD_GREEN),
    ClosedIssue("ClosedIssue", DISCORD_RED)
}