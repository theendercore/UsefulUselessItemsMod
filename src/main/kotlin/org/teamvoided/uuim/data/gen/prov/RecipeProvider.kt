package org.teamvoided.uuim.data.gen.prov

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.CookingRecipeJsonFactory
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory
import net.minecraft.item.Items
import net.minecraft.recipe.*
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

        CookingRecipeJsonFactory.createSmelting(
            Ingredient.ofItems(Items.EGG), RecipeCategory.FOOD, UUIItems.COOKED_EGG, 0.35f, 200
        )
            .criterion("has_egg", conditionsFromItem(Items.EGG))
            .offerTo(exporter)
        myCookingRecipes( exporter, "smoking", RecipeSerializer.SMOKING, ::SmokingRecipe, 100)

        ShapedRecipeJsonFactory.create(RecipeCategory.TOOLS, Items.BUNDLE)
            .pattern("#I#")
            .pattern("# #")
            .pattern("###")
            .ingredient('#', Items.RABBIT_HIDE)
            .ingredient('I', Items.IRON_INGOT)
            .criterion("has_rabbit_hide", conditionsFromItem(Items.RABBIT_HIDE))
            .offerTo(exporter)
    }

    private fun <T : AbstractCookingRecipe> myCookingRecipes(
        exporter: RecipeExporter, cooker: String, serializer: RecipeSerializer<T>,
        recipe: AbstractCookingRecipe.Factory<T>, cookingTime: Int
    ) {
        offerCookingRecipe(exporter, cooker, serializer, recipe, cookingTime, Items.EGG, UUIItems.COOKED_EGG, 0.35f)
    }
}