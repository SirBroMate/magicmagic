package ru.sirbromate.magicmagic.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.sirbromate.magicmagic.init.ModTags;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

public class ElectroDeltaPick extends PickaxeItem {
    public ElectroDeltaPick() {
        super(ModToolMaterials.DELTA,
                3,
                -2.8F,
                new Settings().group(ModItemGroup.MAGICMAGIC_IG));
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (state.isIn(ModTags.ELECTRODELTA_TAG)) {
            return false;
        }

        return super.canMine(state, world, pos, miner);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return ModToolMaterials.DELTA.getMiningSpeedMultiplier() * 2;
    }
}
