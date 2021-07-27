package ru.sirbromate.magicmagic.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import ru.sirbromate.magicmagic.init.ModSurfaceBuilders;
import ru.sirbromate.magicmagic.world.features.ModConfiguredFeatures;

public class FiredForestBiome {
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> FIRE = ModSurfaceBuilders.FIREGROUND.withConfig(SurfaceBuilder.GRASS_CONFIG);


    public static Biome createBurnedForestBiome() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(FIRE);

        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
        DefaultBiomeFeatures.addForestGrass(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        ModConfiguredFeatures.addBurnedTree(generationSettings);
        ModConfiguredFeatures.addFallenTree(generationSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.FOREST)
                .depth(0.0F)
                .scale(0.05F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x050533)
                        .foliageColor(0x636d5c)
                        .grassColor(0x636d5c)
                        .fogColor(0x9E8994)
                        .skyColor(0x9E8994)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
}