package com.skulkdim.block

import com.skulkdim.ModBlocks
import com.skulkdim.ModDimensions
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.entity.Entity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.Heightmap
import net.minecraft.world.TeleportTarget
import net.minecraft.world.World

class SkulkPortalBlock(settings: Settings) : Block(settings) {
    override fun onEntityCollision(state: BlockState, world: World, pos: BlockPos, entity: Entity) {
        if (world !is ServerWorld || !entity.canUsePortals(false)) return

        val destinationKey = if (world.registryKey == ModDimensions.SKULK_LEVEL_KEY) {
            World.OVERWORLD
        } else {
            ModDimensions.SKULK_LEVEL_KEY
        }
        val destination = world.server.getWorld(destinationKey) ?: return
        val targetPos = if (destinationKey == ModDimensions.SKULK_LEVEL_KEY) {
            findSafeArrival(destination)
        } else {
            Vec3d(entity.x, world.topY.toDouble(), entity.z)
        }

        entity.teleportTo(
            TeleportTarget(
                destination,
                targetPos,
                Vec3d.ZERO,
                entity.yaw,
                entity.pitch,
                TeleportTarget.NO_OP
            )
        )
    }

    private fun findSafeArrival(world: ServerWorld): Vec3d {
        for (radius in 0..32) {
            for (x in -radius..radius) for (z in -radius..radius) {
                if (radius != 0 && kotlin.math.abs(x) != radius && kotlin.math.abs(z) != radius) continue

                val topY = world.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z)
                for (y in topY downTo world.bottomY + 1) {
                    val floor = BlockPos(x, y - 1, z)
                    val feet = floor.up()
                    val head = feet.up()
                    if (world.getBlockState(floor).isSolidBlock(world, floor) &&
                        world.getFluidState(feet).isEmpty && world.getFluidState(head).isEmpty &&
                        world.getBlockState(feet).isAir && world.getBlockState(head).isAir
                    ) return Vec3d(x + 0.5, y.toDouble(), z + 0.5)
                }
            }
        }

        val y = world.topY.coerceIn(world.bottomY + 2, world.topY - 2)
        val center = BlockPos(0, y, 0)
        for (x in -1..1) for (z in -1..1) {
            world.setBlockState(center.add(x, -1, z), ModBlocks.SCULK_ISLAND_STONE.defaultState)
            world.setBlockState(center.add(x, 0, z), Blocks.AIR.defaultState)
            world.setBlockState(center.add(x, 1, z), Blocks.AIR.defaultState)
        }
        return Vec3d(0.5, y.toDouble(), 0.5)
    }
}
