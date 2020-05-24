package com.xfastgames.witness.blocks.yucca

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.Fertilizable
import net.minecraft.block.Material
import net.minecraft.block.PlantBlock
import net.minecraft.entity.EntityContext
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import kotlin.random.Random

object Yucca : PlantBlock(FabricBlockSettings.of(Material.LEAVES).nonOpaque()), Fertilizable {
    override fun getOutlineShape(
        state: BlockState?,
        view: BlockView?,
        pos: BlockPos?,
        context: EntityContext?
    ): VoxelShape = VoxelShapes.cuboid(0.3, 0.0, 0.3, 0.7, 0.5, 0.7)

    override fun getCollisionShape(
        state: BlockState?,
        view: BlockView?,
        pos: BlockPos?,
        context: EntityContext?
    ): VoxelShape =
        VoxelShapes.empty()

    override fun getOffsetType(): OffsetType =
        OffsetType.XZ

    override fun getOffsetPos(state: BlockState?, view: BlockView?, blockPos: BlockPos?): Vec3d {
        val seeded = Random(blockPos.hashCode())
        return Vec3d(seeded.nextDouble(0.25), 0.0, seeded.nextDouble(0.25))
    }

    override fun getSoundGroup(state: BlockState?): BlockSoundGroup = BlockSoundGroup.GRASS

    override fun isFertilizable(world: BlockView?, pos: BlockPos?, state: BlockState?, isClient: Boolean): Boolean =
        true

    override fun canGrow(world: World?, random: java.util.Random?, pos: BlockPos?, state: BlockState?): Boolean = true

    override fun grow(world: ServerWorld?, random: java.util.Random?, pos: BlockPos?, state: BlockState?) {
        dropStack(world, pos, ItemStack(this))
    }

    override fun canPlantOnTop(floor: BlockState?, view: BlockView?, pos: BlockPos?): Boolean =
        floor?.isFullCube(view, pos) ?: false
}