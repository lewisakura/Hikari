package hikari

import hikari.annotations.EventHandler
import hikari.events.Event
import hikari.events.EventBus
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation

class Hikari {
    private var intents = 0

    val eventBus = EventBus()

    fun ready() {
        // get intents integer ready
        eventBus.eventHandlers.keys.map { it.intents }.forEach { it.forEach { int -> intents += int.id } }


    }
}