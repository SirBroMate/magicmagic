package ru.sirbromate.magicmagic.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.itemgroup.ModItemGroup;
import ru.sirbromate.magicmagic.objects.block.*;

public class ModBlocks {
    public static Block MAGICDELTA_STONE = new DeltaStoneBlock();
    public static Block MAGICDELTA_BRICKS = new DeltaBricksBlock();
    public static Block FIREDELTA_STONE = new DeltaStoneBlock();
    public static Block FIREDELTA_BRICKS = new DeltaBricksBlock();
    public static Block ELECTRODELTA_STONE = new DeltaStoneBlock();
    public static Block ELECTRODELTA_BRICKS = new DeltaBricksBlock();
    public static Block WATERDELTA_STONE = new DeltaStoneBlock();
    public static Block WATERDELTA_BRICKS = new DeltaBricksBlock();
    public static Block RAINBOW_BRICKS = new RainbowBricksBlock();
    public static Block SPARKLING_RAINBOW_BRICKS = new RainbowBricksBlock();
    public static Block DELTABLOCK = new DeltaBlock();
    public static Block BOUNCE_BLOCK = new BounceBlock();
    public static Block FROZEN_SPRUCE_LEAVES = new FrozenLeavesBlock();
    public static Block FROZEN_SPRUCE_LOG = new FrozenLogBlock();
    public static Block FROZEN_DIRT = new Block(FabricBlockSettings.of(Material.SOIL).hardness(0.5f).sounds(BlockSoundGroup.GRAVEL).breakByTool(FabricToolTags.SHOVELS).breakByHand(true));
    public static Block PORTAL_BLOCK = new BlockPortal();
    public static Block CRYSTAL_DELTA = new CrystalDeltaBlock();
    public static Block CRYSTAL_DELTA_TRANSPARENT = new CrystalDeltaLPBlock();
    public static Block EYE_BLOCK = new EyeBlock();
    public static Block YLUX_CRYSTAL = new YluxCrystalBlock();
    public static Block FROZEN_SAPLING = new FrozenSaplingBlock(new FrozenTreeSupplingGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static Block BURNED_LOG = new BurnedLogBlock();
    public static Block ASH = new FallingBlock(FabricBlockSettings.of(Material.SOIL).hardness(0.3F).sounds(BlockSoundGroup.SAND).breakByTool(FabricToolTags.SHOVELS).breakByHand(true));
    public static Block CRYSTAL_GEL = new CrystalGelBlock();
    public static Block RAINBOW_CRYSTAL = new RainbowCrystalBlock();


    public static void init() {
        registerBlock(MAGICDELTA_STONE, "magicdeltastone");
        registerBlock(MAGICDELTA_BRICKS, "magicdeltabricks");
        registerBlock(FIREDELTA_STONE, "firedeltastone");
        registerBlock(FIREDELTA_BRICKS, "firedeltabricks");
        registerBlock(ELECTRODELTA_STONE, "electrodeltastone");
        registerBlock(ELECTRODELTA_BRICKS, "electrodeltabricks");
        registerBlock(WATERDELTA_STONE, "waterdeltastone");
        registerBlock(WATERDELTA_BRICKS, "waterdeltabricks");
        registerBlock(DELTABLOCK, "deltablock");
        registerBlock(BOUNCE_BLOCK, "bounceblock");
        registerBlock(FROZEN_SPRUCE_LOG, "frozen_spruce_log");
        registerBlock(FROZEN_SPRUCE_LEAVES, "frozen_spruce_leaves");
        registerBlock(FROZEN_SAPLING, "frozen_sapling");
        registerBlock(FROZEN_DIRT, "frozendirt");
        registerBlock(PORTAL_BLOCK, "portalblock");
        registerBlock(CRYSTAL_DELTA, "crystaldelta");
        registerBlock(CRYSTAL_DELTA_TRANSPARENT, "crystaldelta_transparent");
        registerBlock(EYE_BLOCK, "eyeblock");
        registerBlock(YLUX_CRYSTAL, "yluxcrystal");
        registerBlock(BURNED_LOG, "burnedlog");
        registerBlock(ASH, "ash");
        registerBlock(CRYSTAL_GEL, "crystalgel");
        registerBlock(RAINBOW_CRYSTAL, "rainbowcrystal");
        registerBlock(RAINBOW_BRICKS, "rainbowbricks");
        registerBlock(SPARKLING_RAINBOW_BRICKS, "sparkling_rainbow_bricks");


        // Item blocks
        registerBlockItem(MAGICDELTA_STONE, "magicdeltastone", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(MAGICDELTA_BRICKS, "magicdeltabricks", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(FIREDELTA_STONE, "firedeltastone", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(FIREDELTA_BRICKS, "firedeltabricks", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(ELECTRODELTA_STONE, "electrodeltastone", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(ELECTRODELTA_BRICKS, "electrodeltabricks", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(WATERDELTA_STONE, "waterdeltastone", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(WATERDELTA_BRICKS, "waterdeltabricks", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(RAINBOW_BRICKS, "rainbowbricks", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(SPARKLING_RAINBOW_BRICKS, "sparkling_rainbow_bricks", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(DELTABLOCK, "deltablock", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(BOUNCE_BLOCK, "bounceblock", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(FROZEN_SPRUCE_LOG, "frozen_spruce_log", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(FROZEN_SPRUCE_LEAVES, "frozen_spruce_leaves", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(FROZEN_SAPLING, "frozen_sapling", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(FROZEN_DIRT, "frozendirt", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(PORTAL_BLOCK, "portalblock", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(CRYSTAL_DELTA, "crystaldelta", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(CRYSTAL_DELTA_TRANSPARENT, "crystaldelta_transparent", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(EYE_BLOCK, "eyeblock", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(YLUX_CRYSTAL, "yluxcrystal", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(BURNED_LOG, "burnedlog", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(ASH, "ash", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(CRYSTAL_GEL, "crystalgel", ModItemGroup.MAGICMAGIC_IG);
        registerBlockItem(RAINBOW_CRYSTAL, "rainbowcrystal", ModItemGroup.MAGICMAGIC_IG);
    }

    private static void registerBlock(Block block, String id) {
        Registry.register(Registry.BLOCK, Main.locate(id), block);
    }

    private static void registerBlockItem(Block block, String id, ItemGroup group) {
        Registry.register(Registry.ITEM, Main.locate(id), new BlockItem(block, new Item.Settings().group(group)));
    }
}
