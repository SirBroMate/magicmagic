package ru.sirbromate.magicmagic.objects.items;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

import java.util.List;

public class FireDeltaPick extends PickaxeItem {
    public FireDeltaPick() {
        super(ModToolMaterials.DELTA,
                1,
                -2.8F,
                new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.isIn(BlockTags.ICE)) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, 0, 0.1F, 0);
            world.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.2F, 0.7F);
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isIn(BlockTags.ICE)) {
            return ModToolMaterials.DELTA.getMiningSpeedMultiplier() * 4;
        }
        return ModToolMaterials.DELTA.getMiningSpeedMultiplier();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.magicmagic.firedeltapick.dest"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
