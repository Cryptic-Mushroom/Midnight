/*
 * Copyright (c) 2020 Cryptic Mushroom and contributors
 * This file belongs to the Midnight mod and is licensed under the terms and conditions of Cryptic Mushroom. See
 * https://github.com/Cryptic-Mushroom/The-Midnight/blob/rewrite/LICENSE.md for the full license.
 *
 * Last updated: 2021 - 1 - 18
 */

package midnight.client.handler;

import midnight.client.MidnightClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "midnight", value = Dist.CLIENT)
public final class BiomeColorCacheHandler {
    private BiomeColorCacheHandler() {
    }

    @SubscribeEvent
    public static void onWorldLoad(WorldEvent.Load load) {
        if (load.getWorld() instanceof ClientWorld) {
            MidnightClient.get().getColorCacheManager().reset();
        }
    }

    @SubscribeEvent
    public static void onChunkLoad(ChunkEvent.Load load) {
        if (load.getWorld() instanceof ClientWorld) {
            MidnightClient.get().getColorCacheManager().chunkLoad(load.getChunk().getPos());
        }
    }
}
