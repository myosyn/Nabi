package dev.myosyn.nabi.developer

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.converters.impl.stringChoice
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateBot : Extension() {
    override val name: String = "updatebot"

    override suspend fun setup() {
        publicSlashCommand(::UpdateBotArguments) {
            name = "update"
            description = "Checks to see if there is an update available for the bot"

            check {
                anyGuild()
            }

            action {
                val botUpdateType = arguments.updateType

                CoroutineScope(Dispatchers.IO + CoroutineName("Nabi-UpdateChecker")).launch {
                    val regex = Regex("^(?<version>[\\\\d.]+)-?(?<type>\\\\D+)?(?<typever>\\\\d+\\\\.?\\\\d*)?\\\$")

                }
            }
        }
    }

    inner class UpdateBotArguments : Arguments() {
        val updateType by stringChoice {
            name = "updateType"
            description = "Shows the updates that are available"
            choices = mutableMapOf(

            )
        }
    }
}