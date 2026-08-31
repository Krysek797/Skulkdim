package com.skulkdim

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object SkulkElytraRestriction {
    fun register() {
        ServerTickEvents.END_SERVER_TICK.register { server ->
            server.playerManager.playerList.forEach { player ->
                if (player.world.registryKey != ModDimensions.SKULK_LEVEL_KEY) return@forEach

                val chestItem = player.getEquippedStack(EquipmentSlot.CHEST)
                if (chestItem.isOf(Items.ELYTRA)) {
                    val returnedElytra = chestItem.copy()
                    player.equipStack(EquipmentSlot.CHEST, ItemStack.EMPTY)
                    player.stopFallFlying()
                    if (!player.inventory.insertStack(returnedElytra)) {
                        player.dropItem(returnedElytra, false)
                    }
                }
            }
        }
    }
}
