package ru.sirbromate.magicmagic.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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

public class WaterDeltaPick extends PickaxeItem {
    public WaterDeltaPick() {
        super(ModToolMaterials.DELTA,
                3,
                -2.8F,
                new Settings().group(ModItemGroup.MAGICMAGIC_IG));
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (state.isIn(ModTags.WATERDELTA_TAG)) {
            return false;
        }
        if (state.isIn(BlockTags.FIRE) || (state == Blocks.MAGMA_BLOCK.getDefaultState())) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, 0, 0.1F, 0);
            world.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.2F, 0.3F);

        }
        return super.canMine(state, world, pos, miner);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state == Blocks.MAGMA_BLOCK.getDefaultState()) {
            return ModToolMaterials.DELTA.getMiningSpeedMultiplier() * 4;
        }
        return ModToolMaterials.DELTA.getMiningSpeedMultiplier();
    }

}
