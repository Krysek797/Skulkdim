package com.skulkdim.item

import com.skulkdim.ModItems
import net.minecraft.block.Block
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey

object ModToolMaterials {
    val SKULK = object : ToolMaterial {
        override fun getDurability(): Int = 2500
        override fun getMiningSpeedMultiplier(): Float = 10.0f
        override fun getAttackDamage(): Float = 5.0f
        override fun getInverseTag(): TagKey<Block> = BlockTags.INCORRECT_FOR_NETHERITE_TOOL
        override fun getEnchantability(): Int = 18
        override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(ModItems.ENRICHED_ECHO_SHARD)
    }
}
