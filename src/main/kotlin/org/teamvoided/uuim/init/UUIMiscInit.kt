package org.teamvoided.uuim.init

import net.minecraft.block.ComposterBlock
import net.minecraft.item.Items

object UUIMiscInit {

    fun init() {

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(Items.ROTTEN_FLESH, 0.1f)
    }
}