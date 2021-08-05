package ru.sirbromate.magicmagic.init;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import ru.sirbromate.magicmagic.Main;


public class ModTags {
    public static final Tag<Block> DELTAS_TAG = TagRegistry.block(Main.locate("deltas"));
    public static final Tag<Block> FIREDELTA_TAG = TagRegistry.block(Main.locate("firedeltas"));
    public static final Tag<Block> ELECTRODELTA_TAG = TagRegistry.block(Main.locate("electrodeltas"));
    public static final Tag<Block> WATERDELTA_TAG = TagRegistry.block(Main.locate("waterdeltas"));
    public static final Tag<Block> MAGICDELTA_TAG = TagRegistry.block(Main.locate("magicdeltas"));

    public static void init() {
    }
}
