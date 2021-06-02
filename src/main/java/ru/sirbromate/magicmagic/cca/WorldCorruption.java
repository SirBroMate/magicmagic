package ru.sirbromate.magicmagic.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;

import ru.sirbromate.magicmagic.Main;

public class WorldCorruption implements WorldComponentInitializer {
    public static final ComponentKey<WorldCorruptionCompnent> CORRUPTION = ComponentRegistryV3.INSTANCE.getOrCreate(Main.locate("corruption"), WorldCorruptionCompnent.class);

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(CORRUPTION, WorldCorruptionCompnent::new);
    }

}
