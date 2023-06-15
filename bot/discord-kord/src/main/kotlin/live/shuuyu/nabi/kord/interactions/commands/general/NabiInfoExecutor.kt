package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.common.annotation.KordExperimental
import dev.kord.common.annotation.KordUnsafe
import dev.kord.rest.route.Route
import kotlinx.datetime.Clock
import live.shuuyu.nabi.common.Constants
import live.shuuyu.nabi.kord.NabiKordCore
import net.perfectdreams.discordinteraktions.common.builder.message.actionRow
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments
import java.lang.management.ManagementFactory

class NabiInfoExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {

    @OptIn(KordUnsafe::class, KordExperimental::class)
    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val runtime = Runtime.getRuntime()
        val threads = ManagementFactory.getThreadMXBean()
        val gateway = nabi.rest.unsafe(Route.GatewayBotGet) {}

        context.sendMessage {
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
                timestamp = Clock.System.now()
            }
            actionRow {
                linkButton(Constants.SOURCE_REPO) {
                    label = "Source Code"
                }
                // linkButton() {} This was supposed to be for the Discord Server.
            }
        }
    }

    private fun Long.formatMemory(): String {
        val kb = this / 1024L
        val mb = kb / 1024L
        val gb = mb / 1024L

        return when {
            kb < 1024 -> "${kb}KB"
            mb < 1024 -> "${mb}MB"
            else -> "${gb}GB"
        }
    }
}