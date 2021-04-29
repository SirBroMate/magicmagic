package ru.sirbromate.magicmagic.init;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.items.DeltaItem;
import ru.sirbromate.magicmagic.items.DirtXploderItem;
import ru.sirbromate.magicmagic.items.FireDeltaPick;
import ru.sirbromate.magicmagic.items.MagicalStrawItem;

public class ModItems {
    public static Item MAGICSTRAW = new MagicalStrawItem();
    public static Item DIRTXPLODER = new DirtXploderItem();
    public static Item MAGIC_DELTA = new DeltaItem();
    public static Item FIREDELTA = new DeltaItem();
    public static Item WATERDELTA = new DeltaItem();
    public static Item ELETRODELTA = new DeltaItem();
    public static Item FIREDELTA_PICK = new FireDeltaPick();


    public static void init() {
        Registry.register(Registry.ITEM, Main.locate("magicstraw"), MAGICSTRAW);
        Registry.register(Registry.ITEM, Main.locate("dirtxploder"), DIRTXPLODER);
        Registry.register(Registry.ITEM, Main.locate("magicdelta"), MAGIC_DELTA);
        Registry.register(Registry.ITEM, Main.locate("firedelta"), FIREDELTA);
        Registry.register(Registry.ITEM, Main.locate("waterdelta"), WATERDELTA);
        Registry.register(Registry.ITEM, Main.locate("electrodelta"), ELETRODELTA);
        Registry.register(Registry.ITEM, Main.locate("firedeltapick"), FIREDELTA_PICK);


    }

}
