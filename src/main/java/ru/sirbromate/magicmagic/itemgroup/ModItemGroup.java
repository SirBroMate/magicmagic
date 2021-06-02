package ru.sirbromate.magicmagic.itemgroup;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.init.ModItems;

public class ModItemGroup {
    public static final ItemGroup MAGICMAGIC_IG = FabricItemGroupBuilder.build(
            Main.locate("magicmagic"),
            () -> new ItemStack(ModItems.MAGIC_DELTA));

    public static void init() {
    }
}