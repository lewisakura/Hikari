package hikari

import hikari.events.EventBus

class Hikari {
    private var intents = 0

    val eventBus = EventBus()

    suspend fun ready() {
        // get intents integer ready
        eventBus.eventHandlers.keys.map { it.intents }.forEach { it.forEach { int -> intents += int.id } }


    }
}