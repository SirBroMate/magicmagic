package ru.sirbromate.magicmagic.init;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.enchs.ReversePowerEnchantment;

public class ModEnchantments {

    private static final Enchantment REVERSE_POWER = Registry.register(Registry.ENCHANTMENT, Main.locate("reversepower"), new ReversePowerEnchantment());

    public static void init() {

    }
}
