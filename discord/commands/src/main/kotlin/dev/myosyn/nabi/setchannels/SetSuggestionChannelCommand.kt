package dev.myosyn.nabi.setchannels

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.core.entity.channel.TextChannel

class SetSuggestionChannelCommand : Extension() {
    override val name: String = "SetSuggestionChannel"

    override suspend fun setup() {
        publicSlashCommand(::SetSuggestionChannelArguments) {
            name = "suggestion"
            description = "The subcategory of suggesting stuff."

            check {
                anyGuild()
                hasPermission(Permission.Administrator)
            }

            publicSubCommand(::SetSuggestionChannelArguments) {
                name = "set"
                description = "Sets the channel where suggestions will be redirected to."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                }

                action {
                    val target = arguments.suggestionChannel ?: this.channel.asChannel() as TextChannel


                }
            }

            publicSubCommand {
                name = "reset"
                description = "Removes the channel set for where suggestions will be directed to."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                }

                action {

                }
            }
        }
    }
    inner class SetSuggestionChannelArguments : Arguments() {
        val suggestionChannel by optionalChannel {
            name = "channel"
            description = "The channel you want to direct all of the suggestions to."
        }
    }
}