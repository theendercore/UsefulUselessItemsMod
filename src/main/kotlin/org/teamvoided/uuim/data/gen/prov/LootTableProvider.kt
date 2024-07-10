package org.teamvoided.uuim.data.gen.prov

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.registry.HolderLookup
import org.teamvoided.uuim.init.UUIBlocks
import java.util.concurrent.CompletableFuture

class LootTableProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootTableProvider(o, r) {
    override fun generate() {
        addPottedPlantDrops(UUIBlocks.POTTED_TORCHFLOWER)
        addPottedPlantDrops(UUIBlocks.POPPED_PITCHER_PLANT)
    }
}