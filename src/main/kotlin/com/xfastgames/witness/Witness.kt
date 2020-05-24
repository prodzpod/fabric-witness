package com.xfastgames.witness

import com.xfastgames.witness.blocks.flowers.JasmineBush
import com.xfastgames.witness.blocks.flowers.MimosaBush
import com.xfastgames.witness.blocks.leaves.OakLeavesRunners
import com.xfastgames.witness.blocks.stained.stone.bricks.*
import com.xfastgames.witness.blocks.yucca.Yucca
import com.xfastgames.witness.feature.JasmineBushFeature
import com.xfastgames.witness.feature.YuccaFeature
import com.xfastgames.witness.utils.registerBlock
import com.xfastgames.witness.utils.registerFeature
import net.fabricmc.api.ModInitializer
import net.minecraft.block.Blocks
import net.minecraft.client.render.RenderLayer
import net.minecraft.world.gen.GenerationStep

internal const val WITNESS_ID = "witness"

class Witness : ModInitializer {
    override fun onInitialize() {
        registerBlock(StainedStoneBricks(), "yellow_stained_stone_bricks")
        registerBlock(StainedStoneStairs(Blocks.BRICK_STAIRS.defaultState), "yellow_stained_stone_bricks_stairs")
        registerBlock(StainedStoneSlabs(), "yellow_stained_stone_bricks_slabs")
        registerBlock(StainedStoneWall(), "yellow_stained_stone_bricks_walls")
        registerBlock(StainedStoneButton(), "yellow_stained_stone_bricks_button")
        registerBlock(OakLeavesRunners(), "oak_leaves_runners", RenderLayer.getTranslucent())
        registerBlock(Yucca, "yucca", RenderLayer.getTranslucent())
        registerBlock(JasmineBush, "jasmine_bush", RenderLayer.getCutout())
        registerBlock(MimosaBush, "mimosa_bush", RenderLayer.getCutout())
        registerFeature("yucca_growth", YuccaFeature(), GenerationStep.Feature.VEGETAL_DECORATION)
        registerFeature("jasmine_bush_growth", JasmineBushFeature(), GenerationStep.Feature.VEGETAL_DECORATION)
    }
}