package ru.sirbromate.magicmagic.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.block.sapling.SpruceSaplingGenerator;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.items.*;

public class ModItems {
    public static Item MAGICSTRAW = new MagicalStrawItem();
    public static Item DIRTXPLODER = new DirtXploderItem();
    public static Item MAGIC_DELTA = new DeltaItem();
    public static Item FIREDELTA = new DeltaItem();
    public static Item WATERDELTA = new DeltaItem();
    public static Item ELETRODELTA = new DeltaItem();
    public static Item FIREDELTA_PICK = new FireDeltaPick();
    public static Item ELECTRODELTA_PICK = new ElectroDeltaPick();
    public static Item WATERDELTA_PICK = new WaterDeltaPick();
    public static Item MAGICDELTA_PICK = new MagicDeltaPick();
    public static Item BRIMBALL = new BrimBallItem();
    public static Item BRIM_STAFF = new BrimStaff();


    public static void init() {
        Registry.register(Registry.ITEM, Main.locate("magicstraw"), MAGICSTRAW);
        Registry.register(Registry.ITEM, Main.locate("dirtxploder"), DIRTXPLODER);
        Registry.register(Registry.ITEM, Main.locate("magicdelta"), MAGIC_DELTA);
        Registry.register(Registry.ITEM, Main.locate("firedelta"), FIREDELTA);
        Registry.register(Registry.ITEM, Main.locate("waterdelta"), WATERDELTA);
        Registry.register(Registry.ITEM, Main.locate("electrodelta"), ELETRODELTA);
        Registry.register(Registry.ITEM, Main.locate("firedeltapick"), FIREDELTA_PICK);
        Registry.register(Registry.ITEM, Main.locate("waterdeltapick"), WATERDELTA_PICK);
        Registry.register(Registry.ITEM, Main.locate("magicdeltapick"), MAGICDELTA_PICK);
        Registry.register(Registry.ITEM, Main.locate("electrodeltapick"), ELECTRODELTA_PICK);
        Registry.register(Registry.ITEM, Main.locate("brimball"), BRIMBALL);
        Registry.register(Registry.ITEM, Main.locate("brimstaff"), BRIM_STAFF);
    }

}
