package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.core.entity.User
import kotlinx.datetime.Clock
import live.shuuyu.discordinteraktions.common.builder.message.actionRow
import live.shuuyu.discordinteraktions.common.builder.message.embed
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import live.shuuyu.nabi.kord.NabiKordCore

class UserExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = optionalUser("user", "The user you want to look up.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user] ?: context.sender
        val userAvatar = User.Avatar(target.data, nabi.kord).url


        context.sendMessage {
            embed {
                title = target.username
                image = userAvatar
                field {
                    name = "**» User Information**"
                    value = "**Mention:** ${target.mention} \n" +
                            "**ID:** ${target.id}"
                }
                field {
                    name = "**» Member Information**"
                }
                timestamp = Clock.System.now()
            }
            actionRow {
                linkButton(userAvatar) {
                    label = "${target.username}'s Avatar"
                }
            }
        }
    }

    private fun userFlags() {

    }
}