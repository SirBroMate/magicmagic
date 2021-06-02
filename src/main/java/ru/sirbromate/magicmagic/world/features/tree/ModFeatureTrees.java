package ru.sirbromate.magicmagic.world.features.tree;

import net.minecraft.block.Block;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import ru.sirbromate.magicmagic.init.ModBlocks;

public class ModFeatureTrees {
    public static final TreeFeatureConfig FROZEN_SPRUCE_CONFIG = giantSpruce(ModBlocks.FROZEN_SPRUCE_LOG, ModBlocks.FROZEN_SPRUCE_LEAVES, ModBlocks.FROZEN_SAPLING);


private static TreeFeatureConfig giantSpruce(Block trunk, Block leaves, Block sapling) {
    return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(trunk.getDefaultState()),
            new GiantTrunkPlacer(13, 2, 14),
            new SimpleBlockStateProvider(leaves.getDefaultState()),
            new SimpleBlockStateProvider(sapling.getDefaultState()),
            new MegaPineFoliagePlacer(ConstantIntProvider.create(0),
            ConstantIntProvider.create(0), UniformIntProvider.create(3, 7)),
            new TwoLayersFeatureSize(1, 1, 2))
            .build();
    }
}
