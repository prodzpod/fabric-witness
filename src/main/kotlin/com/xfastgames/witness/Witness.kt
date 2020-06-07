package com.xfastgames.witness

import com.xfastgames.witness.blocks.drapes.BlueBougainvilleaDrape
import com.xfastgames.witness.blocks.drapes.PurpleBougainvilleaDrape
import com.xfastgames.witness.blocks.flowers.JasmineBush
import com.xfastgames.witness.blocks.flowers.MimosaBush
import com.xfastgames.witness.blocks.leaves.OakLeavesRunners
import com.xfastgames.witness.blocks.leaves.PinkCedarLeaves
import com.xfastgames.witness.blocks.logs.CedarLog
import com.xfastgames.witness.blocks.stained.stone.bricks.*
import com.xfastgames.witness.blocks.yucca.TallYucca
import com.xfastgames.witness.blocks.yucca.Yucca
import com.xfastgames.witness.feature.JasmineBushFeature
import com.xfastgames.witness.feature.MimosaBushFeature
import com.xfastgames.witness.feature.PinkCedarTreeFeature
import com.xfastgames.witness.feature.YuccaFeature
import com.xfastgames.witness.utils.registerBlock
import com.xfastgames.witness.utils.registerFeature
import net.fabricmc.api.ModInitializer
import net.minecraft.client.render.RenderLayer

internal const val WITNESS_ID = "witness"

class Witness : ModInitializer {
    override fun onInitialize() {
        registerBlock(StainedStoneBricks.BLOCK, "yellow_stained_stone_bricks")
        registerBlock(StainedStoneStairs.BLOCK, "yellow_stained_stone_bricks_stairs")
        registerBlock(StainedStoneSlabs.BLOCK, "yellow_stained_stone_bricks_slabs")
        registerBlock(StainedStoneWall.BLOCK, "yellow_stained_stone_bricks_walls")
        registerBlock(StainedStoneButton.BLOCK, "yellow_stained_stone_bricks_button")
        registerBlock(OakLeavesRunners.BLOCK, "oak_leaves_runners", RenderLayer.getTranslucent())
        registerBlock(Yucca.BLOCK, "yucca", RenderLayer.getCutout())
        registerBlock(TallYucca.BLOCK, "tall_yucca", RenderLayer.getCutout())
        registerBlock(JasmineBush.BLOCK, "jasmine_bush", RenderLayer.getCutout())
        registerBlock(MimosaBush.BLOCK, "mimosa_bush", RenderLayer.getCutout())
        registerBlock(PurpleBougainvilleaDrape.BLOCK, "purple_bougainvillea", RenderLayer.getCutout())
        registerBlock(BlueBougainvilleaDrape.BLOCK, "blue_bougainvillea", RenderLayer.getCutout())
        registerBlock(PinkCedarLeaves.BLOCK, "pink_cedar_leaves", RenderLayer.getCutout())
        registerBlock(CedarLog.BLOCK, "cedar_log")
        registerFeature("yucca_growth", YuccaFeature())
        registerFeature("jasmine_bush_growth", JasmineBushFeature())
        registerFeature("mimosa_bush_growth", MimosaBushFeature())
        registerFeature("pink_cedar_trees", PinkCedarTreeFeature())
    }
}