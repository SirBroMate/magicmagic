package ru.sirbromate.magicmagic.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import ru.sirbromate.magicmagic.Main;


public class ModDimensions {
    public static final RegistryKey<World> FROZEN_WORLD = RegistryKey.of(Registry.DIMENSION, Main.locate("frozenworld"));

    public static void init() {
        Registry.register(Registry.CHUNK_GENERATOR, Main.locate("frozenworld"), ChunkGenerator.CODEC);
    }
}