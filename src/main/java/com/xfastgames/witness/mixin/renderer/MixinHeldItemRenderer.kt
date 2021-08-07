package com.xfastgames.witness.mixin.renderer

import com.xfastgames.witness.registries.HeldItemRendererRegistryImpl.Companion.getRenderer
import net.minecraft.client.render.item.HeldItemRenderer
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import org.spongepowered.asm.mixin.injection.At
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.network.ClientPlayerEntity
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import com.xfastgames.witness.registries.HeldItemRendererRegistryImpl
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.Inject

@Mixin(HeldItemRenderer::class)
class MixinHeldItemRenderer {
    private fun getActiveItemStack(entity: LivingEntity): ItemStack {
        val itemStack: ItemStack
        itemStack = if (entity.isUsingItem) entity.activeItem else entity.mainHandStack
        return itemStack
    }

    @Inject(
        method = ["renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider\$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"],
        at = [At("HEAD")],
        cancellable = true
    )
    fun fabric_renderItem(
        tickDelta: Float,
        matrices: MatrixStack?,
        vertexConsumers: VertexConsumerProvider.Immediate?,
        player: ClientPlayerEntity,
        light: Int,
        ci: CallbackInfo
    ) {
        val itemStack = getActiveItemStack(player)
        val renderer = getRenderer(itemStack.item)
        if (renderer != null) {
            renderer.renderItem(tickDelta, matrices, vertexConsumers, player, light)
            ci.cancel()
        }
    }
}