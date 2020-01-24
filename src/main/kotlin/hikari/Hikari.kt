package hikari

import hikari.annotations.EventHandler
import hikari.events.Event
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation

class Hikari {
    private var intents = 0
    val eventHandlers: MutableMap<Event, MutableMap<Any, MutableList<KCallable<*>>>> = mutableMapOf()

    @ExperimentalStdlibApi
    fun addEventHandler(`class`: Any) {
        `class`::class.members.filter { it.hasAnnotation<EventHandler>() }
            .forEach { method ->
                val event = method.findAnnotation<EventHandler>()!!.event
                if (!eventHandlers.containsKey(event))
                    eventHandlers[event] = mutableMapOf()

                if (!eventHandlers[event]?.containsKey(`class`)!!)
                    eventHandlers[event]?.set(`class`, mutableListOf())

                eventHandlers[event]?.get(`class`)?.add(method)

                intents = intents or event.intents.map { it.id }.reduce { a, b -> a + b }
            }
    }
}