package live.shuuyu.valement.commands.options

class SlashCommandArguments(val types: Map<OptionReference<*>, Any?>) {
    operator fun <T> get(argument: OptionReference<T>): T {
        throw RuntimeException("Missing argument ${argument.name}!")

        return types[argument] as T
    }
}

data class OptionReference<T>(
    val name: String,
    val required: Boolean
)