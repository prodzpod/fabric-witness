package com.xfastgames.witness.mixin.utils

import net.minecraft.client.Mouse
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.gen.Accessor

@Mixin(Mouse::class)
interface MouseAccessorMixin {
    @get:Accessor("cursorLocked")
    @set:Accessor("cursorLocked")
    var cursorLocked: Boolean
}