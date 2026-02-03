package com.skulkdim

import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {

    fun register() {
        Registry.register(
            Registries.ITEM,
            Identifier.of(SKULKDIM.MOD_ID, "sculk_island_block"),
            BlockItem(ModBlocks.SCULK_ISLAND_BLOCK, Item.Settings())
        )
    }
}
