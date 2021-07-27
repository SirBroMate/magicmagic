package ru.sirbromate.magicmagic.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import ru.sirbromate.magicmagic.init.ModBlocks;

import java.util.Random;

public class FallenTreeFeature extends Feature<DefaultFeatureConfig> {
    public FallenTreeFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        Random random = new Random();
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();

        int size = random.nextInt(12) + 3;
        int distance = random.nextInt(6) > 1 ? 1 : 2;

        BlockPos trunkTopPos = world.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos);
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        BlockPos start = world.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos.offset(direction, distance));

        if (!world.getBlockState(trunkTopPos).getMaterial().isReplaceable() || world.getBlockState(trunkTopPos.down()).isOf(Blocks.GRASS_BLOCK)) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            BlockPos.Mutable temp = start.offset(direction, i).mutableCopy();

            if (world.getBlockState(temp).getMaterial().isReplaceable()) {
                world.setBlockState(temp, ModBlocks.BURNED_LOG.getDefaultState().with(PillarBlock.AXIS, direction.getAxis()), 3);
                if (world.getBlockState(temp.up()).getMaterial().isReplaceable()) {
                    world.setBlockState(temp.up(), Blocks.AIR.getDefaultState(), 3);
                }
            } else {
                break;
            }
        }
        return true;
    }
}