/*
~~Stolen~~ Taken and modified (I forgot from where, but I owe them credit for it, please let me know!)
I think it was Moire but that person scares me a bit (This is a joke)
 */

package dev.myosyn.nabi.developer

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.Snowflake
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.BOT_OWNER
import dev.myosyn.nabi.ColorUtils.SUCCESS_COLOR

@KordPreview
class EvalCommand : Extension() {
    override val name: String = "eval"

    override suspend fun setup() {
        publicSlashCommand(::EvalArguments) {
            name = "Eval"
            description = "Executes a command from Nabi herself."

            check {
                allowUser(Snowflake(BOT_OWNER))
                anyGuild()
            }

            action {
            }
        }
    }

    inner class EvalArguments : Arguments() {
        val code by string {
            name = "code"
            description = "The code you want to execute."
        }
    }
}