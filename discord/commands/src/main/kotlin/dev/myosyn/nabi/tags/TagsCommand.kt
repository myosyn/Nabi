package dev.myosyn.nabi.tags

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
import dev.myosyn.nabi.embeds.ColorUtils.SUCCESS_COLOR
import kotlinx.datetime.Clock

class TagsCommand : Extension() {
    override val name: String = "TagsCommand"

    override suspend fun setup() {
        publicSlashCommand {
            name = "tags"
            description = ""

            check {
                anyGuild()
                hasPermission(Permission.Administrator)
            }

            publicSubCommand(::CreateTagsArguments) {
                name = "create"
                description = "Creates a tag inside the designated server."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                }

                action {
                    respond {
                        embed {
                            title = "Tag Created"
                            field {
                                name = "**Tag Name**"
                                value = "`${arguments.tagName}`"
                                inline = false
                            }

                            field {
                                name = "**Tag Title**"
                                value = "`${arguments.tagTitle}`"
                                inline = false
                            }

                            field {
                                name = "**Tag Message**"
                                value = "`${arguments.tagMessage}`"
                            }

                            color = SUCCESS_COLOR
                            timestamp = Clock.System.now()
                        }
                    }
                }
            }
            publicSubCommand {
                name = "delete"
                description = "Deletes the specified tag inside the server."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                }

                action {

                }
            }
            publicSubCommand {
                name = "list"
                description = "Shows all of the available tags."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                }

                action {

                }
            }
        }
    }
    inner class CreateTagsArguments : Arguments() {
        val tagName by string {
            name = "tagName"
            description = "The name of the tag"
        }
        val tagTitle by string {
            name = "tagTitle"
            description = "The title of the embeded tag to show."
        }
        val tagMessage by string {
            name = "tagMessage"
            description = "The message you want the embeded tag to show"
        }

    }
    inner class DeleteTagsArguments : Arguments() {

    }
}