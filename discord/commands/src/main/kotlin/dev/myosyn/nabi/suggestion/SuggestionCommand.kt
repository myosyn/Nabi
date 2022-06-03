package dev.myosyn.nabi.suggestion

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class SuggestionCommand : Extension() {
    override val name: String = "Suggestions"

    // TODO: Make it so everything has the proper permissions.
    override suspend fun setup() {
        publicSlashCommand {
            name = "suggestion"
            description = "Make some stupid suggestion with this command (Because people only make stupid useless suggestions)"

            action {

            }

            publicSubCommand(::SuggestionArguments) {
                name = "accept"
                description = "Wow, a good suggestion! Finally, for god sakes."

                check {
                    anyGuild()
                    hasPermission(Permission.ModerateMembers)
                }
            }

            publicSubCommand(::SuggestionArguments) {
                name = "deny"
                description = "Denies a suggestion because it was terrible and you hated it."

                check {
                    anyGuild()
                    hasPermission(Permission.ModerateMembers)
                }

                action {

                }
            }
        }
    }

    inner class SuggestionLookupArguments: Arguments() {
        val suggestionId by string {
            name = "id"
            description = "The suggestion that you want to look up."
        }
    }

    inner class SuggestionArguments : Arguments() {
        val id by string {
            name = "id"
            description = "The suggestion that you want"
        }
    }
}