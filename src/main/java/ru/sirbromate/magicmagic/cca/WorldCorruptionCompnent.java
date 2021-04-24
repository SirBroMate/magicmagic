package ru.sirbromate.magicmagic.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.world.World;

public class WorldCorruptionCompnent implements ComponentV3, AutoSyncedComponent {

    private static final String CORRUPTION_KEY = "Corruption";
    private final World world;
    private int corruptionLevel = 0;

    public WorldCorruptionCompnent(World world) {
        this.world = world;
    }

    public int corruptionLevel() {
        return corruptionLevel;
    }

    public void increaseLevel(){
        this.corruptionLevel++;
    }

    public void decreaseLevel(){
         this.corruptionLevel--;
    }

    public void setCorruptionLevel(int level) {
        this.corruptionLevel = level;
        WorldCorruption.CORRUPTION.sync(world);
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
        CompoundTag tag = buf.readCompoundTag();
    }
}
