package live.shuuyu.nabi.kord.config

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import dev.kord.common.entity.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import live.shuuyu.nabi.kord.utils.env
import java.io.File

@SerialName("config")
@Serializable
data class NabiConfig (
    val token: String = env("TOKEN"),
    val applicationId: Snowflake = Snowflake(env("APPLICATION_ID")),
    val shardCount: Int = 1,
    val shardIndex: Int = 0,
    val databaseJDBC: String = env("DATABASE_JDBC"),
    val databaseUsername: String = env("DATABASE_USERNAME"),
    val databasePassword: String = env("DATABASE_PASSWORD")
)

val config: NabiConfig by lazy {
    val yaml = Yaml(configuration = YamlConfiguration(
        encodeDefaults = false
    ))

    val config = File("NabiConfig.yaml").also {
        if (!it.exists()) {
            it.createNewFile()
            it.writeText(yaml.encodeToString(NabiConfig()))
        }
    }.readText()

    yaml.decodeFromString(config)
}