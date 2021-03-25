package ru.sirbromate.magicmagic.init;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.items.MagicalStrawItem;

public class ModItems {
    public static Item MAGICSTRAW = new MagicalStrawItem();

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "magicstraw"), MAGICSTRAW);

    }

}
