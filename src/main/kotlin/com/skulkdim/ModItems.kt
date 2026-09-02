<<<<<<< HEAD
package com.skulkdim

import com.skulkdim.item.ModArmorMaterials
import com.skulkdim.item.ModToolMaterials
import net.minecraft.item.ArmorItem
import net.minecraft.item.AxeItem
import net.minecraft.item.BlockItem
import net.minecraft.item.BucketItem
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.HoeItem
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SmithingTemplateItem
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity

object ModItems {

    val SCULK_ISLAND_BLOCK: Item = Registry.register(
        Registries.ITEM,
        Identifier.of(SKULKDIM.MOD_ID, "sculk_island_block"),
        BlockItem(ModBlocks.SCULK_ISLAND_BLOCK, Item.Settings())
    )


    val SCULK_ISLAND_STONE: Item = Registry.register(
        Registries.ITEM,
        Identifier.of(SKULKDIM.MOD_ID, "sculk_island_stone"),
        BlockItem(ModBlocks.SCULK_ISLAND_STONE, Item.Settings())
    )


    val SKULK_WATER_BUCKET: Item = Registry.register(
        Registries.ITEM,
        Identifier.of(SKULKDIM.MOD_ID, "skulk_water_bucket"),
        BucketItem(
            ModFluids.SKULK_WATER,
            Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)
        )
    )
    val ENRICHED_ECHO_SHARD: Item = registerItem(
        "enriched_echo_shard",
        Item(Item.Settings().rarity(Rarity.EPIC).fireproof())
    )

    val SKULK_UPGRADE_SMITHING_TEMPLATE: Item = registerItem(
        "skulk_upgrade_smithing_template",
        SmithingTemplateItem.createNetheriteUpgrade()
    )

    val SKULK_SWORD: Item = registerItem("skulk_sword", SwordItem(ModToolMaterials.SKULK, Item.Settings()))
    val SKULK_PICKAXE: Item = registerItem("skulk_pickaxe", PickaxeItem(ModToolMaterials.SKULK, Item.Settings()))
    val SKULK_AXE: Item = registerItem("skulk_axe", AxeItem(ModToolMaterials.SKULK, Item.Settings()))
    val SKULK_SHOVEL: Item = registerItem("skulk_shovel", ShovelItem(ModToolMaterials.SKULK, Item.Settings()))
    val SKULK_HOE: Item = registerItem("skulk_hoe", HoeItem(ModToolMaterials.SKULK, Item.Settings()))

    // 2. Części zbroi Skulk
    val SKULK_HELMET: Item = registerItem(
        "skulk_helmet",
        ArmorItem(ModArmorMaterials.SKULK, ArmorItem.Type.HELMET, Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37)))
    )

    val SKULK_CHESTPLATE: Item = registerItem(
        "skulk_chestplate",
        ArmorItem(ModArmorMaterials.SKULK, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37)))
    )

    val SKULK_LEGGINGS: Item = registerItem(
        "skulk_leggings",
        ArmorItem(ModArmorMaterials.SKULK, ArmorItem.Type.LEGGINGS, Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37)))
    )

    val SKULK_BOOTS: Item = registerItem(
        "skulk_boots",
        ArmorItem(ModArmorMaterials.SKULK, ArmorItem.Type.BOOTS, Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37)))
    )
    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(
            Registries.ITEM,
            Identifier.of(SKULKDIM.MOD_ID, name),
            item
        )
    }


    fun register() {}
}
=======
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
>>>>>>> f1943cfe6e26f9efb70965de203f796f3ab1daab
