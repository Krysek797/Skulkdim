package com.skulkdim

import com.skulkdim.item.ModArmorMaterials
import net.fabricmc.api.ModInitializer
import net.minecraft.registry.Registries

object SKULKDIM : ModInitializer {
    const val MOD_ID = "skulkdim"

    override fun onInitialize() {
        println("SKULKDIM INIT START")

        ModFluids.register()
        ModBlocks.register()
        AncientCityPortal.register()
        SkulkElytraRestriction.register()

        println("REGISTERED BLOCKS:")
        Registries.BLOCK.ids
            .filter { it.namespace == "skulkdim" }
            .forEach { println(it) }

        ModItems.register()
        ModItemGroups.register()
        ModArmorMaterials.register()
        }
    }


