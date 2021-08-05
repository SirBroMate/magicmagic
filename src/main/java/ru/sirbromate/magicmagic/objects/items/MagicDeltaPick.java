package ru.sirbromate.magicmagic.objects.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

import java.util.List;

public class MagicDeltaPick extends PickaxeItem {
    public MagicDeltaPick() {
        super(ModToolMaterials.DELTA,
                1,
                -2.8F,
                new Settings().group(ModItemGroup.MAGICMAGIC_IG));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        // I dunno why particles is not spawning in postMine method
        if (state == Blocks.OBSIDIAN.getDefaultState() || state == Blocks.CRYING_OBSIDIAN.getDefaultState()) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, 0, 0.1F, 0);
            world.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 0.4F, 2.0F);
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state == Blocks.OBSIDIAN.getDefaultState() || state == Blocks.CRYING_OBSIDIAN.getDefaultState()) {
            return ModToolMaterials.DELTA.getMiningSpeedMultiplier() * 25;
        }
        return ModToolMaterials.DELTA.getMiningSpeedMultiplier();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.magicmagic.magicdeltapick.dest"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
