package ru.sirbromate.magicmagic.mixin;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.sirbromate.magicmagic.world.DeltaStoneWorldGen;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeatureMixin {
    @Inject(method = "addDefaultOres(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at = @At("TAIL"))
    private static void addDefaultOres(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, DeltaStoneWorldGen.MAGIC_DELTA_STONE_GEN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, DeltaStoneWorldGen.FIRE_DELTA_STONE_GEN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, DeltaStoneWorldGen.ELECTRO_DELTA_STONE_GEN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, DeltaStoneWorldGen.WATER_DELTA_STONE_GEN);
    }
}