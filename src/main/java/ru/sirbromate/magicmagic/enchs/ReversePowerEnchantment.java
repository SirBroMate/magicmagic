package ru.sirbromate.magicmagic.enchs;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class ReversePowerEnchantment extends Enchantment {

    public ReversePowerEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {

        if (target instanceof LivingEntity) {
            float EntityPower = ((LivingEntity) target).getHealth() + ((LivingEntity) target).getArmor();
            float PlayerPower = user.getHealth() + user.getArmor() + user.getActiveItem().getMaxDamage();

            if (PlayerPower < EntityPower) {
                target.damage(DamageSource.GENERIC, (EntityPower / PlayerPower) * level);
            } else {
                ((LivingEntity) target).heal((PlayerPower / EntityPower) * level);
            }

        }

        super.onTargetDamaged(user, target, level);
    }
}