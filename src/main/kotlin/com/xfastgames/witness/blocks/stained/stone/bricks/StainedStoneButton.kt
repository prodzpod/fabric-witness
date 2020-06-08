package com.xfastgames.witness.blocks.stained.stone.bricks

import com.xfastgames.witness.Witness
import com.xfastgames.witness.blocks.stained.stone.stainedStoneSettings
import com.xfastgames.witness.utils.registerBlock
import com.xfastgames.witness.utils.registerBlockItem
import net.minecraft.block.AbstractButtonBlock
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier

class StainedStoneButton : AbstractButtonBlock(false, stainedStoneSettings) {

    companion object {
        val IDENTIFIER = Identifier(Witness.IDENTIFIER, "yellow_stained_stone_bricks_button")
        val BLOCK = registerBlock(StainedStoneButton(), IDENTIFIER)
        val BLOCK_ITEM = registerBlockItem(BLOCK, IDENTIFIER)
    }

    override fun getClickSound(powered: Boolean): SoundEvent =
        if (powered) SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON
        else SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF
}