package ru.sirbromate.magicmagic.objects.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.BlockSoundGroup;

public class FrozenLogBlock extends PillarBlock {
    public FrozenLogBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .breakByTool(FabricToolTags.AXES)
                .strength(4.0F)
                .breakByHand(true)
                .sounds(BlockSoundGroup.STONE));
    }
}
