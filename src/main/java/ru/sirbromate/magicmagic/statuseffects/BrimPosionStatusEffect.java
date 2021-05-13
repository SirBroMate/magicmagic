package ru.sirbromate.magicmagic.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.sound.SoundEvents;

public class BrimPosionStatusEffect extends StatusEffect {
    public BrimPosionStatusEffect() {
        super(StatusEffectType.HARMFUL, 0xFF1832);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(DamageSource.MAGIC, 3 * (1 + (amplifier / 2))); // 3.5 | 4 | 5 | etc
        entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_STEP, 0.3F, 0.1F);
    }
}