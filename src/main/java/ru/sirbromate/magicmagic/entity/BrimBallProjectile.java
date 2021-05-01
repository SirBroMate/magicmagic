package ru.sirbromate.magicmagic.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import ru.sirbromate.magicmagic.client.ClientInit;
import ru.sirbromate.magicmagic.client.EntitySpawnPacket;
import ru.sirbromate.magicmagic.init.ModEntities;
import ru.sirbromate.magicmagic.init.ModItems;
import ru.sirbromate.magicmagic.init.ModStatusEffect;

public class BrimBallProjectile extends ThrownItemEntity {
    public BrimBallProjectile(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BrimBallProjectile(World world, LivingEntity owner) {
        super(ModEntities.PackedSnowballEntityType, owner, world);
    }

    public BrimBallProjectile(World world, double x, double y, double z) {
        super(ModEntities.PackedSnowballEntityType, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
       return ModItems.BRIMBALL;
    }

    @Environment(EnvType.CLIENT)
    private ParticleEffect getParticleParameters() {
        return new ItemStackParticleEffect(ParticleTypes.ITEM, ModItems.BRIMBALL.getDefaultStack());
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(ModStatusEffect.BRIM, 60, 1)));
        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte)3);
            this.remove();
        }
    }

    @Override
    public Packet createSpawnPacket() {
        return EntitySpawnPacket.create(this, ClientInit.PacketID);
    }
}
