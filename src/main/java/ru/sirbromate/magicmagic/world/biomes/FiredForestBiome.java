package ru.sirbromate.magicmagic.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.NopeSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import ru.sirbromate.magicmagic.init.ModSurfaceBuilders;
import ru.sirbromate.magicmagic.world.biomes.surfacebuilder.CliffSBConfig;
import ru.sirbromate.magicmagic.world.features.ModConfiguredFeatures;

public class CliffsBiome {

    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CLIFF = ModSurfaceBuilders.CLIFF.withConfig(SurfaceBuilder.STONE_CONFIG);


    public static Biome createCliffBiome() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(CLIFF);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.FOREST)
                .depth(-1.25F)
                .scale(4.0F)
                .temperature(0.2F)
                .downfall(1.6F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x15619f)
                        .waterFogColor(0x092b47)
                        .foliageColor(0x004c69)
                        .grassColor(0x0c4f14)
                        .fogColor(0x000000)
                        .skyColor(0x000000)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
}