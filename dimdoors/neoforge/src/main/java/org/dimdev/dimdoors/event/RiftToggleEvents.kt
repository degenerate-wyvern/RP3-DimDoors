package org.dimdev.dimdoors.event

import net.minecraft.core.BlockPos
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.bus.api.Event
import net.neoforged.bus.api.ICancellableEvent
import org.dimdev.dimdoors.api.event.RiftChangeReason

/**
 * Base of [RiftOpenEvent] and [RiftCloseEvent]. Posted on [net.neoforged.neoforge.common.NeoForge.EVENT_BUS]
 * when a player toggles a dimensional door or trapdoor, or when a detached rift decays away; see [reason].
 * Door toggles fire on both logical sides, so a listener that cancels must do so consistently on both.
 * Decay is server-side only and [player] is null.
 *
 * [state] is the block state before the change. Cancelling leaves the rift as it is.
 */
abstract class RiftToggleEvent(val level: Level, val pos: BlockPos, val state: BlockState, val player: Player?, val reason: RiftChangeReason) : Event(), ICancellableEvent

/** A closed rift is about to be opened. Cancellable. */
class RiftOpenEvent(level: Level, pos: BlockPos, state: BlockState, player: Player?, reason: RiftChangeReason) : RiftToggleEvent(level, pos, state, player, reason)

/** An open rift is about to be closed. Cancellable. */
class RiftCloseEvent(level: Level, pos: BlockPos, state: BlockState, player: Player?, reason: RiftChangeReason) : RiftToggleEvent(level, pos, state, player, reason)
