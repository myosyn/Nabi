package live.shuuyu.valement.commands.options

@Suppress("UNUSED")
open class ApplicationCommandOptions() {
    companion object {
        val NO_OPTIONS = object : ApplicationCommandOptions() {}
    }

    /**
     * Creates an attachment argument, which involves files such as MP4, .JAR, etc.
     *
     * @param name The name of the argument.
     * @param description The description of the argument.
     */
    fun attachment(
        name: String,
        description: String,
    ) {

    }

    fun optionalAttachment(
        name: String,
        description: String,
    ) {

    }

    fun boolean(
        name: String,
        description: String,
    ) {

    }

    fun optionalBoolean(
        name: String,
        description: String
    ) {

    }

    fun channel(
        name: String,
        description: String
    ) {

    }

    fun optionalChannel(
        name: String,
        description: String
    ) {

    }

    fun int(
        name: String,
        description: String
    ) {

    }

    fun optionalInt(
        name: String,
        description: String
    ) {

    }

    // ????????? https://kordlib.github.io/kord/rest/dev.kord.rest.builder.interaction/integer.html
    fun integer(
        name: String,
        description: String,
    ) {

    }

    fun optionalInteger(
        name: String,
        description: String
    ) {

    }

    fun mentionable(
        name: String,
        description: String
    ) {

    }

    fun optionalMentionable(
        name: String,
        description: String
    ) {

    }

    fun number(
        name: String,
        description: String
    ) {

    }

    fun optionalNumber(
        name: String,
        description: String
    ) {

    }

    fun role(
        name: String,
        description: String,
    ) {

    }

    fun optionalRole(
        name: String,
        description: String,
    ) {

    }

    fun string(
        name: String,
        description: String,
    ) {

    }


    fun optionalString(
        name: String,
        description: String,
    ) {

    }

    fun user(
        name: String,
        description: String
    ) {

    }

    fun optionalUser(
        name: String,
        description: String
    ) {

    }
}

/**
inline fun <reified T> SlashCommandArgument.register(option: SlashCommandChoice) {

}
 */