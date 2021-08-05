package ru.sirbromate.magicmagic.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.client.render.BrimBallRender;
import ru.sirbromate.magicmagic.client.render.RainbowCrystalColor;
import ru.sirbromate.magicmagic.init.ModBlocks;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {

    public static final Identifier PacketID = Main.locate("spawn_packet");

    @Environment(EnvType.CLIENT)
    public static void setBlockRenderLayout() {
        RenderLayer cutout = RenderLayer.getCutout();
        RenderLayer translucent = RenderLayer.getTranslucent();

        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, ModBlocks.FROZEN_SPRUCE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(translucent, ModBlocks.CRYSTAL_DELTA_TRANSPARENT);
        BlockRenderLayerMap.INSTANCE.putBlocks(cutout, ModBlocks.YLUX_CRYSTAL);
        BlockRenderLayerMap.INSTANCE.putBlocks(translucent, ModBlocks.CRYSTAL_GEL);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        setBlockRenderLayout();
        BrimBallRender.init();
        ReceiveEntityPacket.receiveEntityPacket();
        RainbowCrystalColor.init();
    }
}