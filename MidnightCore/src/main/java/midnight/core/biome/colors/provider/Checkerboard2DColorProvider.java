/*
 * Copyright (c) 2020 Cryptic Mushroom and contributors
 * This file belongs to the Midnight mod and is licensed under the terms and conditions of Cryptic Mushroom. See
 * https://github.com/Cryptic-Mushroom/The-Midnight/blob/rewrite/LICENSE.md for the full license.
 *
 * Last updated: 2020 - 10 - 26
 */

package midnight.core.biome.colors.provider;

import midnight.core.biome.colors.IColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class Checkerboard2DColorProvider implements IColorProvider {
    private final IColorProvider providerA;
    private final IColorProvider providerB;
    private final int sizeX;
    private final int sizeZ;

    public Checkerboard2DColorProvider(IColorProvider providerA, IColorProvider providerB, int sizeX, int sizeZ) {
        this.providerA = providerA;
        this.providerB = providerB;
        this.sizeX = sizeX;
        this.sizeZ = sizeZ;
    }

    @Override
    public int getColor(IWorld world, BlockPos pos) {
        int x = pos.getX() / sizeX;
        int z = pos.getZ() / sizeZ;
        return ((x + z & 1) == 0 ? providerA : providerB).getColor(world, pos);
    }

    @Override
    public void initForSeed(long seed) {
        providerA.initForSeed(seed);
        providerB.initForSeed(seed);
    }
}
