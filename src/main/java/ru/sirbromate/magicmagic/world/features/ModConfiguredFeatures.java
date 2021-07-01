package ru.sirbromate.magicmagic.world.features;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import ru.sirbromate.magicmagic.world.features.tree.ModFeatureTrees;

public class ModConfiguredFeatures {

    public static void addFrozenTree(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModFeatureTrees.FROZEN_TREES);
    }

}
