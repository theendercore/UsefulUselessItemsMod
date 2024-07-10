package org.teamvoided.uuim.init

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.FlowerPotBlock
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import org.teamvoided.uuim.UsefulUselessItemsMod.id
import org.teamvoided.uuim.util.register

object UUIBlocks {
    fun init() {}


    val POTTED_TORCHFLOWER = regNoItem("potted_torchflower", pottedVariant(Blocks.TORCHFLOWER))
    val POPPED_PITCHER_PLANT = regNoItem("popped_pitcher_plant", pottedVariant(Blocks.PITCHER_PLANT))

    fun <T : Block> reg(id: String, block: T): T {
        val regBlock = Registries.BLOCK.register(id(id), block)
        UUIItems.reg(id, BlockItem(regBlock, Item.Settings()))
        return block
    }

    fun pottedVariant(block: Block): Block {
        return FlowerPotBlock(
            block,
            AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)
        )
    }

    fun <T : Block> regNoItem(id: String, block: T): T = (Registries.BLOCK.register(id(id), block) as T)
}