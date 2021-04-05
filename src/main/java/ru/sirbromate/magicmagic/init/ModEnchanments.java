package ru.sirbromate.magicmagic.init;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.enchs.ReversePowerEnchantment;

public class ModEnchanments {

    private static Enchantment REVERSE_POWER = Registry.register(Registry.ENCHANTMENT, new Identifier(Main.MODID, "reversepower"), new ReversePowerEnchantment());

    public static void init() {

    }
}
