package ru.sirbromate.magicmagic.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.block.*;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;

public class ModBlocks {
    public static Block MAGICDELTA_STONE = new DeltaStoneBlock();
    public static Block MAGICDELTA_BRICKS = new DeltaBricksBlock();
    public static Block FIREDELTA_STONE = new DeltaStoneBlock();
    public static Block FIREDELTA_BRICKS = new DeltaBricksBlock();
    public static Block ELECTRODELTA_STONE = new DeltaStoneBlock();
    public static Block ELECTRODELTA_BRICKS = new DeltaBricksBlock();
    public static Block WATERDELTA_STONE = new DeltaStoneBlock();
    public static Block WATERDELTA_BRICKS = new DeltaBricksBlock();
    public static Block RAINBOWBRICKS = new RainbowBricksBlock();
    public static Block SPARKLING_RAINBOWBRICKS = new RainbowBricksBlock();
    public static Block DELTABLOCK = new DeltaBlock();
    public static Block BOUNCEBLOCK = new BounceBlock();
    public static Block FROZEN_SPRUCE_LEAVES = new FrozenLeavesBlock();
    public static Block FROZEN_SPRUCE_LOG = new FrozenLogBlock();
    public static Block FROZENDIRT = new Block(FabricBlockSettings.of(Material.SOIL).hardness(0.5f).sounds(BlockSoundGroup.GRAVEL).breakByTool(FabricToolTags.SHOVELS));
    public static Block PORTAL_BLOCK = new BlockPortal();
    public static Block CRYSTAL_DELTA = new CrystalDeltaBlock();
    public static Block CRYSTAL_DELTA_LOWPRESSURE = new CrystalDeltaLPBlock();
    
    public static void init() {
        Registry.register(Registry.BLOCK, Main.locate("magicdeltastone"), MAGICDELTA_STONE);
        Registry.register(Registry.BLOCK, Main.locate("magicdeltabricks"), MAGICDELTA_BRICKS);
        Registry.register(Registry.BLOCK, Main.locate("firedeltabricks"), FIREDELTA_BRICKS);
        Registry.register(Registry.BLOCK, Main.locate("firedeltastone"), FIREDELTA_STONE);
        Registry.register(Registry.BLOCK, Main.locate("electrodeltastone"), ELECTRODELTA_STONE);
        Registry.register(Registry.BLOCK, Main.locate("electrodeltabricks"), ELECTRODELTA_BRICKS);
        Registry.register(Registry.BLOCK, Main.locate("waterdeltastone"), WATERDELTA_STONE);
        Registry.register(Registry.BLOCK, Main.locate("waterdeltabricks"), WATERDELTA_BRICKS);
        Registry.register(Registry.BLOCK, Main.locate("rainbow_bricks"), RAINBOWBRICKS);
        Registry.register(Registry.BLOCK, Main.locate("sparkling_rainbow_bricks"), SPARKLING_RAINBOWBRICKS);
        Registry.register(Registry.BLOCK, Main.locate("deltablock"), DELTABLOCK);
        Registry.register(Registry.BLOCK, Main.locate("bounceblock"), BOUNCEBLOCK);
        Registry.register(Registry.BLOCK, Main.locate("frozenspruceleaves"), FROZEN_SPRUCE_LEAVES);
        Registry.register(Registry.BLOCK, Main.locate("frozensprucelog"), FROZEN_SPRUCE_LOG);
        Registry.register(Registry.BLOCK, Main.locate("frozendirt"), FROZENDIRT);
        Registry.register(Registry.BLOCK, Main.locate("blockportal"), PORTAL_BLOCK);
        Registry.register(Registry.BLOCK, Main.locate("crystaldelta"), CRYSTAL_DELTA);
        Registry.register(Registry.BLOCK, Main.locate("crystaldelta_lowpressure"), CRYSTAL_DELTA_LOWPRESSURE);

        // Item blocks
        Registry.register(Registry.ITEM, Main.locate("magicdeltastone"), new BlockItem(MAGICDELTA_STONE, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("magicdeltabricks"), new BlockItem(MAGICDELTA_BRICKS, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("firedeltastone"), new BlockItem(FIREDELTA_STONE, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("firedeltabricks"), new BlockItem(FIREDELTA_BRICKS, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("electrodeltastone"), new BlockItem(ELECTRODELTA_STONE, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("electrodeltabricks"), new BlockItem(ELECTRODELTA_BRICKS, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("waterdeltastone"), new BlockItem(WATERDELTA_STONE, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("waterdeltabricks"), new BlockItem(WATERDELTA_BRICKS, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("rainbow_bricks"), new BlockItem(RAINBOWBRICKS, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("sparkling_rainbow_bricks"), new BlockItem(SPARKLING_RAINBOWBRICKS, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("deltablock"), new BlockItem(DELTABLOCK, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("bounceblock"), new BlockItem(BOUNCEBLOCK, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("frozenspruceleaves"), new BlockItem(FROZEN_SPRUCE_LEAVES, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("frozensprucelog"), new BlockItem(FROZEN_SPRUCE_LOG, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("frozendirt"), new BlockItem(FROZENDIRT, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("blockportal"), new BlockItem(PORTAL_BLOCK, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("crystaldelta"), new BlockItem(CRYSTAL_DELTA, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
        Registry.register(Registry.ITEM, Main.locate("crystaldelta_lowpressure"), new BlockItem(CRYSTAL_DELTA_LOWPRESSURE, new Item.Settings().group(ModItemGroup.MAGICMAGIC_IG)));
    }
}
