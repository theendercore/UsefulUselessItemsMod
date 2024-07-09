package org.teamvoided.uuim.init

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import org.teamvoided.uuim.UsefulUselessItemsMod.id
import org.teamvoided.uuim.item.UUIFoodComponents
import org.teamvoided.uuim.util.register

object UUIItems {
    val tabItems = mutableListOf<Item>()
    fun init() {}

    val GOLDEN_BEETROOT = reg("golden_beetroot", Item(Item.Settings().food(UUIFoodComponents.GOLDEN_BEETROOT)))
    val COOKED_EGG = reg("cooked_egg", Item(Item.Settings().food(UUIFoodComponents.COOKED_EGG)))

    fun <T : Item> reg(id: String, item: T): T {
        val regItem = Registries.ITEM.register(id(id), item)
        tabItems.add(regItem)
        return item
    }
}