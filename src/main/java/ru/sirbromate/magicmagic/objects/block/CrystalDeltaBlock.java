package ru.sirbromate.magicmagic.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;


public class CrystalDeltaBlock extends Block {
    public CrystalDeltaBlock() {
        super(FabricBlockSettings.of(Material.GLASS)
                .strength(2.0F)
                .sounds(BlockSoundGroup.GLASS)
                .breakByTool(FabricToolTags.PICKAXES, 2)
                .luminance(7));
    }
}
