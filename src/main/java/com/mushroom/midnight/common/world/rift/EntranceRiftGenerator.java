package com.mushroom.midnight.common.world.rift;

import com.mushroom.midnight.Midnight;
import com.mushroom.midnight.common.registry.MidnightBlocks;
import com.mushroom.midnight.common.registry.MidnightItems;
import com.mushroom.midnight.common.world.noise.INoiseSampler;
import com.mushroom.midnight.common.world.noise.PerlinNoiseSampler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.BitSet;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Midnight.MODID)
public class EntranceRiftGenerator {
    private static final INoiseSampler WARP_NOISE = new PerlinNoiseSampler(new Random(8555034668646880878L));

    private static final int OUTER_RADIUS = 2;

    private static final double PORTAL_RADIUS = 3.0;

    static {
        WARP_NOISE.setFrequency(0.1);
        WARP_NOISE.setAmplitude(3.0);
    }

    // TODO: Test code
    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
        World world = event.getWorld();
        if (world.isRemote) return;

        if (event.getItemStack().getItem() == MidnightItems.DARK_PEARL) {
            PlayerEntity player = event.getPlayer();

            Vec3d lookVec = player.getLook(1.0F);
            Vec3d origin = player.getEyePosition(1.0F);
            Vec3d target = origin.add(lookVec.scale(64.0));

            BlockRayTraceResult result = world.rayTraceBlocks(new RayTraceContext(origin, target, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, player));
            if (result.getType() == RayTraceResult.Type.BLOCK) {
                new EntranceRiftGenerator().generate(world, result.getPos(), new Random());
            }
        }
    }

    public void generate(World world, BlockPos origin, Random random) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        int craterRadius = random.nextInt(3) + 7;
        int radius = craterRadius + OUTER_RADIUS;
        int totalDepth = craterRadius / 2;

        CoverMask coverMask = new CoverMask(radius + 6);
        DistanceField distanceField = this.generateDistanceField(origin.getX(), origin.getZ(), radius + 2);

        for (int z = -radius; z <= radius; z++) {
            for (int x = -radius; x <= radius; x++) {
                mutablePos.setPos(x + origin.getX(), origin.getY(), z + origin.getZ());

                float distance = distanceField.get(x, z);
                if (distance > radius) continue;

                int depth = this.computeDepth(distance, craterRadius, totalDepth);

                while (mutablePos.getY() > origin.getY() - depth) {
                    this.carveBlock(world, mutablePos);
                    mutablePos.move(Direction.DOWN);
                }

                BlockState surfaceState = this.computeSurfaceState(distance, radius, random);

                mutablePos.setY(origin.getY() - depth);

                this.setBlockState(world, mutablePos, surfaceState);
                coverMask.put(x, z);
            }
        }

        this.generateTendrils(world, random, origin, radius, coverMask);
    }

    private void generateTendrils(World world, Random random, BlockPos origin, int radius, CoverMask coverMask) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        float angle = 0.0F;
        float angleStep = 15.0F;

        float distance = radius + 3.0F;

        while (angle < 360.0F - angleStep) {
            angle += angleStep;

            double angleRad = Math.toRadians(angle);

            int x = MathHelper.floor(Math.sin(angleRad) * distance);
            int z = MathHelper.floor(Math.cos(angleRad) * distance);

            x += random.nextInt(3) - random.nextInt(3);
            z += random.nextInt(3) - random.nextInt(3);

            while (!coverMask.has(x, z) && coverMask.contains(x, z)) {
                mutablePos.setPos(origin.getX() + x, origin.getY(), origin.getZ() + z);

                this.setBlockState(world, mutablePos, MidnightBlocks.MALIGNANT_RED_PLANT_BLOCK.getDefaultState());
                coverMask.put(x, z);

                Direction.Axis axis = this.chooseTendrilAxis(random, x, z);
                if (axis == Direction.Axis.X) {
                    x -= MathHelper.signum(x);
                } else {
                    z -= MathHelper.signum(z);
                }
            }
        }
    }

    private Direction.Axis chooseTendrilAxis(Random random, int x, int z) {
        if (x == 0) {
            return Direction.Axis.Z;
        } else if (z == 0) {
            return Direction.Axis.X;
        }
        return random.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
    }

    private BlockState computeSurfaceState(double distance, double radius, Random random) {
        if (distance < PORTAL_RADIUS) {
            return MidnightBlocks.RIFT_PORTAL.getDefaultState();
        }

        double distanceFromEdge = radius - distance;
        double glowChance = (distanceFromEdge / radius) * 0.5;

        if (random.nextFloat() < glowChance) {
            return MidnightBlocks.GLOWING_MALIGNANT_RED_PLANT_BLOCK.getDefaultState();
        } else {
            return MidnightBlocks.MALIGNANT_RED_PLANT_BLOCK.getDefaultState();
        }
    }

    private int computeDepth(double distance, int craterRadius, int totalDepth) {
        int depth = MathHelper.ceil((1.0 - distance / craterRadius) * totalDepth);
        depth = MathHelper.clamp(depth, 0, totalDepth - 1);
        return depth;
    }

    private DistanceField generateDistanceField(int originX, int originZ, int radius) {
        DistanceField field = new DistanceField(radius);

        for (int z = -radius; z <= radius; z++) {
            for (int x = -radius; x <= radius; x++) {
                int distanceSq = x * x + z * z;

                double warp = WARP_NOISE.get(originX + x, originZ + z);
                double distance = Math.sqrt(distanceSq) + warp;

                field.put(x, z, (float) distance);
            }
        }

        return field;
    }

    private void carveBlock(IWorld world, BlockPos pos) {
        this.setBlockState(world, pos, Blocks.AIR.getDefaultState());
    }

    private void setBlockState(IWorld world, BlockPos pos, BlockState state) {
        if (world.getBlockState(pos).getBlock() == Blocks.BEDROCK) return;

        world.setBlockState(pos, state, Constants.BlockFlags.NOTIFY_LISTENERS | Constants.BlockFlags.NOTIFY_NEIGHBORS);
    }

    private static class DistanceField extends CircleField {
        private final float[] field;

        DistanceField(int radius) {
            super(radius);
            this.field = new float[this.diameter * this.diameter];
        }

        void put(int x, int z, float distance) {
            if (this.contains(x, z)) {
                this.field[this.index(x, z)] = distance;
            }
        }

        float get(int x, int z) {
            if (!this.contains(x, z)) {
                return this.radius;
            }
            return this.field[this.index(x, z)];
        }
    }

    private static class CoverMask extends CircleField {
        private final BitSet bitSet;

        CoverMask(int radius) {
            super(radius);
            this.bitSet = new BitSet(this.diameter * this.diameter);
        }

        void put(int x, int z) {
            if (this.contains(x, z)) {
                this.bitSet.set(this.index(x, z));
            }
        }

        boolean has(int x, int z) {
            if (!this.contains(x, z)) {
                return false;
            }
            return this.bitSet.get(this.index(x, z));
        }
    }

    private static abstract class CircleField {
        final int radius;
        final int diameter;

        CircleField(int radius) {
            this.radius = radius;
            this.diameter = radius * 2 + 1;
        }

        public boolean contains(int x, int z) {
            return x >= -this.radius && z >= -this.radius && x <= this.radius && z <= this.radius;
        }

        int index(int x, int z) {
            return (x + this.radius) + (z + this.radius) * this.diameter;
        }
    }
}
