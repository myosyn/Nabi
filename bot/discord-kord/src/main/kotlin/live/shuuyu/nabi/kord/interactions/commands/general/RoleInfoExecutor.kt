package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.toMessageFormat
import dev.kord.core.entity.Role
import dev.kord.rest.Image
import kotlinx.coroutines.flow.count
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class RoleInfoExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val role = role("role", "The role you want to gather information from.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val role = args[options.role]

        context.sendMessage {
            createRoleInformationEmbed(role)
        }
    }

    private suspend fun InteractionOrFollowupMessageCreateBuilder.createRoleInformationEmbed(role: Role) {
        embed {
            title = role.name
            field {
                name = "**» General Information**"
                value = "**Mention:** ${role.mention} \n" +
                        "**ID:** ${role.id} \n" +
                        "**Creation Date**: ${role.id.timestamp.toMessageFormat(DiscordTimestampStyle.ShortDate)} \n" +
                        "**RGB:** ${role.color.red}, ${role.color.green}, ${role.color.blue} \n" +
                        "**User Count:** ${role.guild.roles.count()}"
            }

            field {
                name = "**» Role Permissions**"
                value = role.permissions.copy {  }.toString()
            }
            color = role.color
            timestamp = Clock.System.now()
        }
    }
}