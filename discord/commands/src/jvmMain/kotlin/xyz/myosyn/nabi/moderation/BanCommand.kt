package xyz.myosyn.nabi.moderation

import dev.kord.rest.service.RestClient
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutorDeclaration
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments
import net.perfectdreams.discordinteraktions.common.entities.User

class BanCommand(val rest: RestClient) : SlashCommandExecutor() {
    companion object : SlashCommandExecutorDeclaration(BanCommand::class) {
        object Options : ApplicationCommandOptions() {
            val user = string("user", "")
                .register()
        }

        override val options: Options
            get() {
                TODO()
            }
    }

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        TODO("Not yet implemented")
    }
}