package ru.sirbromate.magicmagic.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import ru.sirbromate.magicmagic.init.ModBlocks;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {

    @Environment(EnvType.CLIENT)
    public static void setBlockRenderLayout() {
        RenderLayer cutout = RenderLayer.getCutout();
        RenderLayer translucent = RenderLayer.getTranslucent();

        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, ModBlocks.FROZEN_SPRUCE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(translucent, ModBlocks.CRYSTAL_DELTA_LOWPRESSURE);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        setBlockRenderLayout();
    }
}
