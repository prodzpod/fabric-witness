package com.xfastgames.witness.blocks.building

import com.xfastgames.witness.blocks.decorations.PinkCedarLeaves
import net.minecraft.block.sapling.SaplingGenerator
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize
import net.minecraft.world.gen.foliage.BlobFoliagePlacer
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider
import net.minecraft.world.gen.trunk.StraightTrunkPlacer
import java.util.*

class PinkCedarSaplingGenerator: SaplingGenerator() {
    override fun getTreeFeature(random: Random, bees: Boolean): ConfiguredFeature<TreeFeatureConfig?, *>? {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, "pink_cedar",
            Feature.TREE.configure(
                TreeFeatureConfig.Builder(
                    SimpleBlockStateProvider(PinkCedarLog.BLOCK.defaultState),
                    StraightTrunkPlacer(4, 2, 0),
                    SimpleBlockStateProvider(PinkCedarLeaves.BLOCK.defaultState),
                    SimpleBlockStateProvider(PinkCedarSapling.BLOCK.defaultState),
                    BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build()
            )
        )
    }
}