package ru.sirbromate.magicmagic;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sirbromate.magicmagic.init.*;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;
import ru.sirbromate.magicmagic.world.DeltaStoneWorldGen;

public class Main implements ModInitializer {
    public static String MODID = "magicmagic";

    public static Logger log = LogManager.getLogger();

    public static Identifier locate(String location) {
        return new Identifier(MODID, location);
    }

    @Override
    public void onInitialize() {
        ModItems.init();
        ModBlocks.init();
        ModSounds.init();
        ModItemGroup.initialize();
        DeltaStoneWorldGen.initialize();
        ModTags.init();
        ModBiomes.registerBiomes();
        ModDimensions.init();
        ModFeatures.init();
        ModEntities.init();
        ModStatusEffect.init();
    }
}
