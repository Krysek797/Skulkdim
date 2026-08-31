package com.skulkdim


import com.skulkdim.block.SkulkPortalBlock
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.FluidBlock
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModBlocks {



    val SKULK_WATER: FluidBlock = Registry.register(
        Registries.BLOCK,
        Identifier.of(SKULKDIM.MOD_ID, "skulk_water"),
        FluidBlock(ModFluids.SKULK_WATER, AbstractBlock.Settings.copy(Blocks.WATER))
        )
    val SKULK_PORTAL = Registry.register(
        Registries.BLOCK,
        Identifier.of(SKULKDIM.MOD_ID, "skulk_portal"),
        SkulkPortalBlock(
            AbstractBlock.Settings
                .create()
                .noCollision()
                .strength(-1.0f)
                .luminance { 15 }
                .dropsNothing()
        )
    )


    fun register() {

    }
}
