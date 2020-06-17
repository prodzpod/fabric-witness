package com.xfastgames.witness.blocks.yucca

import com.xfastgames.witness.Witness
import com.xfastgames.witness.utils.Clientside
import com.xfastgames.witness.utils.registerBlock
import com.xfastgames.witness.utils.registerBlockItem
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.block.BlockState
import net.minecraft.client.render.RenderLayer
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import java.util.*

class TallYucca : Yucca(), Clientside {

    companion object {
        val IDENTIFIER = Identifier(Witness.IDENTIFIER, "tall_yucca")
        val BLOCK = registerBlock(TallYucca(), IDENTIFIER)
        val BLOCK_ITEM = registerBlockItem(BLOCK, IDENTIFIER)
    }

    override fun grow(world: ServerWorld, random: Random?, pos: BlockPos, state: BlockState) {
        dropStack(world, pos, ItemStack(Yucca.BLOCK))
    }

    override fun onClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BLOCK, RenderLayer.getCutout())
    }
}