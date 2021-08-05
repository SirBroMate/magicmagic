package ru.sirbromate.magicmagic.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.util.math.BlockPos;
import ru.sirbromate.magicmagic.init.ModBlocks;
import ru.sirbromate.magicmagic.util.OpenSimplex2F;

import java.awt.*;

public class RainbowCrystalColor {
    public static int posToRainbow(BlockPos pos) {
        OpenSimplex2F simplex2F = new OpenSimplex2F(1234); // Using OpenSimplex2 noise for rainbow noise

        // BlockPos division for noise scaling. Without it noise is too small and looks too chaotic on blocks.
        double noise = (simplex2F.noise3_Classic(pos.getX() / 10.0D, pos.getY() / 10.0D, pos.getZ() / 10.0D));
        noise = Math.sin(Math.tan(noise));

        if (noise < 0.0D) { // Minimal noise value for preventing color bugs
            noise *= -1;
        }

        return Color.HSBtoRGB((float) (1.0F * noise), 0.3F, 1.0F);
    }

    public static void init() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> posToRainbow(pos != null ? pos : new BlockPos(0, 0, 0)), ModBlocks.RAINBOW_CRYSTAL);
    }
}