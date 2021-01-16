/*
 * Copyright (c) 2020 Cryptic Mushroom and contributors
 * This file belongs to the Midnight mod and is licensed under the terms and conditions of Cryptic Mushroom. See
 * https://github.com/Cryptic-Mushroom/The-Midnight/blob/rewrite/LICENSE.md for the full license.
 *
 * Last updated: 2021 - 1 - 16
 */

package midnight.data.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.nio.file.Path;

public class MnFluidTagsProvider extends TagsProvider<Fluid> {
    @SuppressWarnings("deprecation") // We need Registry.FLUID. Sorry Forge...
    public MnFluidTagsProvider(DataGenerator gen) {
        super(gen, Registry.FLUID);
    }

    @Override
    protected void registerTags() {
    }

    @Override
    protected Path makePath(ResourceLocation id) {
        return generator.getOutputFolder().resolve("data/" + id.getNamespace() + "/tags/fluids/" + id.getPath() + ".json");
    }

    @Override
    public String getName() {
        return "Midnight - Fluid tags";
    }
}
