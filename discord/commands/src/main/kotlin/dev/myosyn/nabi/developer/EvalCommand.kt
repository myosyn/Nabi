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
import dev.kord.common.entity.Snowflake
import dev.myosyn.nabi.BOT_OWNER

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
        ephemeralSlashCommand(::EvalArguments) {
            name = "EphemeralEval"
            description = "Ephemerally executes a command from Nabi herself."

            check {
                allowUser(Snowflake(962256545926746132))
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