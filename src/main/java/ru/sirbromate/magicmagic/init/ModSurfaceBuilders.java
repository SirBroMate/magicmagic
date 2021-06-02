package ru.sirbromate.magicmagic.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.world.biomes.surfacebuilder.CliffSB;

import java.util.HashMap;
import java.util.Map;

public class ModSurfaceBuilders {
    private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();

    public static final SurfaceBuilder<TernarySurfaceConfig> CLIFF = add("cliff", new CliffSB(TernarySurfaceConfig.CODEC));

    private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S feature) {
        SURFACE_BUILDERS.put(Main.locate(name), feature);
        return feature;
    }

    public static void init() {
        for (Identifier id : SURFACE_BUILDERS.keySet()) {
            Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
        }
    }
}
