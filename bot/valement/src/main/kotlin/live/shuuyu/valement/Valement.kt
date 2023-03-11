package live.shuuyu.valement

import dev.kord.common.annotation.KordExperimental
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord

class Valement(
    val kord: Kord,
    val applicationId: Snowflake,
) {

}

@OptIn(KordExperimental::class)
fun Valement(token: String, applicationId: Snowflake) = Valement(
    Kord.restOnly(token),
    applicationId
)
