package org.dimdev.dimdoors.api.event

import net.minecraft.core.BlockPos
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import org.dimdev.dimcore.api.util.SimpleEvent

/**
 * Fired when a rift opens or closes, either by a player toggling a door or by decaying away (see [RiftChangeReason]).
 */
interface RiftToggleCallback {
    /**
     * @param opening true if the rift is about to open, false if it is about to close
     * @return false to cancel the change
     */
    fun onToggle(level: Level, pos: BlockPos, state: BlockState, opening: Boolean, player: Player?, reason: RiftChangeReason): Boolean

    companion object {
        @JvmField
        val EVENT: SimpleEvent<RiftToggleCallback> = SimpleEvent.of { listeners ->
            object : RiftToggleCallback {
                override fun onToggle(level: Level, pos: BlockPos, state: BlockState, opening: Boolean, player: Player?, reason: RiftChangeReason) =
                    listeners.all { it.onToggle(level, pos, state, opening, player, reason) }
            }
        }
    }
}
