package org.dimdev.dimdoors.event

import net.neoforged.bus.api.Event
import net.neoforged.bus.api.ICancellableEvent
import org.dimdev.dimdoors.block.entity.Rift

/**
 * Base of [RiftRegisterEvent] and [RiftUnregisterEvent]. Posted on [net.neoforged.neoforge.common.NeoForge.EVENT_BUS]
 * server-side when a rift is added to or removed from the rift registry.
 */
abstract class RiftRegistrationEvent(val rift: Rift) : Event(), ICancellableEvent

/** A rift is about to be registered (opened). Cancelling leaves it unregistered. */
class RiftRegisterEvent(rift: Rift) : RiftRegistrationEvent(rift)

/** A rift is about to be unregistered (closed). Cancelling keeps the rift in place. */
class RiftUnregisterEvent(rift: Rift) : RiftRegistrationEvent(rift)
