package ru.sirbromate.magicmagic.objects.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class RainbowCrystalBlock extends Block {
    public RainbowCrystalBlock() {
        super(FabricBlockSettings.of(Material.AMETHYST)
                .breakByTool(FabricToolTags.PICKAXES)
                .breakByHand(false)
                .hardness(4.0F)
                .resistance(10.0F)
                .requiresTool());
    }

}
