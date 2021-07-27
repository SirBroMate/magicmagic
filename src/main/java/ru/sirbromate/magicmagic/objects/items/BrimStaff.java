package ru.sirbromate.magicmagic.objects.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import ru.sirbromate.magicmagic.entity.BrimBallProjectile;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

import java.util.Random;


public class BrimStaff extends Item {
    public BrimStaff() {
        super(new FabricItemSettings()
                .maxCount(1)
                .group(ModItemGroup.MAGICMAGIC_IG));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Random random = new Random();
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_BLAZE_HURT, SoundCategory.NEUTRAL, 0.5F, 0.1F / (random.nextFloat() * 0.4F + 0.8F));
        user.getItemCooldownManager().set(this, 40);

        if (!world.isClient) {
            for (int i = 0; i < 25; i++) {
                BrimBallProjectile brimBall = new BrimBallProjectile(world, user);
                brimBall.setProperties(user, user.prevPitch, user.prevYaw, 0.0F, 3.0F, 5.0F);
                world.spawnEntity(brimBall);
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

}
