package com.skulkdim

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.Items
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

object AncientCityPortal {
    private const val INTERIOR_WIDTH = 20
    private const val INTERIOR_HEIGHT = 6
    private val pendingChecks = mutableSetOf<Pair<ServerWorld, BlockPos>>()

    fun register() {
        UseBlockCallback.EVENT.register { player, world, hand, hitResult ->
            if (!world.isClient && player.getStackInHand(hand).isOf(Items.SCULK_CATALYST)) {
                pendingChecks += (world as ServerWorld) to hitResult.blockPos.offset(hitResult.side)
            }
            ActionResult.PASS
        }

        ServerTickEvents.END_SERVER_TICK.register {
            val checks = pendingChecks.toList()
            pendingChecks.clear()
            checks.forEach { (world, placedPos) ->
                if (world.registryKey == World.OVERWORLD) tryActivate(world, placedPos)
            }
        }
    }

    private fun tryActivate(world: ServerWorld, placedPos: BlockPos) {
        for (widthDirection in listOf(Direction.EAST, Direction.SOUTH)) {
            for (x in 0 until INTERIOR_WIDTH) {
                for (y in 0 until INTERIOR_HEIGHT) {
                    val interiorOrigin = placedPos.offset(widthDirection, -x).down(y)
                    if (isCompleteAncientCityFrame(world, interiorOrigin, widthDirection)) {
                        openPortal(world, interiorOrigin, widthDirection)
                        return
                    }
                }
            }
        }
    }

    private fun isCompleteAncientCityFrame(world: ServerWorld, origin: BlockPos, direction: Direction): Boolean {
        for (x in 0 until INTERIOR_WIDTH) for (y in 0 until INTERIOR_HEIGHT) {
            if (!world.getBlockState(origin.offset(direction, x).up(y)).isOf(Blocks.SCULK_CATALYST)) return false
        }
        for (x in -1..INTERIOR_WIDTH) {
            if (!world.getBlockState(origin.offset(direction, x).down()).isOf(Blocks.REINFORCED_DEEPSLATE) ||
                !world.getBlockState(origin.offset(direction, x).up(INTERIOR_HEIGHT)).isOf(Blocks.REINFORCED_DEEPSLATE)
            ) return false
        }
        for (y in 0 until INTERIOR_HEIGHT) {
            if (!world.getBlockState(origin.offset(direction, -1).up(y)).isOf(Blocks.REINFORCED_DEEPSLATE) ||
                !world.getBlockState(origin.offset(direction, INTERIOR_WIDTH).up(y)).isOf(Blocks.REINFORCED_DEEPSLATE)
            ) return false
        }
        return true
    }

    private fun openPortal(world: ServerWorld, origin: BlockPos, direction: Direction) {
        for (x in 0 until INTERIOR_WIDTH) for (y in 0 until INTERIOR_HEIGHT) {
            world.setBlockState(origin.offset(direction, x).up(y), ModBlocks.SKULK_PORTAL.defaultState, Block.NOTIFY_ALL)
        }
    }
}
