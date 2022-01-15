@file:OptIn(ExperimentalTime::class)

package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.annotations.ExtensionDSL
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.PublicSlashCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import dev.kord.common.entity.Permission
import kotlin.reflect.KFunction0

@ExtensionDSL
class Kick : Extension() {
    override val name = "kick"

    override suspend fun setup() {
        publicSlashCommand(::Kick) {
            name = "Kick"
            description = "Kicks a specified user from your server"
            check {
                hasPermission(Permission.KickMembers)
                requireBotPermissions(Permission.KickMembers)
            }

            action {

            }
        }
    }

    private fun publicSlashCommand(arguments: KFunction0<Kick>, body: suspend PublicSlashCommand<Kick>.() -> Unit) {
        TODO("Not yet implemented")
    }

    inner class KickArgs : Arguments() {
        val userArguments by user("kickUser", "Person you'd like to kick")
        val reason by defaultingString("reason", "The reason why this person is being kicked")
    }


}