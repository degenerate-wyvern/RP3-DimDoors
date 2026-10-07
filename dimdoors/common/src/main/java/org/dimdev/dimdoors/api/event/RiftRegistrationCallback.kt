package org.dimdev.dimdoors.api.event

import org.dimdev.dimcore.api.util.SimpleEvent
import org.dimdev.dimdoors.block.entity.Rift

/**
 * Fired when a rift is registered in, or unregistered from, the rift registry.
 */
interface RiftRegistrationCallback {
    /**
     * @param registering true if the rift is about to be registered, false if it is about to be unregistered
     * @return false to cancel
     */
    fun onRegistration(rift: Rift, registering: Boolean): Boolean

    companion object {
        @JvmField
        val EVENT: SimpleEvent<RiftRegistrationCallback> = SimpleEvent.of { listeners ->
            object : RiftRegistrationCallback {
                override fun onRegistration(rift: Rift, registering: Boolean) = listeners.all { it.onRegistration(rift, registering) }
            }
        }
    }
}
