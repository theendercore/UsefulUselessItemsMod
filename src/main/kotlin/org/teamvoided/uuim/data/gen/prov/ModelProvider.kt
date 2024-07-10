package org.teamvoided.uuim.data.gen.prov

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator.TintType
import net.minecraft.data.client.model.Models
import net.minecraft.data.client.model.Texture
import org.teamvoided.uuim.init.UUIBlocks
import org.teamvoided.uuim.init.UUIItems

class ModelProvider(o: FabricDataOutput) : FabricModelProvider(o) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        gen.regFlowerPotPlant(Blocks.TORCHFLOWER, UUIBlocks.POTTED_TORCHFLOWER, TintType.NOT_TINTED)
        gen.regFlowerPotPlant(Blocks.PITCHER_PLANT, UUIBlocks.POPPED_PITCHER_PLANT, TintType.NOT_TINTED)
    }

    val singleLayer = listOf(
        UUIItems.GOLDEN_BEETROOT,
        UUIItems.COOKED_EGG
    )

    override fun generateItemModels(gen: ItemModelGenerator) {
        singleLayer.forEach { gen.register(it, Models.SINGLE_LAYER_ITEM) }
    }

    private fun BlockStateModelGenerator.regFlowerPotPlant(
        plantBlock: Block,
        flowerPotBlock: Block,
        tintType: TintType
    ) {
        val texture = Texture.plant(plantBlock)
        val identifier = tintType.flowerPotCrossModel.upload(flowerPotBlock, texture, this.modelCollector)
        this.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(flowerPotBlock, identifier))
    }
}