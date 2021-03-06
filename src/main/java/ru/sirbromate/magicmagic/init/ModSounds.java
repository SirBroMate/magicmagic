package ru.sirbromate.magicmagic.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;

public class ModSounds {
    public static final SoundEvent SLURP = register("player", "slurp");
    public static final SoundEvent COLD_AMBIENT = register("ambient", "cold_ambient");
    public static final SoundEvent THUNDER_AMBIUENT = register("ambient", "thunder");

    public static void init() {
    }

    private static SoundEvent register(String type, String id) {
        id = "magicmagic." + type + "." + id;
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(makeID(id)));
    }

    public static Identifier makeID(String path) {
        return Main.locate(path);
    }
}
