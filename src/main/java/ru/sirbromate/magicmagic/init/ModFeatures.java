package ru.sirbromate.magicmagic.init;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.world.features.FallenTreeFeature;


public class ModFeatures {
    private static final Feature<DefaultFeatureConfig> FALLEN_TREE = new FallenTreeFeature(DefaultFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> FALEED_TREE_CONFIG = FALLEN_TREE.configure(FeatureConfig.DEFAULT).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(32)));

    public static void init() {
        Registry.register(Registry.FEATURE, Main.locate("fallen_tree"), FALLEN_TREE);
        RegistryKey<ConfiguredFeature<?, ?>> FALLEN_TREE = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, Main.locate("fallen_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, FALLEN_TREE.getValue(), FALEED_TREE_CONFIG);
    }
}
