package ru.sirbromate.magicmagic.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;

public class ModSounds {
    public static final SoundEvent SLURP = register("player", "slurp");

    public static void register() {
    }

    private static SoundEvent register(String type, String id) {
        id = "magicmagic." + type + "." + id;
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(makeID(id)));
    }

    public static Identifier makeID(String path) {
        return new Identifier(Main.MODID, path);
    }
}
