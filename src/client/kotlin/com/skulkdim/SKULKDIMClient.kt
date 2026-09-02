package com.skulkdim

import net.fabricmc.api.ClientModInitializer
<<<<<<< HEAD
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler
import net.minecraft.client.render.RenderLayer
=======
>>>>>>> f1943cfe6e26f9efb70965de203f796f3ab1daab

object SKULKDIMClient : ClientModInitializer {

	override fun onInitializeClient() {
<<<<<<< HEAD
		FluidRenderHandlerRegistry.INSTANCE.register(
			ModFluids.SKULK_WATER,
			ModFluids.FLOWING_SKULK_WATER,
			SimpleFluidRenderHandler.coloredWater(0x0B1F5E)
		)
		BlockRenderLayerMap.INSTANCE.putFluids(
			RenderLayer.getTranslucent(),
			ModFluids.SKULK_WATER,
			ModFluids.FLOWING_SKULK_WATER
		)
=======
		println("SKULKDIM client loaded")
>>>>>>> f1943cfe6e26f9efb70965de203f796f3ab1daab
	}
}
