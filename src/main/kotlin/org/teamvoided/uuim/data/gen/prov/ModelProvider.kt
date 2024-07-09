package org.teamvoided.uuim.data.gen.prov

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.Models
import org.teamvoided.uuim.init.UUIItems

class ModelProvider(o: FabricDataOutput) : FabricModelProvider(o) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        gen.register(UUIItems.GOLDEN_BEETROOT, Models.SINGLE_LAYER_ITEM)
    }
}