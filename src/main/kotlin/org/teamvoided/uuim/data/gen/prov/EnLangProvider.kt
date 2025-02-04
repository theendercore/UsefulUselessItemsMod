package org.teamvoided.uuim.data.gen.prov

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import org.teamvoided.uuim.init.UUIBlocks
import org.teamvoided.uuim.init.UUIItems
import java.util.concurrent.CompletableFuture

class EnLangProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) : FabricLanguageProvider(o, r) {
    val blocks = listOf(
        UUIBlocks.POTTED_TORCHFLOWER,
        UUIBlocks.POPPED_PITCHER_PLANT
    )
    override fun generateTranslations(lookup: HolderLookup.Provider, gen: TranslationBuilder) {
        UUIItems.tabItems.forEach { gen.add(it.translationKey, genLang(it.id)) }
        blocks.forEach { gen.add(it.id.path, genLang(it.id)) }

        gen.add("item.uuim.invisible_item_frame", "Invisible Item Frame")
        gen.add("item.uuim.invisible_glow_item_frame", "Invisible Glowing Item Frame")
    }

    private fun genLang(id: Identifier): String =
        id.path.split("_").joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }

    val Item.id get() = Registries.ITEM.getId(this)
    val Block.id get() = Registries.BLOCK.getId(this)
//    val EntityType<*>.id get() = Registries.ENTITY_TYPE.getId(this)
}