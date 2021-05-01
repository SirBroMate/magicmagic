package ru.sirbromate.magicmagic.client.render;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import ru.sirbromate.magicmagic.init.ModEntities;

public class BrimBallRender {

    public static void init(){
        EntityRendererRegistry.INSTANCE.register(ModEntities.PackedSnowballEntityType, (dispatcher, context) ->
                new FlyingItemEntityRenderer(dispatcher, context.getItemRenderer()));
    }
}
