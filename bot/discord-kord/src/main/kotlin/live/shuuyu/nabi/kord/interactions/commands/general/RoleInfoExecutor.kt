package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.toMessageFormat
import dev.kord.rest.Image
import kotlinx.coroutines.flow.count
import kotlinx.datetime.Clock
import live.shuuyu.discordinteraktions.common.builder.message.embed
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments

class RoleInfoExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val role = role("role", "The role you want to gather information from.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val role = args[options.role]

        val iconUrl = role.icon?.cdnUrl?.toUrl {
            this.size = Image.Size.Size2048
        }

        context.sendMessage {
            embed {
                title = role.name
                field {
                    name = "**» Role Information**"
                    value = "**Mention:** ${role.mention} \n" +
                            "**ID:** ${role.id} \n" +
                            "**Creation Date**: ${role.id.timestamp.toMessageFormat(DiscordTimestampStyle.ShortDate)} \n" +
                            "**RGB:** ${role.color.red}, ${role.color.green}, ${role.color.blue} \n" +
                            "**User Count:** ${role.guild.roles.count()}"
                }
                field {
                    name = "**» Role Permissions**"
                    value = "**Role Permissions Count:** ${role.permissions.values.count()}"
                }
                color = role.color
                timestamp = Clock.System.now()
            }
        }
    }
}