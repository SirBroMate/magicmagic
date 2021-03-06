package ru.sirbromate.magicmagic.world.features;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.init.ModBlocks;
import ru.sirbromate.magicmagic.world.features.tree.ModFeatureConfigs;

public class ModConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> FROZEN_SPRUCE = register("frozen_spruce", Feature.TREE.configure(ModFeatureConfigs.FROZEN_SPRUCE_CONFIG));
    public static final ConfiguredFeature<?, ?> FROZEN_FOREST_TREE = register("frozen_forest_tree", FROZEN_SPRUCE.decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(42, 0.6F, 21))));
    public static final ConfiguredFeature<?, ?> CRSTAL_SPIKE = register("crystalspike", ModFeatureConfigs.CRYSTAL_SPIKE_CONFIG.configure(new SingleStateFeatureConfig(ModBlocks.CRYSTAL_DELTA.getDefaultState())).decorate(Decorator.ICEBERG.configure(NopeDecoratorConfig.INSTANCE)).applyChance(1));

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MODID, id), feature);
    }

    public static void addFrozenTree(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, FROZEN_FOREST_TREE);
    }

    public static void addCrystalSpikes(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.SURFACE_STRUCTURES, CRSTAL_SPIKE);
    }
}
