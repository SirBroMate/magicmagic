package ru.sirbromate.magicmagic.objects.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;


public class BounceBlock extends Block {
    public BounceBlock() {
        super(FabricBlockSettings.of(Material.WOOL)
                .strength(0.8F)
                .sounds(BlockSoundGroup.WOOL)
                .breakByHand(true));
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        this.bounce(entity);
    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 16 && vec3d.x < 16 && vec3d.z < 16) {
            double d = 1.15D;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }
    }
}