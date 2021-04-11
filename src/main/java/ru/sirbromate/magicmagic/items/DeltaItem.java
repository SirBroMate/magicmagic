package ru.sirbromate.magicmagic.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import ru.sirbromate.magicmagic.init.ModItems;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

public class DeltaItem extends Item {
    public DeltaItem() {
        super(new FabricItemSettings()
        .group(ModItemGroup.MAGICMAGIC_IG));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        ItemStack itemStack = entity.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (item == ModItems.ELETRODELTA) {
            entity.damage(DamageSource.LIGHTNING_BOLT, 5);
        } else if (item == ModItems.FIREDELTA) {
            entity.setFireTicks(40);
        } else if (item == ModItems.WATERDELTA) {
            entity.damage(DamageSource.DROWN, 5);
        } else if (item == ModItems.MAGIC_DELTA) {
            entity.damage(DamageSource.MAGIC, 5);
        }

        if (!entity.isCreative()) {
            itemStack.decrement(1);
        }
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, entity.getStackInHand(hand));
    }
}
