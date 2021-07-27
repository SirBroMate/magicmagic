package ru.sirbromate.magicmagic.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import ru.sirbromate.magicmagic.Main;
import ru.sirbromate.magicmagic.entity.BrimBallProjectile;

public class ModEntities {

    public static final EntityType<BrimBallProjectile> PackedSnowballEntityType = Registry.register(
            Registry.ENTITY_TYPE,
            Main.locate("brimball"),
            FabricEntityTypeBuilder.<BrimBallProjectile>create(SpawnGroup.MISC, BrimBallProjectile::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );


    public static void init(){}
}
