package dev.myosyn.nabi

import dev.kord.common.entity.UserFlag


class UserFlags {
    private fun getBadge(flag: UserFlag): String {
        return when (flag) {
            UserFlag.DiscordEmployee -> "<:People_Who_Like_To_Break_The_Discord_API:907322194156224542>"
            UserFlag.DiscordCertifiedModerator -> "<:Discord_Cerified_Moderator:907322144109756426>"
            UserFlag.DiscordPartner -> "<:discord_partner:907322256567447552>"
            UserFlag.BugHunterLevel1 -> "<:bug_hunter_one:907322130151141416>"
            UserFlag.BugHunterLevel2 -> "<:bug_hunter_two:907322205917052978>"
            UserFlag.VerifiedBotDeveloper -> "<:early_verified_developer:907322174329716818>"
            UserFlag.HouseBalance -> "<:balance:907321974211108984>"
            UserFlag.HypeSquad -> "<:hypesquad_v1:907322220056023080>"
            UserFlag.HouseBravery -> "<:house_bravery:907322115454300190>"
            UserFlag.HouseBrilliance -> "<:house_balance:907321974211108984>"
            UserFlag.EarlySupporter -> "<:early_supporter:907322161159626753>"
            else -> "`null`"
        }
    }
}