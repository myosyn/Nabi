package live.shuuyu.nabi.kord.interactions.commands.moderation.utils

enum class PunishmentError {
    /**
     * Since we cannot ban users that are owners, we simply have to do this.
      */
    USER_IS_OWNER,


    USER_IS_SELF,

    /**
     * You cannot ban any bots, as Discord is weird.
     */
    USER_IS_BOT,

    /**
     * In theory, this should only return if Nabi is not given a certain type of permission.
     */
    BOT_PERMISSION_MISSING,

}