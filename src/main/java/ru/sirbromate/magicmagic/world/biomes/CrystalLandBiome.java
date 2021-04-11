package ru.sirbromate.magicmagic.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import ru.sirbromate.magicmagic.world.features.ModConfiguredFeatures;

public class CrystalLandBiome {

    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> FROZEN_GRASS_SURFACE_BUILDER =
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    Blocks.GRASS_BLOCK.getDefaultState(),
                    Blocks.DIRT.getDefaultState(),
                    Blocks.BLUE_ICE.getDefaultState()));


    public static Biome createCrystalFields() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(FROZEN_GRASS_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
        ModConfiguredFeatures.addCrystalSpikes(generationSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.SNOW)
                .category(Biome.Category.FOREST)
                .depth(0.65F)
                .scale(0.30F)
                .temperature(0.5F)
                .downfall(2.2F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x15619f)
                        .waterFogColor(0x092b47)
                        .foliageColor(0x004c69)
                        .grassColor(0x0c4f14)
                        .fogColor(0x2a0a69)
                        .skyColor(0x000000)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.ENCHANTED_HIT, 0.02825F))
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
}