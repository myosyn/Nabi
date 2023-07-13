package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.common.annotation.KordExperimental
import dev.kord.common.annotation.KordUnsafe
import dev.kord.rest.route.Route
import kotlinx.datetime.Clock
import live.shuuyu.nabi.common.Constants
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import live.shuuyu.nabi.kord.utils.ColorUtils
import live.shuuyu.nabi.kord.utils.formatMemory
import net.perfectdreams.discordinteraktions.common.builder.message.actionRow
import net.perfectdreams.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments
import java.lang.management.ManagementFactory

@OptIn(KordUnsafe::class, KordExperimental::class)
class NabiInfoExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        context.sendMessage {
            createNabiInfoEmbed()
        }
    }

    private suspend fun InteractionOrFollowupMessageCreateBuilder.createNabiInfoEmbed() {
        val runtime = Runtime.getRuntime()
        val threads = ManagementFactory.getThreadMXBean()
        val gateway = nabi.rest.unsafe(Route.GatewayBotGet) {}

        embed {
            title = "Nabi's Information"
            field {
                name = "**» Environment Information**"
                value = "**Memory Usage:** ${runtime.freeMemory().formatMemory()}/${
                    runtime.totalMemory().formatMemory()
                } [${runtime.maxMemory().formatMemory()}] \n" +
                        "**Thread Count:** ${threads.threadCount} \n" +
                        "**Operating System:** ${System.getProperty("os.name")} \n" +
                        "**Kotlin Version:** ${KotlinVersion.CURRENT} \n" +
                        "**Java Version:** ${System.getProperty("java.version")} \n" +
                        "**Java Distributor:** ${System.getProperty("java.vendor")}"
            }
            field {
                name = "**» Sharding Information**"
                value = "**Shard Instances:** ${gateway.shards} \n" +
                        "**Shard Limit:** ${gateway.sessionStartLimit.remaining} / ${gateway.sessionStartLimit.total}"
            }
            color = ColorUtils.DEFAULT_COLOR
            timestamp = Clock.System.now()
        }
        actionRow {
            linkButton(Constants.SOURCE_REPO) {
                label = "Source Code"
            }
        }
    }
}