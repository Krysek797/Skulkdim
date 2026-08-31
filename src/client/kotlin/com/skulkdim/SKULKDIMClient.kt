package com.skulkdim

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler
import net.minecraft.client.render.RenderLayer

object SKULKDIMClient : ClientModInitializer {

	override fun onInitializeClient() {
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
	}
}
