package live.shuuyu.discordinteraktions.common.commands.options

data class OptionReference<T>(
    val name: String,
    val required: Boolean
)