package com.skulkdim

import net.minecraft.fluid.FlowableFluid
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModFluids {

    lateinit var SKULK_WATER: FlowableFluid
    lateinit var FLOWING_SKULK_WATER: FlowableFluid

    fun register() {
        SKULK_WATER = Registry.register(
            Registries.FLUID,
            Identifier.of(SKULKDIM.MOD_ID, "skulk_water"),
            SkulkWaterFluid.Still()
        )

        FLOWING_SKULK_WATER = Registry.register(
            Registries.FLUID,
            Identifier.of(SKULKDIM.MOD_ID, "flowing_skulk_water"),
            SkulkWaterFluid.Flowing()
        )
    }
}
