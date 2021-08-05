package ru.sirbromate.magicmagic.world.features.tree;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.init.ModBlocks;

public class ModFeatureTrees {
    public static final TreeFeatureConfig FROZEN_SPRUCE_CONFIG = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.FROZEN_SPRUCE_LOG.getDefaultState()),
            new GiantTrunkPlacer(20, 3, 21),
            new SimpleBlockStateProvider(ModBlocks.FROZEN_SPRUCE_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.FROZEN_SAPLING.getDefaultState()),
            new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 7)),
            new TwoLayersFeatureSize(1, 1, 2))
            .build();
    public static final TreeFeatureConfig BURNED_TREE_CONFIG = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.BURNED_LOG.getDefaultState()),
            new LargeOakTrunkPlacer(20, 3, 21),
            new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.FROZEN_SAPLING.getDefaultState()),
            new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
            new TwoLayersFeatureSize(0, 0, 0))
            .build();
    public static final ConfiguredFeature<TreeFeatureConfig, ?> FROZEN_SPRUCE = register("frozen_spruce", Feature.TREE.configure(FROZEN_SPRUCE_CONFIG));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> BURNED_TREE = register("burned_tree", Feature.TREE.configure(BURNED_TREE_CONFIG));
    // Decorators in ConfiguredFeatures are protected so I just make own heightmap here
    public static ConfiguredDecorator<HeightmapDecoratorConfig> HEIGHTMAP = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING));
    public static ConfiguredDecorator<?> SQUARE_HEIGHTMAP = HEIGHTMAP.spreadHorizontally();
    public static final ConfiguredFeature<?, ?> FROZEN_TREES = register("frozen_spruces", FROZEN_SPRUCE.decorate(SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(32, 0.2F, 8))));
    public static final ConfiguredFeature<?, ?> BURNED_TREES = register("burned_trees", BURNED_TREE.decorate(SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.05F, 3))));

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String string, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Main.locate(string), feature);
    }
}
