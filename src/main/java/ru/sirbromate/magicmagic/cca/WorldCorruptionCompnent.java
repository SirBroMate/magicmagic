package ru.sirbromate.magicmagic.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class WorldCorruptionCompnent implements ComponentV3, AutoSyncedComponent {

    private static final String CORRUPTION_KEY = "Corruption";
    private final World world;
    private int corruptionLevel = 0;

    public WorldCorruptionCompnent(World world) {
        this.world = world;
    }

    public int corruptionLevel() {
        WorldCorruption.CORRUPTION.sync(world);
        this.setBounds();
        return corruptionLevel;
    }

    public void increaseLevel() {
        this.corruptionLevel = this.corruptionLevel + 10;
        this.setBounds();
        WorldCorruption.CORRUPTION.sync(world);
    }

    public void decreaseLevel() {
        this.corruptionLevel = this.corruptionLevel - 10;
        this.setBounds();
        WorldCorruption.CORRUPTION.sync(world);
    }

    public void setCorruptionLevel(int level) {
        this.corruptionLevel = level;
        this.setBounds();
        WorldCorruption.CORRUPTION.sync(world);

    }

    private void setBounds() {
        if (this.corruptionLevel < 0) {
            this.corruptionLevel = 0;
        } else if (this.corruptionLevel > 200) {
            this.corruptionLevel = 200;
        }
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        this.corruptionLevel = tag.getInt(CORRUPTION_KEY);
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putInt(CORRUPTION_KEY, corruptionLevel);
    }

    @Override
    public void applySyncPacket(PacketByteBuf buf) {
        this.corruptionLevel = buf.readVarInt();
    }

    @Override
    public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity recipient) {
        buf.writeVarInt(this.corruptionLevel);
    }
}
