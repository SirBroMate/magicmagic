package ru.sirbromate.magicmagic.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import ru.sirbromate.magicmagic.init.ModBlocks;

import java.util.Random;

public class CrystalSpikeFeature extends Feature<SingleStateFeatureConfig> {
    public CrystalSpikeFeature(Codec<SingleStateFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(StructureWorldAccess structureWorldAccess, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, SingleStateFeatureConfig singleStateFeatureConfig) {
        blockPos = new BlockPos(blockPos.getX(), chunkGenerator.getSeaLevel(), blockPos.getZ());
        boolean bl = random.nextDouble() > 0.7D;
        BlockState blockState = singleStateFeatureConfig.state;
        double d = random.nextDouble() * 2.0D * 3.141592653589793D;
        int i = 11 - random.nextInt(5);
        int j = 3 + random.nextInt(3);
        boolean bl2 = random.nextDouble() > 0.7D;
        int l = bl2 ? random.nextInt(6) + 6 : random.nextInt(15) + 3;

        if (!bl2 && random.nextDouble() > 0.9D) {
            l += random.nextInt(19) + 7;
        }

        int m = Math.min(l + random.nextInt(11), 18);
        int n = Math.min(l + random.nextInt(7) - random.nextInt(5), 11);
        int o = bl2 ? i : 11;

        for (int t = -o; t < o; ++t) {
            for (int u = -o; u < o; ++u) {
                for (int v = 0; v < l; ++v) {
                    int w = bl2 ? this.radiusEllipse(v, l, n) : this.radius(random, v, l, n);
                    if (bl2 || t < w) {
                        this.generateBlocks(structureWorldAccess, random, blockPos, l, t, v, u, w, o, bl2, j, d, bl, blockState);
                    }
                }
            }
        }

        this.smoothing(structureWorldAccess, blockPos, n, l, bl2, i);

        for (int t = -o; t < o; ++t) {
            for (int u = -o; u < o; ++u) {
                for (int v = -1; v > -m; --v) {
                    int w = bl2 ? MathHelper.ceil((float) o * (1.0F - (float) Math.pow(v, 2.0D) / ((float) m * 8.0F))) : o;
                    int x = this.steepRadius(random, -v, m, n);
                    if (t < x) {
                        this.generateBlocks(structureWorldAccess, random, blockPos, m, t, v, u, x, w, bl2, j, d, bl, blockState);
                    }
                }
            }
        }

        boolean bl3 = bl2 ? random.nextDouble() > 0.1D : random.nextDouble() > 0.7D;
        if (bl3) {
            this.cut(random, structureWorldAccess, n, l, blockPos, bl2, i, d, j);
        }

        return true;
    }

    private void cut(Random random, WorldAccess worldAccess, int i, int j, BlockPos blockPos, boolean bl, int k, double d, int l) {
        int m = random.nextBoolean() ? -1 : 1;
        int n = random.nextBoolean() ? -1 : 1;
        int o = random.nextInt(Math.max(i / 2 - 2, 1));

        if (random.nextBoolean()) {
            o = i / 2 + 1 - random.nextInt(Math.max(i - i / 2 - 1, 1));
        }

        int p = random.nextInt(Math.max(i / 2 - 2, 1));

        if (random.nextBoolean()) {
            p = i / 2 + 1 - random.nextInt(Math.max(i - i / 2 - 1, 1));
        }

        if (bl) {
            o = p = random.nextInt(Math.max(k - 5, 1));
        }

        BlockPos blockPos2 = new BlockPos(m * o, 0, n * p);
        double e = bl ? d + 1.5707963267948966D : random.nextDouble() * 2.0D * 3.141592653589793D;


        for (int s = 0; s < j - 3; ++s) {
            int t = this.radius(random, s, j, i);
            this.carve(t, s, blockPos, worldAccess, false, e, blockPos2, k, l);
        }

        for (int s = -1; s > -j + random.nextInt(5); --s) {
            int t = this.steepRadius(random, -s, j, i);
            this.carve(t, s, blockPos, worldAccess, true, e, blockPos2, k, l);
        }

    }

    private void carve(int i, int j, BlockPos blockPos, WorldAccess worldAccess, boolean bl, double d, BlockPos blockPos2, int k, int l) {
        int m = i + 1 + k / 3;
        int n = Math.min(i - 3, 3) + l / 2 - 1;

        for (int o = -m; o < m; ++o) {
            for (int p = -m; p < m; ++p) {
                double e = this.distanceEllipse(o, p, blockPos2, m, n, d);
                if (e < 0.0D) {
                    BlockPos blockPos3 = blockPos.add(o, j, p);
                    Block block = worldAccess.getBlockState(blockPos3).getBlock();
                    if (this.isCrystalBlock(block) || block == ModBlocks.CRYSTAL_DELTA_LOWPRESSURE) {
                        if (bl) {
                            this.setBlockState(worldAccess, blockPos3, Blocks.WATER.getDefaultState());
                        } else {
                            this.setBlockState(worldAccess, blockPos3, Blocks.AIR.getDefaultState());
                            this.clearSnowAbove(worldAccess, blockPos3);
                        }
                    }
                }
            }
        }

    }

    private void clearSnowAbove(WorldAccess world, BlockPos pos) {
        if (world.getBlockState(pos.up()).isOf(Blocks.SNOW)) {
            this.setBlockState(world, pos.up(), Blocks.AIR.getDefaultState());
        }

    }

    private void generateBlocks(WorldAccess worldAccess, Random random, BlockPos blockPos, int i, int j, int k, int l, int m, int n, boolean bl, int o, double d, boolean bl2, BlockState blockState) {
        double e = bl ? this.distanceEllipse(j, l, BlockPos.ORIGIN, n, this.ecllipse(k, i, o), d) : this.distanceCircle(j, l, m, random);

        if (e < 0.0D) {
            BlockPos blockPos2 = blockPos.add(j, k, l);
            double f = bl ? -0.5D : (-6 - random.nextInt(3));
            if (e > f && random.nextDouble() > 0.9D) {
                return;
            }

            this.setBlocks(blockPos2, worldAccess, random, i - k, i, bl, bl2, blockState);
        }

    }

    private void setBlocks(BlockPos blockPos, WorldAccess worldAccess, Random random, int i, int j, boolean bl, boolean bl2, BlockState blockState) {
        BlockState blockState2 = worldAccess.getBlockState(blockPos);

        if (blockState2.getMaterial() == Material.AIR || blockState2.isOf(ModBlocks.CRYSTAL_DELTA_LOWPRESSURE) || blockState2.isOf(Blocks.ICE) || blockState2.isOf(Blocks.WATER)) {
            boolean bl3 = !bl || random.nextDouble() > 0.05D;
            int k = bl ? 3 : 2;
            if (bl2 && !blockState2.isOf(Blocks.WATER) && i <= random.nextInt(Math.max(1, j / k)) + j * 0.6D && bl3) {
                this.setBlockState(worldAccess, blockPos, ModBlocks.CRYSTAL_DELTA_LOWPRESSURE.getDefaultState());
            } else {
                this.setBlockState(worldAccess, blockPos, blockState);
            }
        }

    }

    private int ecllipse(int i, int j, int k) {
        int l = k;

        if (i > 0 && j - i <= 3) {
            l = k - (4 - (j - i));
        }

        return l;
    }

    private double distanceCircle(int i, int j, int k, Random random) {
        float f = 10.0F * MathHelper.clamp(random.nextFloat(), 0.2F, 0.8F) / k;
        return (double) f + Math.pow(i - BlockPos.ORIGIN.getX(), 2.0D) + Math.pow(j - BlockPos.ORIGIN.getZ(), 2.0D) - Math.pow(k, 2.0D);
    }

    private double distanceEllipse(int i, int j, BlockPos blockPos, int k, int l, double d) {
        return Math.pow(((i - blockPos.getX()) * Math.cos(d) - (j - blockPos.getZ()) * Math.sin(d)) / k, 2.0D) + Math.pow(((i - blockPos.getX()) * Math.sin(d) + (j - blockPos.getZ()) * Math.cos(d)) / l, 2.0D) - 1.0D;
    }

    private int radius(Random random, int i, int j, int k) {
        float f = 3.5F - random.nextFloat();
        float g = (1.0F - (float) Math.pow(i, 2.0D) / (j * f)) * k;

        if (j > 15 + random.nextInt(5)) {
            int l = i < 3 + random.nextInt(6) ? i / 2 : i;
            g = (1.0F - l / (j * f * 0.4F)) * k;
        }

        return MathHelper.ceil(g / 2.0F);
    }

    private int radiusEllipse(int i, int j, int k) {
        float g = (1.0F - (float) Math.pow(i, 2.0D) / j * k);
        return MathHelper.ceil(g / 2.0F);
    }

    private int steepRadius(Random random, int i, int j, int k) {
        float f = 1.0F + random.nextFloat() / 2.0F;
        float g = (1.0F - i / (j * f)) * k;
        return MathHelper.ceil(g / 2.0F);
    }

    private boolean isCrystalBlock(Block block) {
        return block == ModBlocks.CRYSTAL_DELTA || block == ModBlocks.CRYSTAL_DELTA_LOWPRESSURE;
    }

    private boolean isAirBelow(BlockView world, BlockPos pos) {
        return world.getBlockState(pos.down()).getMaterial() == Material.AIR;
    }

    private void smoothing(WorldAccess world, BlockPos pos, int i, int j, boolean bl, int k) {
        int l = bl ? k : i / 2;

        for (int m = -l; m <= l; ++m) {
            for (int n = -l; n <= l; ++n) {
                for (int o = 0; o <= j; ++o) {
                    BlockPos blockPos = pos.add(m, o, n);
                    Block block = world.getBlockState(blockPos).getBlock();
                    if (this.isCrystalBlock(block)) {
                        if (this.isAirBelow(world, blockPos)) {
                            this.setBlockState(world, blockPos, Blocks.AIR.getDefaultState());
                            this.setBlockState(world, blockPos.up(), Blocks.AIR.getDefaultState());
                        } else if (this.isCrystalBlock(block)) {
                            Block[] blocks = new Block[]{
                                    world.getBlockState(blockPos.west()).getBlock(), world.getBlockState(blockPos.east()).getBlock(), world.getBlockState(blockPos.north()).getBlock(), world.getBlockState(blockPos.south()).getBlock()
                            };

                            int p = 0;

                            for (Block block2 : blocks) {
                                if (!this.isCrystalBlock(block2)) {
                                    ++p;
                                }
                            }

                            if (p >= 3) {
                                this.setBlockState(world, blockPos, Blocks.AIR.getDefaultState());
                            }
                        }
                    }
                }
            }
        }

    }
}
