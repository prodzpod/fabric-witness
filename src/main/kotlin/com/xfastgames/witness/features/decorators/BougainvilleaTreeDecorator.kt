package com.xfastgames.witness.features.decorators

import com.xfastgames.witness.blocks.decorations.BlueBougainvilleaDrape
import com.xfastgames.witness.blocks.decorations.Drape
import com.xfastgames.witness.blocks.decorations.DrapePart
import com.xfastgames.witness.blocks.decorations.PurpleBougainvilleaDrape
import com.xfastgames.witness.utils.neighbours
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.LeavesBlock
import net.minecraft.util.math.BlockBox
import net.minecraft.util.math.BlockPos
import net.minecraft.world.StructureWorldAccess
import net.minecraft.world.TestableWorld
import net.minecraft.world.gen.treedecorator.TreeDecorator
import net.minecraft.world.gen.treedecorator.TreeDecoratorType
import java.util.*
import java.util.function.BiConsumer
import kotlin.random.asKotlinRandom

class BougainvilleaTreeDecorator : TreeDecorator() {

    override fun generate(
        world: TestableWorld?,
        replacer: BiConsumer<BlockPos, BlockState>?,
        random: Random?,
        logPositions: MutableList<BlockPos>?,
        leavesPositions: MutableList<BlockPos>?
    ) {
        TODO("1.17 sucks :(")
//        logPositions?.toList()
//            ?.reversed()
//            // Generate the root on the first non leave adjacent log
//            ?.firstOrNull { blockPos ->
//                blockPos.neighbours.dropLast(2).any { world.getBlockState(it).block !is LeavesBlock }
//            }
//            ?.let { logPosition ->
//                // Choose random color
//                val drape: Block = listOf(PurpleBougainvilleaDrape.BLOCK, BlueBougainvilleaDrape.BLOCK)
//                    .random(random!!.asKotlinRandom())
//
//                logPosition.neighbours.dropLast(2) // don't consider neighbours above and below
//                    .filter { neighbour -> neighbour !in logPositions }
//                    .forEach { neighbour ->
//                        // Generate 75% of the time
//                        if (random.nextDouble() > 0.75) return
//
//                        // Start with top
//                        world.setBlockState(
//                            neighbour,
//                            drape.defaultState.with(Drape.PART, DrapePart.TOP),
//                            0
//                        )
//
//                        // Grow the root randomly upto length of 3
//                        var downPos: BlockPos = neighbour
//                    var downBlockState: BlockState
//                    repeat(random.nextInt(5)) {
//                        downPos = neighbour.down()
//                        downBlockState = world.getBlockState(downPos)
//                        if (downBlockState.isAir) world.setBlockState(
//                            downPos,
//                            drape.defaultState.with(Drape.PART, DrapePart.MIDDLE),
//                            0
//                        )
//                    }
//
//                    val positionAboveLowest: BlockPos = downPos.up()
//                    val blockStateAboveLowest: BlockState = world.getBlockState(positionAboveLowest)
//
//                    // Change lowers to the right part, if the one above is a drape
//                    if (blockStateAboveLowest.block is Drape)
//                        world.setBlockState(
//                            downPos,
//                            drape.defaultState.with(Drape.PART, DrapePart.LOWER),
//                            0
//                        )
//
//                    // If lowest part is the same as top, it must be a leaf
//                    if (neighbour == downPos)
//                        world.setBlockState(
//                            downPos,
//                            drape.defaultState,
//                            0
//                        )
//                }
//        }
    }

    override fun getType(): TreeDecoratorType<*> = TreeDecoratorType.TRUNK_VINE
}