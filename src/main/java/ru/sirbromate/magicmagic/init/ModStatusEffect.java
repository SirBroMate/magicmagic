package ru.sirbromate.magicmagic.init;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.statuseffects.BrimPosionStatusEffect;

public class ModStatusEffect {
    public static final StatusEffect BRIM = new BrimPosionStatusEffect();

    public static void init() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Main.MODID, "brim"), BRIM);
    }
}
