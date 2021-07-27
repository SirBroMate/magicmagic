package ru.sirbromate.magicmagic.objects.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CrystalLeavesBlock extends LeavesBlock {
    public CrystalLeavesBlock() {
        super(FabricBlockSettings.copyOf(Blocks.GLASS)
                .strength(1.5F)
                .breakByTool(FabricToolTags.PICKAXES)
                .sounds(BlockSoundGroup.GLASS)
                .suffocates(CrystalLeavesBlock::never)
                .blockVision(CrystalLeavesBlock::never));
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        Item item = itemStack.getItem();

        if (item != FabricToolTags.PICKAXES) {
            player.damage(DamageSource.GENERIC, 1);
        }

        super.onBreak(world, pos, state, player);
    }
}
