package com.skulkdim.item

import com.skulkdim.ModItems
import com.skulkdim.SKULKDIM.MOD_ID
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import java.util.function.Supplier

object ModArmorMaterials {

    // Rejestracja materiału Skulk
    val SKULK: RegistryEntry<ArmorMaterial> = register("skulk", mapOf(
        ArmorItem.Type.BOOTS to 4,
        ArmorItem.Type.LEGGINGS to 7,
        ArmorItem.Type.CHESTPLATE to 9,
        ArmorItem.Type.HELMET to 4
    ), 15, 3.5f, 0.1f)
    fun register() {}

    private fun register(
        id: String,
        defensePoints: Map<ArmorItem.Type, Int>,
        enchantability: Int,
        toughness: Float,
        knockbackResistance: Float
    ): RegistryEntry<ArmorMaterial> {
        val layers = listOf(ArmorMaterial.Layer(Identifier.of(MOD_ID, id)))

        val material = ArmorMaterial(
            defensePoints,
            enchantability,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            // Odwołujemy się do sharda z ModItems
            Supplier { Ingredient.ofItems(ModItems.ENRICHED_ECHO_SHARD) },
            layers,
            toughness,
            knockbackResistance
        )

        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(MOD_ID, id), material)
    }
}
fun register() {}