package dev.myosyn.nabi.developer

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.annotation.KordPreview

@KordPreview
class EvalCommand : Extension() {
    override val name: String = "eval"

    override suspend fun setup() {
        publicSlashCommand(::EvalArguments) {
            name = "eval"
            description = "Executes a command from Nabi herself."

            check {
                anyGuild()
            }

            action {
                val code = arguments.code
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