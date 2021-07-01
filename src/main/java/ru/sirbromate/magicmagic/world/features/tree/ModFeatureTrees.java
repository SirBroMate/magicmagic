package ru.sirbromate.magicmagic.world.features.tree;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.init.ModBlocks;

public class ModFeatureTrees {
    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String string, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Main.locate(string), feature);
    }

    // Decorators in ConfiguredFeatures are protected so I just make own heightmap here
    public static ConfiguredDecorator<HeightmapDecoratorConfig> HEIGHTMAP = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING));
    public static ConfiguredDecorator<?> SQUARE_HEIGHTMAP = HEIGHTMAP.spreadHorizontally();



    public static final TreeFeatureConfig FROZEN_SPRUCE_CONFIG = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.FROZEN_SPRUCE_LOG.getDefaultState()),
            new GiantTrunkPlacer(20, 3, 21),
            new SimpleBlockStateProvider(ModBlocks.FROZEN_SPRUCE_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.FROZEN_SAPLING.getDefaultState()),
            new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 7)),
            new TwoLayersFeatureSize(1, 1, 2))
            .build();

    public static final ConfiguredFeature<TreeFeatureConfig, ?> FROZEN_SPRUCE = register("frozen_spruce", Feature.TREE.configure(ModFeatureTrees.FROZEN_SPRUCE_CONFIG));
    public static final ConfiguredFeature<?, ?> FROZEN_TREES = register("frozen_spruces", FROZEN_SPRUCE.decorate(SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(32, 0.2F, 8))));

}
