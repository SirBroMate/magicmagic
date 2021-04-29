package ru.sirbromate.magicmagic.world.features.tree;

import net.minecraft.block.Block;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import ru.sirbromate.magicmagic.init.ModBlocks;
import ru.sirbromate.magicmagic.world.features.CrystalSpikeFeature;

public class ModFeatureConfigs {
    public static final TreeFeatureConfig FROZEN_SPRUCE_CONFIG = giantSpruce(ModBlocks.FROZEN_SPRUCE_LOG, ModBlocks.FROZEN_SPRUCE_LEAVES);
    public static final Feature<SingleStateFeatureConfig> CRYSTAL_SPIKE_CONFIG = new CrystalSpikeFeature(SingleStateFeatureConfig.CODEC);

    private static TreeFeatureConfig giantSpruce(Block trunk, Block leaves) {
        return new TreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(trunk.getDefaultState()),
                new SimpleBlockStateProvider(leaves.getDefaultState()),
                new SpruceFoliagePlacer(UniformIntDistribution.of(3, 2), UniformIntDistribution.of(0, 3), UniformIntDistribution.of(5, 4)),
                new GiantTrunkPlacer(32, 24, 24),
                new TwoLayersFeatureSize(1, 5, 6)
        ).ignoreVines().build();
    }
}
