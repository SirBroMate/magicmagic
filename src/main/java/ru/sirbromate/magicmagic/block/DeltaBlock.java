package ru.sirbromate.magicmagic.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class DeltaBlock extends Block {
    public DeltaBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .strength(3.8F)
                .sounds(BlockSoundGroup.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 2)
                .requiresTool());
    }
}
