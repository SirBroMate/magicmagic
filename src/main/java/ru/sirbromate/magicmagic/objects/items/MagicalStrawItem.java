package ru.sirbromate.magicmagic.objects.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import ru.sirbromate.magicmagic.init.ModSounds;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

public class MagicalStrawItem extends Item {
    public MagicalStrawItem() {
        super(new FabricItemSettings()
                .maxCount(1)
                .group(ModItemGroup.MAGICMAGIC_IG));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getEntityWorld();

        if (!user.getItemCooldownManager().isCoolingDown(this)) {
            entity.damage(DamageSource.DRYOUT, 1);
            user.getItemCooldownManager().set(this, 10);

            world.playSound(user, user.getX(), user.getY(), user.getZ(), ModSounds.SLURP, SoundCategory.PLAYERS, 1.0F, 1.0F);

            if (entity.isUndead()) {
                user.damage(DamageSource.WITHER, 1);
            } else if (entity.getType() == EntityType.CREEPER) {
                world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 2, Explosion.DestructionType.NONE);
            }
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public Text getName(ItemStack stack) {
        return new TranslatableText(this.getTranslationKey(stack)).formatted(Formatting.GREEN);
    }
}
