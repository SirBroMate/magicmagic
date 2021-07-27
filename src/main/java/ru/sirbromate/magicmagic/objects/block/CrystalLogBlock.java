package ru.sirbromate.magicmagic.objects.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.BlockSoundGroup;

public class CrystalLogBlock extends PillarBlock {
    public CrystalLogBlock() {
        super(FabricBlockSettings.of(Material.GLASS)
                .breakByTool(FabricToolTags.PICKAXES)
                .strength(7.0F)
                .breakByHand(false)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()
                .luminance(5));
    }
}
