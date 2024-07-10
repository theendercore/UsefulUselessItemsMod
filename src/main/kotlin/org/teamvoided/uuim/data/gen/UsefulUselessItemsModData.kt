package org.teamvoided.uuim.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistrySetBuilder
import org.teamvoided.uuim.UsefulUselessItemsMod.log
import org.teamvoided.uuim.data.gen.prov.EnLangProvider
import org.teamvoided.uuim.data.gen.prov.LootTableProvider
import org.teamvoided.uuim.data.gen.prov.ModelProvider
import org.teamvoided.uuim.data.gen.prov.RecipeProvider

@Suppress("unused")
class UsefulUselessItemsModData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        pack.addProvider(::ModelProvider)
        pack.addProvider(::EnLangProvider)
        pack.addProvider(::RecipeProvider)
        pack.addProvider(::LootTableProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, TemplateBiomes::boostrap)
    }
}
