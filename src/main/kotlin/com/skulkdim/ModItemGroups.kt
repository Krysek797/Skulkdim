package com.skulkdim

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier


object ModItemGroups {

    lateinit var SKULKDIM_GROUP: ItemGroup

    fun register() {
        SKULKDIM_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(SKULKDIM.MOD_ID, "skulkdim"),
            FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.skulkdim"))
                .icon { ItemStack(ModBlocks.SCULK_ISLAND_BLOCK) }
                .entries { _, entries ->
                    entries.add(ModItems.SCULK_ISLAND_BLOCK)
                    entries.add(ModItems.SCULK_ISLAND_STONE)
                    entries.add(ModItems.SKULK_WATER_BUCKET)
                    entries.add(ModItems.ENRICHED_ECHO_SHARD)
                    entries.add(ModItems.SKULK_UPGRADE_SMITHING_TEMPLATE)
                    entries.add(ModItems.SKULK_SWORD)
                    entries.add(ModItems.SKULK_PICKAXE)
                    entries.add(ModItems.SKULK_AXE)
                    entries.add(ModItems.SKULK_SHOVEL)
                    entries.add(ModItems.SKULK_HOE)
                    entries.add(ModItems.SKULK_HELMET)
                    entries.add(ModItems.SKULK_CHESTPLATE)
                    entries.add(ModItems.SKULK_LEGGINGS)
                    entries.add(ModItems.SKULK_BOOTS)
                }
                .build()
        )
    }
}
