package org.teamvoided.uuim

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import org.teamvoided.uuim.init.UUIBlocks

@Suppress("unused")
object UsefulUselessItemsModClient {
    val cutout = listOf(
        UUIBlocks.POTTED_TORCHFLOWER,
        UUIBlocks.POPPED_PITCHER_PLANT
    )

    fun init() {
        cutout.forEach { BlockRenderLayerMap.INSTANCE.putBlock(it, RenderLayer.getCutout()) }
    }
}
