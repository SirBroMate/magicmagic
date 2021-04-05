package ru.sirbromate.magicmagic;

import net.fabricmc.api.ModInitializer;
import ru.sirbromate.magicmagic.init.ModEnchanments;
import ru.sirbromate.magicmagic.init.ModItems;
import ru.sirbromate.magicmagic.init.ModSounds;
import ru.sirbromate.magicmagic.init.ModStatusEffect;

public class Main implements ModInitializer {
    public static String MODID = "magicmagic";

    @Override
    public void onInitialize() {
        ModItems.init();
        ModSounds.init();
        ModEnchanments.init();
        ModStatusEffect.init();
    }
}
