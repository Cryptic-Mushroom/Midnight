package com.mushroom.midnight.common.world.feature;

import com.mojang.datafixers.Dynamic;
import com.mushroom.midnight.Midnight;
import com.mushroom.midnight.common.registry.MidnightBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.function.Function;

public class LargeBulbFungusFeature extends TemplateTreeFeature {
    private static final ResourceLocation[] TEMPLATES = new ResourceLocation[] {
            new ResourceLocation(Midnight.MODID, "mushroom/bulbfungus_1"),
            new ResourceLocation(Midnight.MODID, "mushroom/bulbfungus_2")
    };

    private static final BlockState LOG = MidnightBlocks.BULB_FUNGUS_STEM.getDefaultState();
    private static final BlockState LEAVES = MidnightBlocks.BULB_FUNGUS_HAT.getDefaultState();

    public LargeBulbFungusFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> deserialize) {
        super(deserialize, TEMPLATES, LOG, LEAVES);
        this.setSapling((IPlantable) MidnightBlocks.BULB_FUNGUS);
    }
}
