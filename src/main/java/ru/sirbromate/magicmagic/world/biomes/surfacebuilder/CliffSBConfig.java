package ru.sirbromate.magicmagic.world.biomes.surfacebuilder;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import ru.sirbromate.magicmagic.init.ModBlocks;

public class CliffSBConfig {
    public static BlockState STONE = Blocks.STONE.getDefaultState();
    public static BlockState COBBLESTONE = Blocks.COBBLESTONE.getDefaultState();
    public static BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    public static BlockState CRYSTAL_DELTA = ModBlocks.CRYSTAL_DELTA.getDefaultState();
    public static BlockState CRYSTAL_DELTA_LP = ModBlocks.CRYSTAL_DELTA_LOWPRESSURE.getDefaultState();

    public static final TernarySurfaceConfig CLIFF_STONE_CONFIG = new TernarySurfaceConfig(COBBLESTONE, STONE, GRAVEL);
    public static final TernarySurfaceConfig CLIFF_CRYSTAL_CONFIG = new TernarySurfaceConfig(CRYSTAL_DELTA_LP, CRYSTAL_DELTA, GRAVEL);
    public static final TernarySurfaceConfig CLIFF_UNDERSEALEVEL = new TernarySurfaceConfig(CRYSTAL_DELTA_LP, CRYSTAL_DELTA, CRYSTAL_DELTA_LP);

}
