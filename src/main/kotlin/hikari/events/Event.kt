package hikari.events

/**
 * Gateway Events
 */
enum class Event(val intents: List<Intent>) {
    GUILD_CREATE(listOf(Intent.GUILDS)),
    GUILD_DELETE(listOf(Intent.GUILDS)),
    GUILD_ROLE_CREATE(listOf(Intent.GUILDS)),
    GUILD_ROLE_UPDATE(listOf(Intent.GUILDS)),
    GUILD_ROLE_DELETE(listOf(Intent.GUILDS)),

    CHANNEL_UPDATE(listOf(Intent.GUILDS)),
    CHANNEL_DELETE(listOf(Intent.GUILDS)),
    CHANNEL_PINS_UPDATE(listOf(Intent.GUILDS)),

    GUILD_MEMBER_ADD(listOf(Intent.GUILD_MEMBERS)),
    GUILD_MEMBER_UPDATE(listOf(Intent.GUILD_MEMBERS)),
    GUILD_MEMBER_REMOVE(listOf(Intent.GUILD_MEMBERS)),

    GUILD_BAN_ADD(listOf(Intent.GUILD_BANS)),
    GUILD_BAN_REMOVE(listOf(Intent.GUILD_BANS)),

    GUILD_EMOJIS_UPDATE(listOf(Intent.GUILD_EMOJIS)),

    GUILD_INTEGRATIONS_UPDATE(listOf(Intent.GUILD_INTEGRATIONS)),

    WEBHOOKS_UPDATE(listOf(Intent.GUILD_WEBHOOKS)),

    INVITE_CREATE(listOf(Intent.GUILD_INVITES)),
    INVITE_DELETE(listOf(Intent.GUILD_INVITES)),

    VOICE_STATE_UPDATE(listOf(Intent.GUILD_VOICE_STATES)),

    PRESENCE_UPDATE(listOf(Intent.GUILD_PRESENCES)),

    // Special cases with multiple intents
    CHANNEL_CREATE(listOf(Intent.GUILDS, Intent.DIRECT_MESSAGES)),

    MESSAGE_CREATE(listOf(
        Intent.GUILD_MESSAGES,
        Intent.DIRECT_MESSAGES
    )),
    MESSAGE_UPDATE(listOf(
        Intent.GUILD_MESSAGES,
        Intent.DIRECT_MESSAGES
    )),
    MESSAGE_DELETE(listOf(
        Intent.GUILD_MESSAGES,
        Intent.DIRECT_MESSAGES
    )),

    MESSAGE_REACTION_ADD(listOf(
        Intent.GUILD_MESSAGE_REACTIONS,
        Intent.DIRECT_MESSAGE_REACTIONS
    )),
    MESSAGE_REACTION_REMOVE(listOf(
        Intent.GUILD_MESSAGE_REACTIONS,
        Intent.DIRECT_MESSAGE_REACTIONS
    )),
    MESSAGE_REACTION_REMOVE_ALL(listOf(
        Intent.GUILD_MESSAGE_REACTIONS,
        Intent.DIRECT_MESSAGE_REACTIONS
    )),
    MESSAGE_REACTION_REMOVE_EMOJI(listOf(
        Intent.GUILD_MESSAGE_REACTIONS,
        Intent.DIRECT_MESSAGE_REACTIONS
    )),

    TYPING_START(listOf(
        Intent.GUILD_MESSAGE_TYPING,
        Intent.DIRECT_MESSAGE_TYPING
    ))

    // Passthroughs
}