package live.shuuyu.nabi.kord.interactions.commands.moderation.declarators

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import live.shuuyu.discordinteraktions.common.commands.slashCommand
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.moderation.KickExecutor

class KickDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("kick", "Kicks a user from the current guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.KickMembers
        }
        executor = KickExecutor(nabi)
    }
}