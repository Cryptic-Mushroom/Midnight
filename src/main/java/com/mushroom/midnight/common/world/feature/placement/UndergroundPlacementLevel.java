package com.mushroom.midnight.common.world.feature.placement;

import com.mushroom.midnight.common.world.MidnightChunkGenerator;
import com.mushroom.midnight.common.world.PlacementLevel;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;
import java.util.function.Predicate;

public class UndergroundPlacementLevel implements PlacementLevel {
    public static final PlacementLevel INSTANCE = new UndergroundPlacementLevel();

    private UndergroundPlacementLevel() {
    }

    @Override
    public BlockPos getSurfacePos(IWorld world, Heightmap.Type heightmap, BlockPos pos) {
        IChunk chunk = world.getChunk(pos);
        Predicate<BlockState> predicate = heightmap.func_222684_d();

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int y = 5; y < MidnightChunkGenerator.MIN_SURFACE_LEVEL; y++) {
            mutablePos.setPos(pos.getX(), y, pos.getZ());

            BlockState state = chunk.getBlockState(mutablePos);
            if (predicate.test(state)) {
                return mutablePos.toImmutable();
            }
        }

        return pos;
    }

    @Override
    public int generateUpTo(IWorld world, Random random, int y) {
        return random.nextInt(Math.min(y, MidnightChunkGenerator.MIN_SURFACE_LEVEL));
    }
}
