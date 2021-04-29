package ru.sirbromate.magicmagic.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.cca.WorldCorruption;

@Environment(EnvType.CLIENT)
@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @Unique
    private static final Identifier CURSED_MOON_PHASES = Main.locate("textures/environment/cursed_moon_phases.png");

    @Unique
    private static final Identifier BLOODY_MOON_PHASES = Main.locate("textures/environment/bloody_moon_phases.png");

    @Unique
    private static final Identifier CORRUPTED_MOON_PHASES = Main.locate("textures/environment/corrupted_moon_phases.png");

    @Shadow
    @Final
    private static Identifier MOON_PHASES;
    @Shadow
    @Final
    private TextureManager textureManager;
    @Shadow
    private ClientWorld world;


    @Redirect(method = "renderSky", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/texture/TextureManager;bindTexture(Lnet/minecraft/util/Identifier;)V", ordinal = 1)
    )
    private void redirectMoonTexture(TextureManager textureManager, Identifier id) {
        if ((WorldCorruption.CORRUPTION.get(world).corruptionLevel() >= 10) && (WorldCorruption.CORRUPTION.get(world).corruptionLevel() < 50)) {
            this.textureManager.bindTexture(CURSED_MOON_PHASES);
        } else if ((WorldCorruption.CORRUPTION.get(world).corruptionLevel() >= 50) && (WorldCorruption.CORRUPTION.get(world).corruptionLevel() < 100)) {
            this.textureManager.bindTexture(BLOODY_MOON_PHASES);
        } else if (WorldCorruption.CORRUPTION.get(world).corruptionLevel() >= 100) {
            this.textureManager.bindTexture(CORRUPTED_MOON_PHASES);
        } else {
            this.textureManager.bindTexture(MOON_PHASES);
        }
    }
}