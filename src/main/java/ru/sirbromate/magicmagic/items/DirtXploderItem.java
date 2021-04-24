package ru.sirbromate.magicmagic.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.sirbromate.magicmagic.cca.WorldCorruption;

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

        if (blockState == Blocks.DIRT.getDefaultState()){
            WorldCorruption.CORRUPTION.get(world).increaseLevel();
        } else if (blockState == Blocks.DIAMOND_BLOCK.getDefaultState()){
            WorldCorruption.CORRUPTION.get(world).decreaseLevel();
        }

        System.out.println(WorldCorruption.CORRUPTION.get(world).corruptionLevel());


        return ActionResult.success(world.isClient);
    }



}
