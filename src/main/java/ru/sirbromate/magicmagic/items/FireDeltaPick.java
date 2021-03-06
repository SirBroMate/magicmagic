package ru.sirbromate.magicmagic.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.sirbromate.magicmagic.init.ModTags;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

public class FireDeltaPick extends PickaxeItem {
    public FireDeltaPick() {
        super(ModToolMaterials.DELTA,
                1,
                -2.8F,
                new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG));
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (state.isIn(ModTags.FIREDELTA_TAG)) {
            return false;
        }
        if (state.isIn(BlockTags.ICE)) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, 0, 0.1F, 0);
            world.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.2F, 0.7F);
        }

        return super.canMine(state, world, pos, miner);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isIn(BlockTags.ICE)) {
            return ModToolMaterials.DELTA.getMiningSpeedMultiplier() * 4;
        }
        return ModToolMaterials.DELTA.getMiningSpeedMultiplier();
    }

}
