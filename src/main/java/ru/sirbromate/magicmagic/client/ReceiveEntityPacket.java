package ru.sirbromate.magicmagic.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;


public class ReceiveEntityPacket {
    public static void receiveEntityPacket() {
        ClientPlayNetworking.registerGlobalReceiver(ClientInit.PacketID, (client, handler, byteBuf, responseSender) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());

            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);

            client.execute(() -> {
                if (client.world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                Entity e = et.create(client.world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");

                e.updateTrackedPosition(pos);
                e.setPos(pos.x, pos.y, pos.z);
                e.prevPitch = pitch;
                e.prevYaw = yaw;
                e.setId(entityId);
                e.setUuid(uuid);

                client.world.addEntity(entityId, e);
            });
        });
    }
}
