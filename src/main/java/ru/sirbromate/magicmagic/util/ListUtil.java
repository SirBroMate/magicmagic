package ru.sirbromate.magicmagic.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.List;

public class ListUtil {
    public static List<BlockState> dirtBlocks = List.of(
            Blocks.DIRT.getDefaultState(),
            Blocks.COARSE_DIRT.getDefaultState(),
            Blocks.MYCELIUM.getDefaultState());
}
