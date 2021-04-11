package ru.sirbromate.magicmagic.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import ru.sirbromate.magicmagic.util.ListUtil;

public class DirtXploderItem extends Item {
    public DirtXploderItem() {
        super(new FabricItemSettings()
                .maxCount(1));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);

        if (ListUtil.dirtBlocks.contains(world.getBlockState(blockPos))) {
            world.createExplosion(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 3.0F, Explosion.DestructionType.BREAK);
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }
}
