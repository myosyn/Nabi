package myosyn.nabi.extensions.general

class Statistics : Extensions() {
    override val name: String = "stats"

    override suspend fun setup() {

        publicSlashCommand {
            name = "stats"
            description = "Shows you the current ram & cpu usage of Nabi"

            check {
                anyGuild()
            }

            action{
                
            }
        }
    }
}