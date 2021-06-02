package ru.sirbromate.magicmagic.items;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.sirbromate.magicmagic.init.ModTags;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

import java.util.List;

public class ElectroDeltaPick extends PickaxeItem {
    public ElectroDeltaPick() {
        super(ModToolMaterials.DELTA,
                3,
                -2.8F,
                new Settings().group(ModItemGroup.MAGICMAGIC_IG));
    }


    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return ModToolMaterials.DELTA.getMiningSpeedMultiplier() * 2;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.magicmagic.electrodeltapick.dest"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
