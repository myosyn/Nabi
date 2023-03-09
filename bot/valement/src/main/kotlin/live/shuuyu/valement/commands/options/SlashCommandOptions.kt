package live.shuuyu.valement.commands.options

import dev.kord.common.Locale
import dev.kord.common.entity.CommandArgument
import dev.kord.common.entity.DiscordInteraction
import dev.kord.common.entity.optional.optional
import dev.kord.core.Kord
import dev.kord.core.entity.Attachment
import dev.kord.core.entity.Role
import dev.kord.rest.builder.interaction.*

interface DefaultCommandOption<T> {
    val name: String

    fun register(builder: BaseInputChatBuilder)
    fun validate(kord: Kord, args: List<CommandArgument<*>>, interaction: DiscordInteraction): T?
}

interface InitialCommandOption<T> : DefaultCommandOption<T> {
    val description: String
    val nameLocalizations: Map<Locale, String>?
    val descriptionLocalizations: Map<Locale, String>?
}

interface RequiredCommandOption<T> : InitialCommandOption<T> {
    val required: Boolean
}

interface ChoiceCommandOption<T> : RequiredCommandOption<T> {
    val choices: List<SlashCommandChoice<T>>?
}

// Attachment Option
interface AttachmentCommandOption : RequiredCommandOption<Attachment> {
    override fun register(builder: BaseInputChatBuilder) {
        val self = this@AttachmentCommandOption

        builder.attachment(self.name, self.description) {
            this.nameLocalizations = self.nameLocalizations?.toMutableMap()
            this.descriptionLocalizations = self.descriptionLocalizations?.toMutableMap()
            this.required = self.required
        }
    }
}

// Boolean Option
interface BooleanCommandOptions : RequiredCommandOption<Boolean> {
    override fun register(builder: BaseInputChatBuilder) {
        val self = this@BooleanCommandOptions

        builder.boolean(self.name, self.description) {
            this.nameLocalizations = self.nameLocalizations?.toMutableMap()
            this.descriptionLocalizations = self.descriptionLocalizations?.toMutableMap()
            this.required = self.required
        }
    }
}

// Boolean Option
interface RoleCommandOptions : RequiredCommandOption<Role> {
    override fun register(builder: BaseInputChatBuilder) {
        val self = this@RoleCommandOptions

        builder.role(self.name, self.description) {
            this.nameLocalizations = self.nameLocalizations?.toMutableMap()
            this.descriptionLocalizations = self.descriptionLocalizations?.toMutableMap()

        }
    }
}

// String Option
interface StringCommandOption : RequiredCommandOption<String>, ChoiceCommandOption<String> {
    var minLength: Int?
    var maxLength: Int?

    override fun register(builder: BaseInputChatBuilder) {
        val self = this@StringCommandOption

        builder.string(self.name, self.description) {
            this.minLength = self.minLength
            this.maxLength = self.maxLength
            this.nameLocalizations = self.nameLocalizations?.toMutableMap()
            this.descriptionLocalizations = self.descriptionLocalizations?.toMutableMap()
            this.required = self.required

            self.choices?.forEach { choice ->
                choice(choice.name, choice.value, choice.nameLocalization.optional())
            }
        }
    }
}

// Integer Option
interface IntegerOptionBuilder : RequiredCommandOption<Long>, ChoiceCommandOption<Long> {
    val maxValue: Long?
    val minValue: Long?

    override fun register(builder: BaseInputChatBuilder) {
        val self = this@IntegerOptionBuilder

        builder.integer(self.name, self.description) {
            this.minValue = self.minValue
            this.maxValue = self.maxValue
            this.nameLocalizations = self.nameLocalizations?.toMutableMap()
            this.descriptionLocalizations = self.descriptionLocalizations?.toMutableMap()

            self.choices?.forEach { choice ->
                choice(choice.name, choice.value, choice.nameLocalization.optional())
            }
        }
    }
}