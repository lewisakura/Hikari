package hikari.annotations

import hikari.events.Event

/**
 * Turns a method into an event handling method.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class EventHandler(val event: Event)