package ru.sirbromate.magicmagic.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import ru.sirbromate.magicmagic.entity.BrimBallProjectile;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

public class BrimBallItem extends Item {
    public BrimBallItem() {
        super(new FabricItemSettings().maxCount(16)
                .group(ModItemGroup.MAGICMAGIC_IG));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        ItemStack itemStack = entity.getStackInHand(hand);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

        entity.getItemCooldownManager().set(this, 5);

        if (!world.isClient) {
            BrimBallProjectile brimBall = new BrimBallProjectile(world, entity);
            brimBall.setItem(itemStack);
            brimBall.setProperties(entity, entity.prevPitch, entity.prevYaw, 0.0F, 1.5F, 0F);
            world.spawnEntity(brimBall);
        }

        entity.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!entity.isCreative()) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
