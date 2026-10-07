package org.dimdev.dimdoors.api.event

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.Entity
import org.dimdev.dimcore.api.util.SimpleEvent
import org.dimdev.dimdoors.block.entity.Rift

/**
 * Fired when an entity goes through a rift.
 */
interface RiftTraversalCallback {
    /** Called before the entity is teleported through [rift]. */
    fun onEntrance(entity: Entity, rift: Rift)

    /** Called once the entity has arrived at the rift block located at [pos] in [level]. [entity] is the post-teleport instance. */
    fun onExit(entity: Entity, level: ServerLevel, pos: BlockPos)

    companion object {
        @JvmField
        val EVENT: SimpleEvent<RiftTraversalCallback> = SimpleEvent.of { listeners ->
            object : RiftTraversalCallback {
                override fun onEntrance(entity: Entity, rift: Rift) = listeners.forEach { it.onEntrance(entity, rift) }

                override fun onExit(entity: Entity, level: ServerLevel, pos: BlockPos) = listeners.forEach { it.onExit(entity, level, pos) }
            }
        }
    }
}
