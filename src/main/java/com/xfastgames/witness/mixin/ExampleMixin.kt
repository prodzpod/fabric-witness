package com.xfastgames.witness.mixin

import net.minecraft.client.gui.screen.TitleScreen
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(TitleScreen::class) // Mixins HAVE to be written in java due to constraints in the mixin system.
class ExampleMixin {
    @Inject(at = [At("HEAD")], method = ["init()V"])
    private fun init(info: CallbackInfo) {
    }
}