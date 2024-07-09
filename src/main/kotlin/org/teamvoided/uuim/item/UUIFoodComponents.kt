package org.teamvoided.uuim.item

import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent

object UUIFoodComponents {
    val GOLDEN_BEETROOT = FoodComponent.Builder()
        .hunger(5)
        .saturation(1.0f)
        .statusEffect(StatusEffectInstance(StatusEffects.NIGHT_VISION, 120, 0), 1.0f)
        .build()
    val COOKED_EGG = FoodComponent.Builder()
        .hunger(5)
        .saturation(0.6f)
        .build()

}