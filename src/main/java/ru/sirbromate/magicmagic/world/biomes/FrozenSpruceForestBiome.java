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
import ru.sirbromate.magicmagic.init.ModSounds;
import ru.sirbromate.magicmagic.world.features.ModConfiguredFeatures;

public class FrozenSpruceForestBiome {
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> FROZEN_SURFACE_BUILDER =
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    Blocks.COARSE_DIRT.getDefaultState(),
                    Blocks.DIRT.getDefaultState(),
                    Blocks.BLUE_ICE.getDefaultState()));

    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> FROZEN_GRASS_SURFACE_BUILDER =
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    Blocks.GRASS_BLOCK.getDefaultState(),
                    Blocks.DIRT.getDefaultState(),
                    Blocks.BLUE_ICE.getDefaultState()));


    public static Biome createFrozenForest() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(FROZEN_GRASS_SURFACE_BUILDER);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
        DefaultBiomeFeatures.addIcebergs(generationSettings);
        ModConfiguredFeatures.addFrozenTree(generationSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.SNOW)
                .category(Biome.Category.FOREST)
                .depth(0.425F)
                .scale(0.20F)
                .temperature(-2.0F)
                .downfall(2.2F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x1d4362)
                        .waterFogColor(0x1d4362)
                        .foliageColor(0x2b4c3f)
                        .grassColor(0x2b311b)
                        .fogColor(0x000000)
                        .skyColor(0x000000)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WHITE_ASH, 0.03825F))
                        .loopSound(ModSounds.COLD_AMBIENT)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 5000, 2, 16))
                        .additionsSound(new BiomeAdditionsSound(ModSounds.THUNDER_AMBIUENT, 0.0085D))
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    public static Biome createDeadPlains() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(FROZEN_SURFACE_BUILDER);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.SNOW)
                .category(Biome.Category.PLAINS)
                .depth(0.05F)
                .scale(0.04F)
                .temperature(-2.0F)
                .downfall(1.0F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x1d4362)
                        .waterFogColor(0x1d4362)
                        .foliageColor(0x2b4c3f)
                        .grassColor(0x2b311b)
                        .fogColor(0x000000)
                        .skyColor(0x000000)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WHITE_ASH, 0.07825F))
                        .loopSound(ModSounds.COLD_AMBIENT)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 2, 16))
                        .additionsSound(new BiomeAdditionsSound(ModSounds.THUNDER_AMBIUENT, 0.0045D))
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
}