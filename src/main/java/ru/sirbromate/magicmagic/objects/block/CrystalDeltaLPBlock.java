package ru.sirbromate.magicmagic.objects.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;


public class CrystalDeltaLPBlock extends Block {
    public CrystalDeltaLPBlock() {
        super(FabricBlockSettings.of(Material.GLASS)
                .strength(2.0F)
                .sounds(BlockSoundGroup.GLASS)
                .breakByTool(FabricToolTags.PICKAXES, 2)
                .luminance(7)
                .blockVision(CrystalDeltaLPBlock::never)
                .nonOpaque());
    }

    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }
}
