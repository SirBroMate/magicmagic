package ru.sirbromate.magicmagic.world.biomes.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import ru.sirbromate.magicmagic.init.ModBlocks;

import java.util.Random;

public class FireSB extends SurfaceBuilder<TernarySurfaceConfig> {
    public static BlockState STONE = Blocks.STONE.getDefaultState();
    public static BlockState COBBLESTONE = Blocks.COBBLESTONE.getDefaultState();
    public static BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    public static BlockState GRASS = Blocks.GRASS_BLOCK.getDefaultState();
    public static BlockState DIRT = Blocks.DIRT.getDefaultState();
    public static final TernarySurfaceConfig GRASS_CONFIG = new TernarySurfaceConfig(GRASS, DIRT, GRAVEL);
    public static BlockState ASH = ModBlocks.ASH.getDefaultState();
    public static final TernarySurfaceConfig ASH_CONFIG = new TernarySurfaceConfig(ASH, ASH, GRAVEL);
    public static BlockState MAGMA = Blocks.MAGMA_BLOCK.getDefaultState();
    public static final TernarySurfaceConfig MAGMA_CONFIG = new TernarySurfaceConfig(MAGMA, ASH, GRAVEL);


    public FireSB(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }


    @Override
    public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int i, long l, TernarySurfaceConfig surfaceConfig) {
        if (noise > 0.7) {
            SurfaceBuilder.DEFAULT.generate(random, chunk, biome, x, z, height, noise, defaultBlock, defaultFluid, seaLevel, i, l, GRASS_CONFIG);
        } else if (noise > 0.1 && noise < 0.7) {
            SurfaceBuilder.DEFAULT.generate(random, chunk, biome, x, z, height, noise, defaultBlock, defaultFluid, seaLevel, i, l, MAGMA_CONFIG);
        } else if (noise < 0.1) {
            SurfaceBuilder.DEFAULT.generate(random, chunk, biome, x, z, height, noise, defaultBlock, defaultFluid, seaLevel, i, l, ASH_CONFIG);
        }
    }
}
