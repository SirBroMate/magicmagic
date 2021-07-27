package ru.sirbromate.magicmagic.init;

import net.fabricmc.fabric.mixin.biome.BuiltinBiomesAccessor;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.world.biomes.FiredForestBiome;
import ru.sirbromate.magicmagic.world.biomes.FrozenSpruceForestBiome;

public class ModBiomes {
    public static final Biome FROZEN_FOREST = FrozenSpruceForestBiome.createFrozenForest();
    public static final Biome FROZEN_DEAD_PLAINS = FrozenSpruceForestBiome.createDeadPlains();
    public static final Biome BURNED_FOREST = FiredForestBiome.createBurnedForestBiome();

    private static final RegistryKey<Biome> FROZEN_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, Main.locate("frozenforest"));
    private static final RegistryKey<Biome> FROZEN_DEAD_PLAINS_KEY = RegistryKey.of(Registry.BIOME_KEY, Main.locate("frozendeadplains"));
    private static final RegistryKey<Biome> BURNED_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, Main.locate("burnedforest"));


    public static void init() {
        Registry.register(BuiltinRegistries.BIOME, FROZEN_FOREST_KEY.getValue(), FROZEN_FOREST);
        BuiltinBiomesAccessor.getBY_RAW_ID().put(BuiltinRegistries.BIOME.getRawId(FROZEN_FOREST), FROZEN_FOREST_KEY);

        Registry.register(BuiltinRegistries.BIOME, FROZEN_DEAD_PLAINS_KEY.getValue(), FROZEN_DEAD_PLAINS);
        BuiltinBiomesAccessor.getBY_RAW_ID().put(BuiltinRegistries.BIOME.getRawId(FROZEN_DEAD_PLAINS), FROZEN_DEAD_PLAINS_KEY);

        Registry.register(BuiltinRegistries.BIOME, BURNED_FOREST_KEY.getValue(), BURNED_FOREST);
        BuiltinBiomesAccessor.getBY_RAW_ID().put(BuiltinRegistries.BIOME.getRawId(BURNED_FOREST), BURNED_FOREST_KEY);
    }
}
