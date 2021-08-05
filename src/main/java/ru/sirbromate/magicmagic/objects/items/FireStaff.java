package ru.sirbromate.magicmagic.objects.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

import java.util.Random;

public class FireStaff extends Item {
    public FireStaff() {
        super(new FabricItemSettings()
                .maxCount(1)
                .group(ModItemGroup.MAGICMAGIC_IG));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Random random = new Random();
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.1F / (random.nextFloat() * 0.4F + 0.8F));

        for (int i = 0; i < 3; i++) {
            SmallFireballEntity fireballEntity = new SmallFireballEntity(world, user.getX(), user.getY() + 1.0F, user.getZ(), user.getRotationVector().getX(), -4, user.getRotationVector().getZ());
            fireballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 10.0F);
            world.spawnEntity(fireballEntity);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
