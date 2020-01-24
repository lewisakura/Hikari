package hikari.test

import hikari.Hikari
import hikari.annotations.EventHandler
import hikari.events.Event

@ExperimentalStdlibApi
fun main() {
    val hi = Hikari()

    hi.addEventHandler(test())
    println(hi.eventHandlers)

    hi.eventHandlers[Event.MESSAGE_CREATE]?.forEach { `class` ->
        `class`.value.forEach {
            it.call(`class`.key)
        }
    }
}

class test {
    @EventHandler(Event.MESSAGE_CREATE)
    fun test() {
        println("event handler called")
    }

    @EventHandler(Event.MESSAGE_CREATE)
    fun test2() {
        println("event handler 2 called")
    }
}