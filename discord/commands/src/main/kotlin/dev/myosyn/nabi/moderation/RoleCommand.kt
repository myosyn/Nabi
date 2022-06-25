package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.role
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.EmbedBuilder
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock


class RoleCommand : Extension() {
    override val name: String = "GiveRole"

    override suspend fun setup() {
        publicSlashCommand {
            name = "role"
            description = "Category for all of the role commands"

            publicSubCommand(::RoleLookupArguments) {
                name = "lookup" + "search" + "info" + "information"
                description = "Gives you information on the targeted role."

                check {
                    anyGuild()
                }

                action {
                    val target = arguments.targetRole.asRole()

                    respond {
                        embed {

                        }
                    }
                }
            }

            publicSubCommand(::GiveTakeRoleArguments) {
                name = "give" + "grant"
                description = "Gives a role (that is lower than the bot's role) the specified role"

                check {
                    anyGuild()
                    hasPermission(Permission.ManageRoles)
                    requireBotPermissions(Permission.ManageRoles)
                }

                action {
                    val userTarget = guild?.let { arguments.targetUser.asMember(it.id) }
                    val roleTarget = arguments.targetRole.asRole()
                    val reason = arguments.targetReason

                    userTarget?.addRole(roleTarget.id)

                    respond {
                        embed {
                            title = "Role Given"
                            description = "The role, $roleTarget, was given to $userTarget for **$reason**"
                            color = DEFAULT_COLOR
                            timestamp = Clock.System.now()
                        }
                    }
                }
            }

            publicSubCommand(::GiveTakeRoleArguments) {
                name = "take" + "remove" + "revoke"
                description = "Takes a role away from a user"

                check {
                    anyGuild()
                    hasPermission(Permission.ManageRoles)
                    requireBotPermissions(Permission.ManageRoles)
                }

                action {
                    val userTarget = guild?.let { arguments.targetUser.asMember(it.id) }
                    val roleTarget = arguments.targetRole.asRole()
                    val reason = arguments.targetReason

                    userTarget?.removeRole(roleTarget.id)

                    respond {
                        embed {
                            title = "Role removed"
                            description = "The role, $roleTarget was taken away from $userTarget for $reason."
                            color = DEFAULT_COLOR
                            timestamp = Clock.System.now()
                        }
                    }
                }
            }
        }
    }
    inner class RoleLookupArguments: Arguments() {
        val targetRole by role {
            name = "role"
            description = "The role you want to lookup"
        }
    }

    inner class GiveTakeRoleArguments: Arguments() {
        val targetUser by user {
            name = "user"
            description = "The user you want to give the role to."
        }
        val targetRole by role {
            name = "role"
            description = "The role that you want to grant the user."
        }
        val targetReason by defaultingString {
            name = "reason"
            description = "The reason why the user got the role."
            defaultValue = "No reason provided"
        }
    }
}