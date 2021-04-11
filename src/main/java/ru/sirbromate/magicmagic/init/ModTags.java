package ru.sirbromate.magicmagic.init;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import ru.sirbromate.magicmagic.Main;


public class ModTags {
    public static final Tag<Block> DELTAS_TAG = TagRegistry.block(new Identifier(Main.MODID, "deltas"));
    public static final Tag<Block> FIREDELTA_TAG = TagRegistry.block(new Identifier(Main.MODID, "firedeltas"));

    public static void init() {
    }
}
