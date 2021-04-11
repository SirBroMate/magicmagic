package ru.sirbromate.magicmagic.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.world.features.tree.ModFeatureConfigs;

public class ModFeatures {

    public static void init() {
        Registry.register(Registry.FEATURE, new Identifier(Main.MODID, "crystal_spike"), ModFeatureConfigs.CRYSTAL_SPIKE_CONFIG);
    }
}
