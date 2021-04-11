package ru.sirbromate.magicmagic.init;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
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


    public static void init() {
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "magicstraw"), MAGICSTRAW);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "dirtxploder"), DIRTXPLODER);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "magicdelta"), MAGIC_DELTA);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "firedelta"), FIREDELTA);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "waterdelta"), WATERDELTA);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "electrodelta"), ELETRODELTA);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "firedeltapick"), FIREDELTA_PICK);


    }

}
