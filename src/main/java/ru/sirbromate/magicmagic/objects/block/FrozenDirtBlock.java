package ru.sirbromate.magicmagic.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class FrozenDirtBlock extends Block {
    public FrozenDirtBlock() {
        super(FabricBlockSettings.of(Material.SOIL)
                .strength(1.0F)
                .sounds(BlockSoundGroup.GLASS)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .breakByHand(true));
    }


}
