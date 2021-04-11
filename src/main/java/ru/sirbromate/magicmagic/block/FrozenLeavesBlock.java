package ru.sirbromate.magicmagic.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class FrozenLeavesBlock extends LeavesBlock {
    public FrozenLeavesBlock() {
        super(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)
                .strength(0.2F)
                .breakByTool(FabricToolTags.HOES)
                .sounds(BlockSoundGroup.CROP)
                .suffocates(FrozenLeavesBlock::never)
                .blockVision(FrozenLeavesBlock::never));
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        world.addParticle(ParticleTypes.CLOUD, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, 0.0F, 0.0F, 0.0F);
        super.onBroken(world, pos, state);
    }
}
