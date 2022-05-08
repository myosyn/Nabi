package dev.myosyn.nabi

import dev.kord.common.entity.UserFlag


class DiscordBadges {
    public fun getBadge(flag: UserFlag): String {
        return when (flag) {
            UserFlag.DiscordEmployee -> "<:People_Who_Like_To_Break_The_Discord_API:>"
            UserFlag.DiscordCertifiedModerator -> "<:Discord_Cerified_Moderator:907322144109756426>"
            UserFlag.DiscordPartner -> ""
            UserFlag.BugHunterLevel1 -> ""
            UserFlag.BugHunterLevel2 -> ""
            UserFlag.HouseBalance -> ""
            UserFlag.HypeSquad -> "<:hypesquad_v1:907322220056023080>"
            UserFlag.HouseBravery -> "<:house_bravery:907322115454300190>"
            UserFlag.HouseBrilliance -> "<:house_balance:907321974211108984>"
            UserFlag.EarlySupporter -> "<:early_supporter:907322161159626753>"
            UserFlag.BotHttpInteractions -> "<:>"
            UserFlag.System -> ""
            else -> "`null`"
        }
    }
}