package ru.sirbromate.magicmagic.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class RainbowBricksBlock extends Block {
    public RainbowBricksBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .strength(1.5F, 300.0F)
                .luminance(15)
                .breakByHand(false)
                .breakByTool(FabricToolTags.PICKAXES, 0));
    }
}