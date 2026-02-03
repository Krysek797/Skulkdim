package com.skulkdim

import net.fabricmc.api.ModInitializer

object SKULKDIM : ModInitializer {
    const val MOD_ID = "skulkdim"

    override fun onInitialize() {
        ModBlocks.register()
        ModItems.register()
    }
}
