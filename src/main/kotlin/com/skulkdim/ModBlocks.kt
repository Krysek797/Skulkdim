<<<<<<< HEAD
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
=======
package com.skulkdim

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

object ModBlocks {

    val SCULK_ISLAND_BLOCK: Block = Registry.register(
        Registries.BLOCK,
        Identifier.of(SKULKDIM.MOD_ID, "sculk_island_block"),
        Block(
            AbstractBlock.Settings
                .copy(Blocks.SCULK)
                .strength(4.0f)
                .sounds(BlockSoundGroup.SCULK)
        )
    )

    fun register() {}
}
>>>>>>> f1943cfe6e26f9efb70965de203f796f3ab1daab
