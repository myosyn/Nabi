package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.ephemeralSubCommand
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.role
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.utils.canInteract
import com.kotlindiscord.kord.extensions.utils.selfMember
import com.kotlindiscord.kord.extensions.utils.users
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.SUCCESS_COLOR
import kotlinx.datetime.Clock


class GrantRoleCommand : Extension() {
    override val name: String = "GiveRole"

    override suspend fun setup() {
        publicSlashCommand {
            name = "grantrole"
            description = "Grants the user with the provided role."

            publicSubCommand(::GiveRoleArguments) {
                name = "public"
                description = "Publically grants the user with the provided role."

                check {
                    anyGuild()
                    hasPermission(Permission.ManageRoles)
                    requireBotPermissions(Permission.ManageRoles)
                }

                action {
                    val publicMember = arguments.providedUser


                }
            }
            ephemeralSubCommand(::GiveRoleArguments) {
                name = "ephemeral"
                description = "Ephemerally grants the user with the provided role."

                check {
                    anyGuild()
                    hasPermission(Permission.ManageRoles)
                    requireBotPermissions(Permission.ManageRoles)
                }

                action {
                    val member = arguments.providedUser
                    val role = arguments.providedRole
                    val reason = arguments.grantRoleReason



                    respond {
                        embed {
                            color = SUCCESS_COLOR
                            title = "Role taken"
                            description = "The role, $role, was taken away from $member for **$reason.**"
                            timestamp = Clock.System.now()
                        }
                    }
                }
            }
        }
    }
    inner class GiveRoleArguments : Arguments() {
        val providedUser by user {
            name = "user"
            description = "The user you want to give the role to."
            validate {

            }
        }
        val providedRole by role {
            name = "role"
            description = "The role that you want to grant the user."
        }
        val grantRoleReason by defaultingString {
            name = "reason"
            description = "The reason why the user got the role."
            defaultValue = "No reason provided"
        }
    }
}