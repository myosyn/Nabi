package live.shuuyu.nabi.interactions.commands.moderation.declarators

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import live.shuuyu.discordinteraktions.common.commands.slashCommand
import live.shuuyu.nabi.interactions.commands.moderation.SlowmodeExecutor

object SlowmodeDeclarator : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("slowmode", "Slows down the requested channel.") {
        defaultMemberPermissions = Permissions {
            +Permission.ManageChannels
        }
        executor = SlowmodeExecutor()
    }
}