package ru.sirbromate.magicmagic;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import ru.sirbromate.magicmagic.init.*;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;
import ru.sirbromate.magicmagic.world.DeltaStoneWorldGen;

public class Main implements ModInitializer {
    public static String MODID = "magicmagic";

//    public static final Logger logger = LogManager.getLogger(MODID);
    
    public static Identifier locate(String location) {
        return new Identifier(MODID, location);
    }

    @Override
    public void onInitialize() {
        ModItems.init(); // Items
        ModBlocks.init(); // Blocks
        ModSounds.init(); // Sounds
        ModItemGroup.init(); // Creative Tab
        DeltaStoneWorldGen.init(); // Ore gen
        ModTags.init(); // Tags
        ModBiomes.init(); // Biomes
        ModDimensions.init(); // Dimensions
        ModFeatures.init(); // World gen features
        ModEntities.init(); // Entities
        ModStatusEffect.init(); // Status effects
        ModEnchantments.init(); // Enchantments
        ModSurfaceBuilders.init(); // Surface Builders
    }
}
