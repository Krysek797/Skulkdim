package com.skulkdim

import net.minecraft.block.BlockState
import net.minecraft.block.FluidBlock
import net.minecraft.fluid.FlowableFluid
import net.minecraft.fluid.Fluid
import net.minecraft.fluid.FluidState
import net.minecraft.item.Item
import net.minecraft.state.StateManager
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import net.minecraft.world.WorldView

abstract class SkulkWaterFluid : FlowableFluid() {

    override fun getStill(): Fluid = ModFluids.SKULK_WATER
    override fun getFlowing(): Fluid = ModFluids.FLOWING_SKULK_WATER
    override fun getBucketItem(): Item = ModItems.SKULK_WATER_BUCKET

    override fun isInfinite(world: World): Boolean = true

    override fun beforeBreakingBlock(world: WorldAccess, pos: BlockPos, state: BlockState) {
        val blockEntity = if (state.hasBlockEntity()) world.getBlockEntity(pos) else null
        net.minecraft.block.Block.dropStacks(state, world, pos, blockEntity)
    }

    override fun getFlowSpeed(world: WorldView): Int = 4
    override fun getLevelDecreasePerBlock(world: WorldView): Int = 1
    override fun getTickRate(world: WorldView): Int = 5
    override fun getBlastResistance(): Float = 100f

    override fun canBeReplacedWith(
        state: FluidState,
        world: BlockView,
        pos: BlockPos,
        fluid: Fluid,
        direction: Direction
    ): Boolean {
        return direction == Direction.DOWN && !fluid.matchesType(getStill())
    }

    override fun toBlockState(state: FluidState): BlockState {
        return ModBlocks.SKULK_WATER.defaultState
            .with(FluidBlock.LEVEL, getBlockStateLevel(state))
    }


    class Flowing : SkulkWaterFluid() {

        init {
            defaultState = stateManager.defaultState
                .with(LEVEL, 7)
                .with(FALLING, false)
        }

        override fun appendProperties(builder: StateManager.Builder<Fluid, FluidState>) {
            builder.add(LEVEL, FALLING)
        }

        override fun isStill(state: FluidState): Boolean = false
        override fun getLevel(state: FluidState): Int = state.get(LEVEL)
    }

    class Still : SkulkWaterFluid() {

        override fun appendProperties(builder: StateManager.Builder<Fluid, FluidState>) {
            builder.add(LEVEL, FALLING)
        }

        override fun isStill(state: FluidState): Boolean = true
        override fun getLevel(state: FluidState): Int = 8
    }
}
