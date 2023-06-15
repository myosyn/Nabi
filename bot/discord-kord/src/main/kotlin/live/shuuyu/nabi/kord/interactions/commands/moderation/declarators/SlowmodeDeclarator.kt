package live.shuuyu.nabi.kord.interactions.commands.moderation.declarators

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.moderation.SlowmodeExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import net.perfectdreams.discordinteraktions.common.commands.slashCommand

class SlowmodeDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("slowmode", "Slows down the requested channel.") {
        defaultMemberPermissions = Permissions {
            +Permission.ManageChannels
        }
        executor = SlowmodeExecutor(nabi)
    }
}