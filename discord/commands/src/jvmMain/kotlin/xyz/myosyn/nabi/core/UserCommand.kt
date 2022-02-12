package xyz.myosyn.nabi.core

import dev.kord.rest.service.RestClient
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutorDeclaration
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments
import xyz.myosyn.nabi.moderation.BanCommand

class UserCommand(val rest: RestClient) : SlashCommandExecutor() {
    companion object : SlashCommandExecutorDeclaration(BanCommand::class) {
        object Options : ApplicationCommandOptions() {
            val user = optionalUser("user", "The user you want to lookup. ")
                    .register()
        }

        override val options = Options
    }

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        TODO("Not yet implemented")
    }
}