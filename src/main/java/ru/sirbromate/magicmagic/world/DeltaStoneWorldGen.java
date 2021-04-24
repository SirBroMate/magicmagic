package ru.sirbromate.magicmagic.world;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.init.ModBlocks;

public class DeltaStoneWorldGen {
    public static ConfiguredFeature<?, ?> MAGIC_DELTA_STONE_GEN = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            ModBlocks.MAGICDELTA_STONE.getDefaultState(), // ore block
            6)). // vein size
            rangeOf(16)
            .spreadHorizontally()
            .repeat(2); // number of veins per chunk

    public static ConfiguredFeature<?, ?> FIRE_DELTA_STONE_GEN = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            ModBlocks.FIREDELTA_STONE.getDefaultState(),  // ore block
            6)) // vein size
            .rangeOf(16)
            .spreadHorizontally()
            .repeat(2); // number of veins per chunk

    public static ConfiguredFeature<?, ?> ELECTRO_DELTA_STONE_GEN = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            ModBlocks.ELECTRODELTA_STONE.getDefaultState(),  // ore block
            6)) // vein size
            .rangeOf(16)
            .spreadHorizontally()
            .repeat(2); // number of veins per chunk

    public static ConfiguredFeature<?, ?> WATER_DELTA_STONE_GEN = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            ModBlocks.WATERDELTA_STONE.getDefaultState(),  // ore block
            6)) // vein size
            .rangeOf(16)
            .spreadHorizontally()
            .repeat(2); // number of veins per chunk

    public static void initialize() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Main.locate("magic_delta_stone_gen"), MAGIC_DELTA_STONE_GEN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Main.locate("fire_delta_stone_gen"), FIRE_DELTA_STONE_GEN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Main.locate("electro_delta_stone_gen"), ELECTRO_DELTA_STONE_GEN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Main.locate("water_delta_stone_gen"), WATER_DELTA_STONE_GEN);
    }
}
