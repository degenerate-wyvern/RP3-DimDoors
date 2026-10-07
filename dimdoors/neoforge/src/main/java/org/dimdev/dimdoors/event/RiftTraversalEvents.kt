package org.dimdev.dimdoors.event

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.Entity
import net.neoforged.bus.api.Event
import org.dimdev.dimdoors.block.entity.Rift

/** Posted on [net.neoforged.neoforge.common.NeoForge.EVENT_BUS] just before [entity] is teleported through [rift]. */
class RiftEntranceEvent(val entity: Entity, val rift: Rift) : Event()

/**
 * Posted on [net.neoforged.neoforge.common.NeoForge.EVENT_BUS] once [entity] has arrived at the rift block
 * at [pos] in [level]. [entity] is the post-teleport instance, which may differ from the one that entered.
 */
class RiftExitEvent(val entity: Entity, val level: ServerLevel, val pos: BlockPos) : Event()
