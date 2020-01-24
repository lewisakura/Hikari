package hikari.events

import hikari.annotations.EventHandler
import hikari.exception.EventBusException
import java.lang.IllegalArgumentException
import kotlin.reflect.KCallable
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation

class EventBus {
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
            }
    }

    fun fireEvent(event: Event, vararg args: Any?) {
        eventHandlers[event]?.forEach { `class` ->
            `class`.value.forEach {
                try {
                    it.call(`class`.key, *args)
                } catch(e: IllegalArgumentException) {
                    throw EventBusException("Handler `$it` for event $event does not have the correct parameters. " +
                            "Please consult documentation for the correct parameters for this event.")
                }
            }
        }
    }
}