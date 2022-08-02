package dev.myosyn.nabi.suggestion

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class SuggestionCommand : Extension() {
    override val name: String = "Suggestions"

    // TODO: Make it so everything has the proper permissions.
    override suspend fun setup() {
        publicSlashCommand {
            name = "suggestion"
            description = "Make some stupid suggestion with this command (Because people only make stupid useless suggestions)"

            publicSubCommand(::SuggestionArguments) {
                name = "accept" + "approve"
                description = "Wow, a good suggestion! Barely anyone can make a good suggestion, so that's wild."

                check {
                    anyGuild()
                    hasPermission(Permission.ModerateMembers)
                }

                action {

                }
            }

            publicSubCommand(::SuggestionArguments) {
                name = "deny"
                description = "99% of suggestions will need to use this command"

                check {
                    anyGuild()
                    hasPermission(Permission.ModerateMembers)
                }

                action {

                }
            }

            publicSubCommand(::SuggestionLookupArguments) {
                name = "lookup" + "info" + "information" + "search"
                description = "Looks up a suggestion."

                check {
                    anyGuild()
                }

                action {
                    val id = arguments.suggestionId

                    respond {
                        embed {
                            timestamp = Clock.System.now()
                        }
                    }
                }
            }

            publicSubCommand(::SuggestionCommentArguments) {
                name = "comment"
                description = "Leaves a comment under the suggestion."

                check {
                    anyGuild()
                    hasPermission(Permission.ModerateMembers)
                }

                action {
                    val targetSuggestion = arguments.suggestionId
                    val suggestionComment = arguments.comment

                    respond {
                        embed {
                            timestamp = Clock.System.now()
                        }
                    }
                }
            }
        }
    }

    inner class SuggestionCommentArguments: Arguments() {
        val suggestionId by string {
            name = "id"
            description = "The suggestion's id (which you are going to comment on)"
        }
        val comment by string {
            name = "comment"
            description = "The comment you have on the suggestion."
        }
    }

    inner class SuggestionLookupArguments: Arguments() {
        val suggestionId by string {
            name = "id"
            description = "The suggestion that you want to look up."
        }
    }

    inner class SuggestionArguments: Arguments() {
        val id by string {
            name = "id"
            description = "The suggestion that you want"
        }
    }
}