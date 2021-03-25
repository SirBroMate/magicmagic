package ru.sirbromate.magicmagic;

import net.fabricmc.api.ModInitializer;
import ru.sirbromate.magicmagic.init.ModItems;
import ru.sirbromate.magicmagic.init.ModSounds;

public class Main implements ModInitializer {
    public static String MODID = "magicmagic";
    @Override
    public void onInitialize() {
        ModItems.register();
        ModSounds.register();
    }
}
