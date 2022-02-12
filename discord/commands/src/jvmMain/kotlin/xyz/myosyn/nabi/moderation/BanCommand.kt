package xyz.myosyn.nabi.moderation

import dev.kord.rest.service.RestClient
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutorDeclaration
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

// TO-DO: Find a way to replace the string by referencing the user. If only Discord Interaktion had documents....

class BanCommand(val rest: RestClient) : SlashCommandExecutor() {
    companion object : SlashCommandExecutorDeclaration(BanCommand::class) {
        object Options : ApplicationCommandOptions() {
            val user = string("user", "The user/victim you want to ban from the server. Wait, I shouldn't have said that.")
                .register()
            val reason = optionalString("reason", "The reason why this user was banned.")
                .register()

        }

        override val options = Options
    }

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        TODO("Not yet implemented")
    }
}