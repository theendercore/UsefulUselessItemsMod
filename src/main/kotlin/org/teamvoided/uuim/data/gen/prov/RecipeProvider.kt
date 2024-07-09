package org.teamvoided.uuim.data.gen.prov

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory
import net.minecraft.item.Items
import net.minecraft.recipe.RecipeCategory
import net.minecraft.registry.HolderLookup
import org.teamvoided.uuim.init.UUIItems
import java.util.concurrent.CompletableFuture

class RecipeProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) : FabricRecipeProvider(o, r) {
    override fun generateRecipes(exporter: RecipeExporter) {
        ShapedRecipeJsonFactory.create(RecipeCategory.FOOD, UUIItems.GOLDEN_BEETROOT)
            .pattern("###")
            .pattern("#X#")
            .pattern("###")
            .ingredient('#', Items.GOLD_NUGGET)
            .ingredient('X', Items.BEETROOT)
            .criterion("has_gold_nugget", conditionsFromItem(Items.GOLD_NUGGET))
            .offerTo(exporter)


    }
}