/*
 * Copyright (c) 2020 Cryptic Mushroom and contributors
 * This file belongs to the Midnight mod and is licensed under the terms and conditions of Cryptic Mushroom. See
 * https://github.com/Cryptic-Mushroom/The-Midnight/blob/rewrite/LICENSE.md for the full license.
 *
 * Last updated: 2021 - 1 - 16
 */

package midnight.common.block;

import midnight.api.util.GeodeHardMaterials;
import midnight.client.MidnightClient;
import midnight.common.Midnight;
import midnight.common.block.fluid.MnFluids;
import midnight.common.item.group.MnItemCategory;
import midnight.common.item.group.MnItemGroup;
import midnight.common.misc.tags.MnBlockTags;
import midnight.common.world.biome.MnBiomeColors;
import midnight.core.util.ColorUtil;
import midnight.core.util.IRegistry;
import midnight.core.util.MnUtil;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * This class registers and stores the list of Midnight blocks and their respective block items.
 *
 * @author Shadew
 * @since 0.6.0
 */
@ObjectHolder("midnight")
public abstract class MnBlocks {

    ////////////////////////
    ///// BLOCK FIELDS /////
    ////////////////////////

    // Basic stones
    public static final Block NIGHTSTONE = inj();
    public static final Block NIGHT_BEDROCK = inj();
    public static final Block TRENCHSTONE = inj();

    // Basic soils
    public static final Block NIGHT_DIRT = inj();
    public static final Block COARSE_NIGHT_DIRT = inj();
    public static final Block NIGHT_GRASS_BLOCK = inj();
    public static final Block DECEITFUL_PEAT = inj();
    public static final Block DECEITFUL_MUD = inj();
    public static final Block STRANGE_SAND = inj();
    public static final Block NIGHT_MYCELIUM = inj();

    // Bricks
    public static final Block NIGHTSTONE_BRICKS = inj();
    public static final Block TRENCHSTONE_BRICKS = inj();
    public static final Block SHROOMBRICKS = inj();

    // Fluids
    public static final Block DARK_WATER = inj();

    // Tall night grass
    public static final Block NIGHT_GRASS = inj();
    public static final Block TALL_NIGHT_GRASS = inj();

    // Ghost plant
    public static final Block GHOST_PLANT_STEM = inj();
    public static final Block GHOST_PLANT_LEAF = inj();
    public static final Block GHOST_PLANT = inj();

    // Dead wood
    public static final Block DEAD_WOOD_LOG = inj();
    public static final Block STRIPPED_DEAD_WOOD_LOG = inj();
    public static final Block DEAD_WOOD = inj();
    public static final Block STRIPPED_DEAD_WOOD = inj();
    public static final Block DEAD_WOOD_PLANKS = inj();
    public static final Block DEAD_SAPLING = inj();

    // Shadowroot
    public static final Block SHADOWROOT_LOG = inj();
    public static final Block STRIPPED_SHADOWROOT_LOG = inj();
    public static final Block SHADOWROOT_WOOD = inj();
    public static final Block STRIPPED_SHADOWROOT_WOOD = inj();
    public static final Block SHADOWROOT_LEAVES = inj();
    public static final Block SHADOWROOT_PLANKS = inj();
    public static final Block SHADOWROOT_SAPLING = inj();
    public static final Block SHADOWROOT_BOOKSHELF = inj();

    // Dark willow
    public static final Block DARK_WILLOW_LOG = inj();
    public static final Block STRIPPED_DARK_WILLOW_LOG = inj();
    public static final Block DARK_WILLOW_WOOD = inj();
    public static final Block STRIPPED_DARK_WILLOW_WOOD = inj();
    public static final Block DARK_WILLOW_LEAVES = inj();
    public static final Block HANGING_DARK_WILLOW_LEAVES = inj();
    public static final Block DARK_WILLOW_PLANKS = inj();
    public static final Block DARK_WILLOW_SAPLING = inj();
    public static final Block DARK_WILLOW_BOOKSHELF = inj();

    // Shroom air
    public static final Block SHROOM_AIR = inj();

    // Nightshroom
    public static final Block NIGHTSHROOM_CAP = inj();
    public static final Block NIGHTSHROOM_STEM = inj();
    public static final Block NIGHTSHROOM_PLANKS = inj();
    public static final Block NIGHTSHROOM = inj();
    public static final Block TALL_NIGHTSHROOM = inj();
    public static final Block NIGHTSHROOM_SHELF = inj();
    public static final Block NIGHTSHROOM_FIBRE = inj();
    public static final Block NIGHTSHROOM_ROOTS = inj();
    public static final Block FLOWERING_NIGHTSHROOM_ROOTS = inj();

    // Dewshroom
    public static final Block DEWSHROOM_CAP = inj();
    public static final Block DEWSHROOM_STEM = inj();
    public static final Block DEWSHROOM_PLANKS = inj();
    public static final Block DEWSHROOM = inj();
    public static final Block TALL_DEWSHROOM = inj();
    public static final Block DEWSHROOM_SHELF = inj();
    public static final Block DEWSHROOM_FIBRE = inj();
    public static final Block DEWSHROOM_ROOTS = inj();
    public static final Block FLOWERING_DEWSHROOM_ROOTS = inj();

    // Viridshroom
    public static final Block VIRIDSHROOM_CAP = inj();
    public static final Block VIRIDSHROOM_STEM = inj();
    public static final Block VIRIDSHROOM_PLANKS = inj();
    public static final Block VIRIDSHROOM = inj();
    public static final Block TALL_VIRIDSHROOM = inj();
    public static final Block VIRIDSHROOM_SHELF = inj();
    public static final Block VIRIDSHROOM_FIBRE = inj();
    public static final Block VIRIDSHROOM_ROOTS = inj();
    public static final Block FLOWERING_VIRIDSHROOM_ROOTS = inj();

    // Moonshroom
    public static final Block MOONSHROOM_CAP = inj();
    public static final Block MOONSHROOM_STEM = inj();
    public static final Block MOONSHROOM_PLANKS = inj();
    public static final Block MOONSHROOM = inj();
    public static final Block TALL_MOONSHROOM = inj();
    public static final Block MOONSHROOM_SHELF = inj();
    public static final Block MOONSHROOM_FIBRE = inj();
    public static final Block MOONSHROOM_ROOTS = inj();
    public static final Block FLOWERING_MOONSHROOM_ROOTS = inj();

    // Bogshroom
    public static final Block BOGSHROOM_CAP = inj();
    public static final Block BOGSHROOM_STEM = inj();
    public static final Block BOGSHROOM_PLANKS = inj();
    public static final Block BOGSHROOM = inj();
    public static final Block TALL_BOGSHROOM = inj();
    public static final Block BOGSHROOM_SHELF = inj();
    public static final Block BOGSHROOM_FIBRE = inj();

    // Glob fungus
    public static final Block GLOB_FUNGUS = inj();
    public static final Block GLOB_FUNGUS_CAP = inj();
    public static final Block GLOB_FUNGUS_STEM = inj();
    public static final Block INFESTED_GLOB_FUNGUS_STEM = inj();
    public static final Block GLOB_FUNGUS_HYPHAE = inj();
    public static final Block GLOB_FUNGUS_THATCH = inj();

    // Misc plants
    public static final Block MISTSHROOM = inj();
    public static final Block TALL_MISTSHROOM = inj();
    public static final Block FINGERED_GRASS = inj();
    public static final Block LUMEN_BUD = inj();
    public static final Block TALL_LUMEN_BUD = inj();
    public static final Block RUNEBUSH = inj();
    public static final Block BOGWEED = inj();
    public static final Block CRYSTALOTUS = inj();
    public static final Block SUAVIS = inj();
    public static final Block VIOLEAF = inj();
    public static final Block TENDRILWEED = inj();
    public static final Block NIGHT_REED = inj();
    public static final Block DECEITFUL_MOSS = inj();
    public static final Block DECEITFUL_ALGAE = inj();

    public static final Block REED_THATCH = inj();
    public static final Block CUT_REED_THATCH = inj();

    // Rockshroom
    public static final Block ROCKSHROOM = inj();

    // Crystals
    public static final Block ROUXE_ROCK = inj();
    public static final Block BLOOMCRYSTAL_ROCK = inj();
    public static final Block ROUXE = inj();
    public static final Block BLOOMCRYSTAL = inj();
    public static final Block CRYSTAL_FLOWER = inj();

    // Dark pearl
    public static final Block DARK_PEARL_ORE = inj();
    public static final Block DARK_PEARL_BLOCK = inj();

    // Archaic
    public static final Block ARCHAIC_ORE = inj();
    public static final Block ARCHAIC_GLASS = inj();
    public static final Block ARCHAIC_GLASS_PANE = inj();

    // Tenebrum
    public static final Block TENEBRUM_ORE = inj();
    public static final Block TENEBRUM_BLOCK = inj();

    // Nagrilite
    public static final Block NAGRILITE_ORE = inj();
    public static final Block NAGRILITE_BLOCK = inj();

    // Ebonite
    public static final Block EBONITE_ORE = inj();
    public static final Block EBONITE_BLOCK = inj();

    // Virilux
    public static final Block VIRILUX_ORE = inj();
    public static final Block VIRILUX_BLOCK = inj();



    //////////////////////////
    ///// BLOCK REGISTRY /////
    //////////////////////////

    public static void registerBlocks(IRegistry<Block> registry) {
        registry.registerAll(
            stone("nightstone", 1.5, 6, MaterialColor.OBSIDIAN),
            stone("night_bedrock", 1.5, 6, MaterialColor.LIGHT_GRAY_TERRACOTTA),
            stone("trenchstone", 1.5, 6, MaterialColor.BLACK),

            dirt("night_dirt", MaterialColor.BLACK),
            dirt("coarse_night_dirt", MaterialColor.BLACK),
            grassBlock("night_grass_block"),
            peat("deceitful_peat", MaterialColor.PURPLE_TERRACOTTA),
            mud("deceitful_mud"),
            sand("strange_sand"),
            mycelium("night_mycelium", 2, 6, MaterialColor.MAGENTA),

            bricks("nightstone_bricks", 1.5, 6, MaterialColor.OBSIDIAN),
            bricks("trenchstone_bricks", 1.5, 6, MaterialColor.BLACK),
            shroombricks("shroombricks"),

            water("dark_water", () -> MnFluids.DARK_WATER),

            smallGrowable("night_grass", 0, 0, Material.TALL_PLANTS, MaterialColor.PURPLE_TERRACOTTA, () -> (TallPlantBlock) TALL_NIGHT_GRASS).hitbox(12, 13).offset(Block.OffsetType.XYZ),
            tallPlant("tall_night_grass", 0, 0, Material.TALL_PLANTS, MaterialColor.PURPLE_TERRACOTTA).hitbox(14, 30).offset(Block.OffsetType.XYZ),

            giantGhostPlant("ghost_plant_stem", GhostPlantStemBlock::new),
            giantGhostPlant("ghost_plant_leaf", GhostPlantBlock::new),
            ghostPlant("ghost_plant", 0, 0, 9, Material.PLANTS, MaterialColor.SNOW).hitbox(13, 14).offset(Block.OffsetType.XZ),

            log("dead_wood_log", MaterialColor.FOLIAGE, () -> STRIPPED_DEAD_WOOD_LOG),
            log("stripped_dead_wood_log", MaterialColor.FOLIAGE),
            log("dead_wood", MaterialColor.FOLIAGE, () -> STRIPPED_DEAD_WOOD),
            log("stripped_dead_wood", MaterialColor.FOLIAGE),
            wood("dead_wood_planks", MaterialColor.FOLIAGE),
            plant("dead_sapling", 0, 0, Material.PLANTS, MaterialColor.FOLIAGE).hitbox(12, 13),

            log("shadowroot_log", MaterialColor.PURPLE, () -> STRIPPED_SHADOWROOT_LOG),
            log("stripped_shadowroot_log", MaterialColor.PURPLE),
            log("shadowroot_wood", MaterialColor.PURPLE, () -> STRIPPED_SHADOWROOT_WOOD),
            log("stripped_shadowroot_wood", MaterialColor.PURPLE),
            leaves("shadowroot_leaves", MaterialColor.PURPLE),
            wood("shadowroot_planks", MaterialColor.PURPLE),
            plant("shadowroot_sapling", 0, 0, Material.PLANTS, MaterialColor.PURPLE).hitbox(11, 15),
            bookshelf("shadowroot_bookshelf", MaterialColor.PURPLE),

            log("dark_willow_log", MaterialColor.BLUE, () -> STRIPPED_DARK_WILLOW_LOG),
            log("stripped_dark_willow_log", MaterialColor.BLUE),
            log("dark_willow_wood", MaterialColor.BLUE, () -> STRIPPED_DARK_WILLOW_WOOD),
            log("stripped_dark_willow_wood", MaterialColor.BLUE),
            growsHangingLeaves("dark_willow_leaves", MaterialColor.BLUE_TERRACOTTA, () -> HANGING_DARK_WILLOW_LEAVES),
            hangingLeaves("hanging_dark_willow_leaves", MaterialColor.BLUE_TERRACOTTA, () -> DARK_WILLOW_LEAVES, MnBlockTags.DARK_WILLOW_LOGS).hitbox(14, 16),
            wood("dark_willow_planks", MaterialColor.BLUE_TERRACOTTA),
            plant("dark_willow_sapling", 0, 0, Material.PLANTS, MaterialColor.BLUE_TERRACOTTA).hitbox(12, 14),
            bookshelf("dark_willow_bookshelf", MaterialColor.BLUE),

            shroomAir("shroom_air"),

            shroomCap("nightshroom_cap", MaterialColor.BLUE, 0x7566B0),
            stem("nightshroom_stem", MaterialColor.BLUE),
            wood("nightshroom_planks", MaterialColor.BLUE),
            smallShroom("nightshroom", 0, 0, Material.PLANTS, MaterialColor.BLUE, () -> (TallPlantBlock) TALL_NIGHTSHROOM).hitbox(14, 14).offset(Block.OffsetType.XZ),
            tallShroom("tall_nightshroom", 0, 0, Material.PLANTS, MaterialColor.BLUE).hitbox(14, 30).offset(Block.OffsetType.XZ),
            shelf("nightshroom_shelf", 0, 0, Material.PLANTS, MaterialColor.BLUE),
            fibre("nightshroom_fibre", Material.TALL_PLANTS, MaterialColor.BLUE),
            shroomRoots("nightshroom_roots", Material.PLANTS, MaterialColor.BLUE).hitbox(13, 14).offset(AbstractBlock.OffsetType.XZ),
            shroomRoots("flowering_nightshroom_roots", Material.PLANTS, MaterialColor.BLUE).hitbox(13, 14).offset(AbstractBlock.OffsetType.XZ),

            shroomCap("dewshroom_cap", MaterialColor.CYAN, 0x72CFD4),
            stem("dewshroom_stem", MaterialColor.CYAN),
            wood("dewshroom_planks", MaterialColor.CYAN),
            smallShroom("dewshroom", 0, 0, Material.PLANTS, MaterialColor.CYAN, () -> (TallPlantBlock) TALL_DEWSHROOM).hitbox(14, 14).offset(Block.OffsetType.XZ),
            tallShroom("tall_dewshroom", 0, 0, Material.PLANTS, MaterialColor.CYAN).hitbox(14, 30).offset(Block.OffsetType.XZ),
            shelf("dewshroom_shelf", 0, 0, Material.PLANTS, MaterialColor.CYAN),
            fibre("dewshroom_fibre", Material.TALL_PLANTS, MaterialColor.CYAN),
            shroomRoots("dewshroom_roots", Material.PLANTS, MaterialColor.CYAN).hitbox(13, 14).offset(AbstractBlock.OffsetType.XZ),
            shroomRoots("flowering_dewshroom_roots", Material.PLANTS, MaterialColor.CYAN).hitbox(13, 14).offset(AbstractBlock.OffsetType.XZ),

            shroomCap("viridshroom_cap", MaterialColor.LIME, 0x84F54C),
            stem("viridshroom_stem", MaterialColor.LIME),
            wood("viridshroom_planks", MaterialColor.LIME),
            smallShroom("viridshroom", 0, 0, Material.PLANTS, MaterialColor.LIME, () -> (TallPlantBlock) TALL_VIRIDSHROOM).hitbox(14, 14).offset(Block.OffsetType.XZ),
            tallShroom("tall_viridshroom", 0, 0, Material.PLANTS, MaterialColor.LIME).hitbox(14, 30).offset(Block.OffsetType.XZ),
            shelf("viridshroom_shelf", 0, 0, Material.PLANTS, MaterialColor.LIME),
            fibre("viridshroom_fibre", Material.TALL_PLANTS, MaterialColor.LIME),
            shroomRoots("viridshroom_roots", Material.PLANTS, MaterialColor.LIME).hitbox(13, 14).offset(AbstractBlock.OffsetType.XZ),
            shroomRoots("flowering_viridshroom_roots", Material.PLANTS, MaterialColor.LIME).hitbox(13, 14).offset(AbstractBlock.OffsetType.XZ),

            shroomCap("moonshroom_cap", MaterialColor.LIGHT_GRAY, 0xD7F3F5),
            stem("moonshroom_stem", MaterialColor.GRAY),
            wood("moonshroom_planks", MaterialColor.GRAY),
            smallShroom("moonshroom", 0, 0, Material.PLANTS, MaterialColor.LIGHT_GRAY, () -> (TallPlantBlock) TALL_MOONSHROOM).hitbox(14, 14).offset(Block.OffsetType.XZ),
            tallShroom("tall_moonshroom", 0, 0, Material.PLANTS, MaterialColor.LIGHT_GRAY).hitbox(14, 30).offset(Block.OffsetType.XZ),
            shelf("moonshroom_shelf", 0, 0, Material.PLANTS, MaterialColor.LIGHT_GRAY),
            fibre("moonshroom_fibre", Material.TALL_PLANTS, MaterialColor.GRAY),
            shroomRoots("moonshroom_roots", Material.PLANTS, MaterialColor.GRAY).hitbox(13, 14).offset(AbstractBlock.OffsetType.XZ),
            shroomRoots("flowering_moonshroom_roots", Material.PLANTS, MaterialColor.GRAY).hitbox(13, 14).offset(AbstractBlock.OffsetType.XZ),

            shroomCap("bogshroom_cap", MaterialColor.ADOBE, 0xF5AF4C),
            stem("bogshroom_stem", MaterialColor.ADOBE),
            wood("bogshroom_planks", MaterialColor.ADOBE),
            smallShroom("bogshroom", 0, 0, Material.PLANTS, MaterialColor.ADOBE, () -> (TallPlantBlock) TALL_BOGSHROOM).hitbox(14, 14).offset(Block.OffsetType.XZ),
            tallShroom("tall_bogshroom", 0, 0, Material.PLANTS, MaterialColor.ADOBE).hitbox(14, 30).offset(Block.OffsetType.XZ),
            shelf("bogshroom_shelf", 0, 0, Material.PLANTS, MaterialColor.ADOBE),
            fibre("bogshroom_fibre", Material.TALL_PLANTS, MaterialColor.ADOBE),

            smallFungus("glob_fungus", 0, 0, Material.PLANTS, MaterialColor.MAGENTA).hitbox(13, 13).offset(Block.OffsetType.XYZ),
            globCap("glob_fungus_cap", MaterialColor.MAGENTA),
            globStem("glob_fungus_stem", MaterialColor.PURPLE),
            infestedGlobStem("infested_glob_fungus_stem", MaterialColor.PURPLE),
            globStem("glob_fungus_hyphae", MaterialColor.PURPLE),
            thatch("glob_fungus_thatch", MaterialColor.PURPLE),

            smallShroom("mistshroom", 0, 0, Material.PLANTS, MaterialColor.CYAN_TERRACOTTA, () -> (TallPlantBlock) TALL_MISTSHROOM).hitbox(13, 13).offset(Block.OffsetType.XZ),
            tallShroom("tall_mistshroom", 0, 0, Material.PLANTS, MaterialColor.CYAN_TERRACOTTA).hitbox(13, 30).offset(Block.OffsetType.XZ),
            fingeredGrass("fingered_grass").hitbox(12, 12).offset(Block.OffsetType.XYZ),
            smallGlowingGrowable("lumen_bud", 0, 0, 10, Material.PLANTS, MaterialColor.CYAN_TERRACOTTA, () -> (TallPlantBlock) TALL_LUMEN_BUD).hitbox(13, 14).offset(Block.OffsetType.XZ),
            tallGlowingPlant("tall_lumen_bud", 0, 0, 10, Material.PLANTS, MaterialColor.CYAN_TERRACOTTA).hitbox(13, 30).offset(Block.OffsetType.XZ),
            glowingBush("runebush", 0, 0, 10, Material.PLANTS, MaterialColor.CYAN).hitbox(12, 13).offset(Block.OffsetType.XZ),
            wetPlant("bogweed", 0, 0, 14, Material.PLANTS, MaterialColor.LIME).hitbox(12, 12).offset(Block.OffsetType.XZ),
            crystalotus("crystalotus"),
            suavis("suavis"),
            violeaf("violeaf").hitbox(7, 10).offset(Block.OffsetType.XYZ),
            tendrilweed("tendrilweed").hitbox(9, 14).offset(Block.OffsetType.XZ),
            nightReed("night_reed").hitbox(13, 11),
            directionalPlant("deceitful_moss", 0.3, 0, Material.PLANTS, MaterialColor.BLUE_TERRACOTTA).hitbox(16, 2),
            floatingAlgae("deceitful_algae", 0, 0, Material.OCEAN_PLANT, MaterialColor.BLUE_TERRACOTTA).hitbox(16, 1),

            reedThatch("reed_thatch", MaterialColor.PURPLE, () -> CUT_REED_THATCH),
            thatch("cut_reed_thatch", MaterialColor.PURPLE),

            rockshroom("rockshroom"),

            crystalRock("rouxe_rock", 4, 4, 2, MaterialColor.RED),
            crystalRock("bloomcrystal_rock", 4, 4, 14, MaterialColor.PINK),
            crystal("rouxe", 4, 4, 3, MaterialColor.RED).hitbox(13, 12).offset(AbstractBlock.OffsetType.XZ),
            crystal("bloomcrystal", 4, 4, 15, MaterialColor.PINK).hitbox(13, 12).offset(AbstractBlock.OffsetType.XZ),
            crystalFlower("crystal_flower", 0, 0, Material.PLANTS, MaterialColor.PINK).hitbox(13, 13).offset(AbstractBlock.OffsetType.XZ),


            stone("dark_pearl_ore", 3, 6, MaterialColor.OBSIDIAN),
            darkPearl("dark_pearl_block", 3, 6, MaterialColor.BLACK),

            stone("archaic_ore", 3, 6, MaterialColor.OBSIDIAN),
            glass("archaic_glass"),
            glassPane("archaic_glass_pane"),

            ore("tenebrum_ore", 3, 3, MaterialColor.OBSIDIAN, 3),
            rareMetal("tenebrum_block", 6.7, 8, MaterialColor.BLACK, 3),

            ore("nagrilite_ore", 3, 3, MaterialColor.OBSIDIAN, 2),
            metal("nagrilite_block", 5, 6, MaterialColor.BLACK, 2),

            xpOre("ebonite_ore", 3, 3, MaterialColor.OBSIDIAN, 1, 0, 2),
            brittleMetal("ebonite_block", 3, 5, MaterialColor.BLACK, 1),

            viriluxOre("virilux_ore"),
            virilux("virilux_block")
        );
    }



    /////////////////////////
    ///// ITEM REGISTRY /////
    /////////////////////////

    public static void registerItems(IRegistry<Item> registry) {
        registry.registerAll(
            item(NIGHTSTONE, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),
            item(NIGHT_BEDROCK, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),
            item(TRENCHSTONE, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),

            item(NIGHT_DIRT, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),
            item(COARSE_NIGHT_DIRT, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),
            item(NIGHT_GRASS_BLOCK, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),
            item(DECEITFUL_PEAT, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),
            item(DECEITFUL_MUD, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),
            item(STRANGE_SAND, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),
            item(NIGHT_MYCELIUM, MnItemCategory.SEDIMENTAL, MnItemGroup.BLOCKS),

            item(NIGHTSTONE_BRICKS, MnItemCategory.BRICKS, MnItemGroup.BLOCKS),
            item(TRENCHSTONE_BRICKS, MnItemCategory.BRICKS, MnItemGroup.BLOCKS),
            item(SHROOMBRICKS, MnItemCategory.BRICKS, MnItemGroup.BLOCKS),

            item(NIGHT_GRASS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TALL_NIGHT_GRASS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(GHOST_PLANT_STEM, MnItemCategory.UNCATEGORIZED, MnItemGroup.BLOCKS),
            item(GHOST_PLANT_LEAF, MnItemCategory.UNCATEGORIZED, MnItemGroup.BLOCKS),
            item(GHOST_PLANT, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(DEAD_WOOD_LOG, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(STRIPPED_DEAD_WOOD_LOG, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(DEAD_WOOD, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(STRIPPED_DEAD_WOOD, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(DEAD_WOOD_PLANKS, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(DEAD_SAPLING, MnItemCategory.SAPLINGS, MnItemGroup.DECOR),

            item(SHADOWROOT_LOG, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(STRIPPED_SHADOWROOT_LOG, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(SHADOWROOT_WOOD, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(STRIPPED_SHADOWROOT_WOOD, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(SHADOWROOT_LEAVES, MnItemCategory.LEAVES, MnItemGroup.DECOR),
            item(SHADOWROOT_PLANKS, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(SHADOWROOT_SAPLING, MnItemCategory.SAPLINGS, MnItemGroup.DECOR),
            item(SHADOWROOT_BOOKSHELF, MnItemCategory.UNCATEGORIZED, MnItemGroup.BLOCKS),

            item(DARK_WILLOW_LOG, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(STRIPPED_DARK_WILLOW_LOG, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(DARK_WILLOW_WOOD, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(STRIPPED_DARK_WILLOW_WOOD, MnItemCategory.LOGS, MnItemGroup.BLOCKS),
            item(DARK_WILLOW_LEAVES, MnItemCategory.LEAVES, MnItemGroup.DECOR),
            item(HANGING_DARK_WILLOW_LEAVES, MnItemCategory.LEAVES, MnItemGroup.DECOR),
            item(DARK_WILLOW_PLANKS, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(DARK_WILLOW_SAPLING, MnItemCategory.SAPLINGS, MnItemGroup.DECOR),
            item(DARK_WILLOW_BOOKSHELF, MnItemCategory.UNCATEGORIZED, MnItemGroup.BLOCKS),

            item(NIGHTSHROOM_CAP, MnItemCategory.SHROOM_CAPS, MnItemGroup.BLOCKS),
            item(NIGHTSHROOM_STEM, MnItemCategory.SHROOM_STEMS, MnItemGroup.BLOCKS),
            item(NIGHTSHROOM_PLANKS, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(NIGHTSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TALL_NIGHTSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(NIGHTSHROOM_SHELF, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(NIGHTSHROOM_FIBRE, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(NIGHTSHROOM_ROOTS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(FLOWERING_NIGHTSHROOM_ROOTS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(DEWSHROOM_CAP, MnItemCategory.SHROOM_CAPS, MnItemGroup.BLOCKS),
            item(DEWSHROOM_STEM, MnItemCategory.SHROOM_STEMS, MnItemGroup.BLOCKS),
            item(DEWSHROOM_PLANKS, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(DEWSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TALL_DEWSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(DEWSHROOM_SHELF, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(DEWSHROOM_FIBRE, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(DEWSHROOM_ROOTS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(FLOWERING_DEWSHROOM_ROOTS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(VIRIDSHROOM_CAP, MnItemCategory.SHROOM_CAPS, MnItemGroup.BLOCKS),
            item(VIRIDSHROOM_STEM, MnItemCategory.SHROOM_STEMS, MnItemGroup.BLOCKS),
            item(VIRIDSHROOM_PLANKS, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(VIRIDSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TALL_VIRIDSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(VIRIDSHROOM_SHELF, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(VIRIDSHROOM_FIBRE, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(VIRIDSHROOM_ROOTS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(FLOWERING_VIRIDSHROOM_ROOTS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(MOONSHROOM_CAP, MnItemCategory.SHROOM_CAPS, MnItemGroup.BLOCKS),
            item(MOONSHROOM_STEM, MnItemCategory.SHROOM_STEMS, MnItemGroup.BLOCKS),
            item(MOONSHROOM_PLANKS, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(MOONSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TALL_MOONSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(MOONSHROOM_SHELF, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(MOONSHROOM_FIBRE, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(MOONSHROOM_ROOTS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(FLOWERING_MOONSHROOM_ROOTS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(BOGSHROOM_CAP, MnItemCategory.SHROOM_CAPS, MnItemGroup.BLOCKS),
            item(BOGSHROOM_STEM, MnItemCategory.SHROOM_STEMS, MnItemGroup.BLOCKS),
            item(BOGSHROOM_PLANKS, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(BOGSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TALL_BOGSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(BOGSHROOM_SHELF, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(BOGSHROOM_FIBRE, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(MISTSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TALL_MISTSHROOM, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(FINGERED_GRASS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(LUMEN_BUD, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TALL_LUMEN_BUD, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(RUNEBUSH, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(BOGWEED, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(CRYSTALOTUS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(SUAVIS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(VIOLEAF, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(TENDRILWEED, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(NIGHT_REED, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(DECEITFUL_MOSS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(DECEITFUL_ALGAE, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(REED_THATCH, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),
            item(CUT_REED_THATCH, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),

            item(GLOB_FUNGUS, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),
            item(GLOB_FUNGUS_CAP, MnItemCategory.SHROOM_CAPS, MnItemGroup.BLOCKS),
            item(GLOB_FUNGUS_STEM, MnItemCategory.SHROOM_STEMS, MnItemGroup.BLOCKS),
            item(INFESTED_GLOB_FUNGUS_STEM, MnItemCategory.SHROOM_STEMS, MnItemGroup.BLOCKS),
            item(GLOB_FUNGUS_HYPHAE, MnItemCategory.SHROOM_STEMS, MnItemGroup.BLOCKS),
            item(GLOB_FUNGUS_THATCH, MnItemCategory.PLANKS, MnItemGroup.BLOCKS),

            item(ROCKSHROOM, MnItemCategory.SHROOM_CAPS, MnItemGroup.BLOCKS),

            item(ROUXE_ROCK, MnItemCategory.CRYSTALS, MnItemGroup.BLOCKS),
            item(BLOOMCRYSTAL_ROCK, MnItemCategory.CRYSTALS, MnItemGroup.BLOCKS),
            item(ROUXE, MnItemCategory.CRYSTALS, MnItemGroup.DECOR),
            item(BLOOMCRYSTAL, MnItemCategory.CRYSTALS, MnItemGroup.DECOR),
            item(CRYSTAL_FLOWER, MnItemCategory.COMMON_PLANTS, MnItemGroup.DECOR),

            item(DARK_PEARL_ORE, MnItemCategory.ORES, MnItemGroup.BLOCKS),
            item(DARK_PEARL_BLOCK, MnItemCategory.MINERAL_BLOCKS, MnItemGroup.BLOCKS),

            item(ARCHAIC_ORE, MnItemCategory.ORES, MnItemGroup.BLOCKS),
            item(ARCHAIC_GLASS, MnItemCategory.UNCATEGORIZED, MnItemGroup.BLOCKS),
            item(ARCHAIC_GLASS_PANE, MnItemCategory.UNCATEGORIZED, MnItemGroup.BLOCKS),

            item(TENEBRUM_ORE, MnItemCategory.ORES, MnItemGroup.BLOCKS),
            item(TENEBRUM_BLOCK, MnItemCategory.MINERAL_BLOCKS, MnItemGroup.BLOCKS),

            item(NAGRILITE_ORE, MnItemCategory.ORES, MnItemGroup.BLOCKS),
            item(NAGRILITE_BLOCK, MnItemCategory.MINERAL_BLOCKS, MnItemGroup.BLOCKS),

            item(EBONITE_ORE, MnItemCategory.ORES, MnItemGroup.BLOCKS),
            item(EBONITE_BLOCK, MnItemCategory.MINERAL_BLOCKS, MnItemGroup.BLOCKS),

            item(VIRILUX_ORE, MnItemCategory.ORES, MnItemGroup.BLOCKS),
            item(VIRILUX_BLOCK, MnItemCategory.MINERAL_BLOCKS, MnItemGroup.BLOCKS)
        );
    }


    ///////////////////////////
    ///// COMMON REGISTRY /////
    ///////////////////////////

    public static void setup() {
        GeodeHardMaterials.addMaterial(Material.ROCK);
        GeodeHardMaterials.addMaterial(Material.IRON);
        GeodeHardMaterials.addMaterial(Material.SHULKER);
        GeodeHardMaterials.addMaterial(Material.ANVIL);
        GeodeHardMaterials.addMaterial(MnMaterials.CRYSTAL_ROCK);
        GeodeHardMaterials.addMaterial(MnMaterials.VIRILUX);
    }


    ///////////////////////////
    ///// CLIENT REGISTRY /////
    ///////////////////////////

    @OnlyIn(Dist.CLIENT)
    public static void setupRenderers() {
        RenderTypeLookup.setRenderLayer(NIGHT_GRASS_BLOCK, RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(NIGHT_GRASS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TALL_NIGHT_GRASS, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(GHOST_PLANT_STEM, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GHOST_PLANT_LEAF, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GHOST_PLANT, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(DEAD_SAPLING, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(SHADOWROOT_LEAVES, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(SHADOWROOT_SAPLING, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(DARK_WILLOW_LEAVES, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(HANGING_DARK_WILLOW_LEAVES, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DARK_WILLOW_SAPLING, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(NIGHTSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TALL_NIGHTSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(NIGHTSHROOM_FIBRE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(NIGHTSHROOM_SHELF, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(NIGHTSHROOM_ROOTS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FLOWERING_NIGHTSHROOM_ROOTS, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(DEWSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TALL_DEWSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DEWSHROOM_FIBRE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DEWSHROOM_SHELF, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DEWSHROOM_ROOTS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FLOWERING_DEWSHROOM_ROOTS, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(VIRIDSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TALL_VIRIDSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VIRIDSHROOM_FIBRE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VIRIDSHROOM_SHELF, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VIRIDSHROOM_ROOTS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FLOWERING_VIRIDSHROOM_ROOTS, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(MOONSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TALL_MOONSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MOONSHROOM_FIBRE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MOONSHROOM_SHELF, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MOONSHROOM_ROOTS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FLOWERING_MOONSHROOM_ROOTS, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(BOGSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TALL_BOGSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BOGSHROOM_FIBRE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BOGSHROOM_SHELF, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(GLOB_FUNGUS, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(MISTSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TALL_MISTSHROOM, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FINGERED_GRASS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(LUMEN_BUD, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TALL_LUMEN_BUD, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RUNEBUSH, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BOGWEED, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CRYSTALOTUS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VIOLEAF, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(TENDRILWEED, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(NIGHT_REED, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DECEITFUL_MOSS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DECEITFUL_ALGAE, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ROUXE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BLOOMCRYSTAL, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CRYSTAL_FLOWER, RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ARCHAIC_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ARCHAIC_GLASS_PANE, RenderType.getTranslucent());


        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        ItemColors itemColors = Minecraft.getInstance().getItemColors();

        blockColors.register(
            (state, world, pos, tint) -> {
                if (pos == null || world == null) return 0x9A63B8;
                int color = MidnightClient.get().getNightGrassColorCache().getColor(pos, MnBiomeColors.NIGHT_GRASS);
                return MnUtil.modifyGrassColor(color, pos);
            },
            NIGHT_GRASS_BLOCK
        );
        itemColors.register(
            (stack, tint) -> 0x9A63B8,
            NIGHT_GRASS_BLOCK
        );

        blockColors.register(
            (state, world, pos, tint) -> {
                if (pos == null || world == null) return 0x8C74A1;
                int color = MidnightClient.get().getNightGrassColorCache().getColor(pos, MnBiomeColors.NIGHT_GRASS);
                color = MnUtil.modifyGrassColor(color, pos);
                color = ColorUtil.darker(color, 0.3);
                return color;
            },
            NIGHT_GRASS, TALL_NIGHT_GRASS
        );
        itemColors.register(
            (stack, tint) -> 0x8C74A1,
            NIGHT_GRASS, TALL_NIGHT_GRASS
        );

        blockColors.register(
            (state, world, pos, tint) -> {
                if (pos == null || world == null) return 0x3A3154;
                return MidnightClient.get().getShadowrootColorCache().getColor(pos, MnBiomeColors.SHADOWROOT);
            },
            SHADOWROOT_LEAVES
        );
        itemColors.register(
            (stack, tint) -> 0x3A3154,
            SHADOWROOT_LEAVES
        );
    }




    private MnBlocks() {
    }

    /////////////////////////////////
    ///// BLOCK FACTORY METHODS /////
    /////////////////////////////////

    private static BlockItem item(Block block, MnItemCategory cat, Item.Properties props) {
        ResourceLocation id = block.getRegistryName();
        assert id != null;
        BlockItem item;
        if (block instanceof ICustomBlockItem) {
            item = ((ICustomBlockItem) block).newBlockItem(props);
        } else {
            item = new BlockItem(block, props);
        }
        item.setRegistryName(id);
        cat.add(item);
        return item;
    }

    private static BlockItem item(Block block, MnItemCategory cat, ItemGroup group) {
        return item(block, cat, new Item.Properties().group(group));
    }

    private static <B extends Block> B block(String id, B block) {
        block.setRegistryName(Midnight.id(id));
        return block;
    }

    private static Block stone(String id, double hardness, double resistance, MaterialColor color) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.ROCK, color)
                                    .sound(SoundType.STONE)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .requiresTool()
        ));
    }

    private static Block bricks(String id, double hardness, double resistance, MaterialColor color) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.ROCK, color)
                                    .sound(SoundType.NETHER_BRICKS)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .requiresTool()
        ));
    }

    private static Block ore(String id, double hardness, double resistance, MaterialColor color, int toolLevel) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.ROCK, color)
                                    .sound(SoundType.STONE)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .harvestLevel(toolLevel)
                                    .requiresTool()
        ));
    }

    private static Block xpOre(String id, double hardness, double resistance, MaterialColor color, int toolLevel, int minxp, int maxxp) {
        return block(id, new XPDroppingBlock(
            AbstractBlock.Properties.create(Material.ROCK, color)
                                    .sound(SoundType.STONE)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .harvestLevel(toolLevel)
                                    .requiresTool(),
            minxp, maxxp
        ));
    }

    private static Block mycelium(String id, double hardness, double resistance, MaterialColor color) {
        return block(id, new NightMyceliumBlock(
            AbstractBlock.Properties.create(Material.ROCK, color)
                                    .sound(SoundType.NYLIUM)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static Block dirt(String id, MaterialColor color) {
        return block(id, new NightDirtBlock(
            AbstractBlock.Properties.create(Material.EARTH, color)
                                    .sound(SoundType.GROUND)
                                    .hardnessAndResistance(0.5f)
                                    .harvestTool(ToolType.SHOVEL)
        ));
    }

    private static Block peat(String id, MaterialColor color) {
        return block(id, new NightDirtBlock(
            AbstractBlock.Properties.create(Material.EARTH, color)
                                    .sound(MnSoundTypes.PEAT)
                                    .hardnessAndResistance(0.5f)
                                    .harvestTool(ToolType.SHOVEL)
        ));
    }

    private static Block grassBlock(String id) {
        return block(id, new NightGrassBlock(
            AbstractBlock.Properties.create(Material.EARTH, MaterialColor.PURPLE_TERRACOTTA)
                                    .sound(SoundType.PLANT)
                                    .hardnessAndResistance(0.6f)
                                    .harvestTool(ToolType.SHOVEL)
                                    .tickRandomly()
        ));
    }

    private static Block mud(String id) {
        return block(id, new DeceitfulMudBlock(
            AbstractBlock.Properties.create(Material.EARTH, MaterialColor.BLUE_TERRACOTTA)
                                    .sound(MnSoundTypes.MUD)
                                    .hardnessAndResistance(0.5f)
                                    .harvestTool(ToolType.SHOVEL)
        ));
    }

    private static Block sand(String id) {
        return block(id, new StrangeSandBlock(
            AbstractBlock.Properties.create(Material.SAND, MaterialColor.BLUE_TERRACOTTA)
                                    .sound(SoundType.SAND)
                                    .hardnessAndResistance(0.5f)
                                    .harvestTool(ToolType.SHOVEL)
        ));
    }

    private static Block water(String id, Supplier<FlowingFluid> fluid) {
        return block(id, new FlowingFluidBlock(
            fluid,
            AbstractBlock.Properties.create(Material.WATER)
                                    .hardnessAndResistance(100)
        ));
    }

    private static Block crystalRock(String id, double hardness, double resistance, int luminance, MaterialColor color) {
        return block(id, new Block(
            AbstractBlock.Properties.create(MnMaterials.CRYSTAL_ROCK, color)
                                    .sound(MnSoundTypes.CRYSTAL)
                                    .luminance(state -> luminance)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .requiresTool()
        ));
    }

    private static CrystalBlock crystal(String id, double hardness, double resistance, int luminance, MaterialColor color) {
        return block(id, new CrystalBlock(
            AbstractBlock.Properties.create(MnMaterials.CRYSTAL, color)
                                    .sound(MnSoundTypes.CRYSTAL)
                                    .luminance(state -> luminance)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .nonOpaque()
                                    .requiresTool()
        ));
    }

    private static Block rockshroom(String id) {
        return block(id, new RockshroomBlock(
            AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK)
                                    .sound(SoundType.NETHERRACK)
                                    .hardnessAndResistance(1.2f, 4)
                                    .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static Block shroombricks(String id) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK)
                                    .sound(SoundType.BASALT)
                                    .hardnessAndResistance(1.2f, 4)
                                    .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static PlantBlock plant(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new PlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock crystalFlower(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new PlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock bush(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new PlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.SWEET_BERRY_BUSH)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static DirectionalPlantBlock directionalPlant(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new DirectionalPlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.CROP)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static FloatingPlantBlock floatingAlgae(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new FloatingPlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.WET_GRASS)
                                    .hardnessAndResistance((float) hardness, (float) resistance),
            fluid -> fluid == MnFluids.DARK_WATER
        ));
    }

    private static PlantBlock glowingBush(String id, double hardness, double resistance, int emission, Material material, MaterialColor color) {
        return block(id, new PlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.SWEET_BERRY_BUSH)
                                    .luminance(state -> emission)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock wetPlant(String id, double hardness, double resistance, int emission, Material material, MaterialColor color) {
        return block(id, new PlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.WET_GRASS)
                                    .luminance(state -> emission)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock fingeredGrass(String id) {
        return block(id, new FingeredGrassBlock(
            AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.BLUE)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .hardnessAndResistance(0, 0)
        ));
    }

    private static PlantBlock emissivePlant(String id, double hardness, double resistance, int emission, Material material, MaterialColor color) {
        return block(id, new PlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .luminance(state -> emission)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock ghostPlant(String id, double hardness, double resistance, int emission, Material material, MaterialColor color) {
        return block(id, new PlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.ROOTS)
                                    .luminance(state -> emission)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static TallPlantBlock tallPlant(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new TallPlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock smallGrowable(String id, double hardness, double resistance, Material material, MaterialColor color, Supplier<TallPlantBlock> tall) {
        return block(id, new SmallGrowablePlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .hardnessAndResistance((float) hardness, (float) resistance),
            tall
        ));
    }

    private static TallPlantBlock tallGlowingPlant(String id, double hardness, double resistance, int emission, Material material, MaterialColor color) {
        return block(id, new TallPlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .luminance(state -> emission)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock smallGlowingGrowable(String id, double hardness, double resistance, int emission, Material material, MaterialColor color, Supplier<TallPlantBlock> tall) {
        return block(id, new SmallGrowablePlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .luminance(state -> emission)
                                    .hardnessAndResistance((float) hardness, (float) resistance),
            tall
        ));
    }

    private static TallPlantBlock tallShroom(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new TallPlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.FUNGUS)
                                    .luminance(state -> 10)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock smallShroom(String id, double hardness, double resistance, Material material, MaterialColor color, Supplier<TallPlantBlock> tall) {
        return block(id, new SmallGrowablePlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.FUNGUS)
                                    .luminance(state -> 10)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance((float) hardness, (float) resistance),
            tall
        ));
    }

    private static PlantBlock smallFungus(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new PlantBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.FUNGUS)
                                    .luminance(state -> 10)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static PlantBlock shroomRoots(String id, Material material, MaterialColor color) {
        return block(id, new ShroomRootsBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.ROOTS)
                                    .hardnessAndResistance(0, 0)
        ));
    }

    private static ShroomShelfBlock shelf(String id, double hardness, double resistance, Material material, MaterialColor color) {
        return block(id, new ShroomShelfBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.FUNGUS)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
        ));
    }

    private static CrystalotusBlock crystalotus(String id) {
        return block(id, new CrystalotusBlock(
            AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.LIGHT_BLUE)
                                    .nonOpaque()
                                    .sound(MnSoundTypes.CRYSTAL)
                                    .luminance(state -> 13)
                                    .hardnessAndResistance(0.2f, 0.5f)
        ));
    }

    private static Block suavis(String id) {
        return block(id, new SuavisBlock(
            AbstractBlock.Properties.create(Material.GOURD, MaterialColor.LIGHT_BLUE)
                                    .nonOpaque()
                                    .sound(SoundType.HONEY)
                                    .luminance(state -> state.get(SuavisBlock.STAGE) * 3 + 3)
                                    .tickRandomly()
                                    .suffocates((state, world, pos) -> state.get(SuavisBlock.STAGE) == 3)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance(1f, 0.2f)
        ));
    }

    private static VioleafBlock violeaf(String id) {
        return block(id, new VioleafBlock(
            AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.PURPLE)
                                    .nonOpaque()
                                    .sound(SoundType.WET_GRASS)
                                    .tickRandomly()
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance(0)
        ));
    }

    private static TendrilweedBlock tendrilweed(String id) {
        return block(id, new TendrilweedBlock(
            AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.RED)
                                    .nonOpaque()
                                    .sound(SoundType.ROOTS)
                                    .tickRandomly()
                                    .hardnessAndResistance(0.1f, 0)
        ));
    }

    private static NightReedBlock nightReed(String id) {
        return block(id, new NightReedBlock(
            AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.ADOBE)
                                    .nonOpaque()
                                    .sound(SoundType.WET_GRASS)
                                    .tickRandomly()
                                    .hardnessAndResistance(0)
                                    .emissiveLighting((state, world, pos) -> !state.get(NightReedBlock.WATERLOGGED))
                                    .luminance(state -> state.get(NightReedBlock.WATERLOGGED) ? 0 : 10)
        ));
    }

    private static PlantBlock fibre(String id, Material material, MaterialColor color) {
        return block(id, new FibreBlock(
            AbstractBlock.Properties.create(material, color)
                                    .nonOpaque()
                                    .sound(SoundType.NETHER_SPROUTS)
                                    .hardnessAndResistance(0, 0)
        ));
    }

    private static Block giantGhostPlant(String id, Function<Block.Properties, Block> factory) {
        return block(id, factory.apply(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW)
                                    .nonOpaque()
                                    .sound(SoundType.SHROOMLIGHT)
                                    .hardnessAndResistance(0.3f)
                                    .luminance(state -> 15)
        ));
    }

    private static Block leaves(String id, MaterialColor color) {
        return block(id, new LeavesBlock(
            AbstractBlock.Properties.create(Material.LEAVES, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .harvestTool(ToolType.HOE)
                                    .suffocates((state, world, pos) -> false)
                                    .hardnessAndResistance(0.2f)
        ));
    }

    private static Block growsHangingLeaves(String id, MaterialColor color, Supplier<Block> hanging) {
        return block(id, new HangingLeavesGrowingBlock(
            AbstractBlock.Properties.create(Material.LEAVES, color)
                                    .nonOpaque()
                                    .sound(SoundType.PLANT)
                                    .harvestTool(ToolType.HOE)
                                    .suffocates((state, world, pos) -> false)
                                    .hardnessAndResistance(0.2f),
            hanging
        ));
    }

    private static HangingLeavesBlock hangingLeaves(String id, MaterialColor color, Supplier<Block> leaves, ITag.INamedTag<Block> logs) {
        return block(id, new HangingLeavesBlock(
            AbstractBlock.Properties.create(Material.LEAVES, color)
                                    .nonOpaque()
                                    .harvestTool(ToolType.HOE)
                                    .sound(SoundType.CROP) // Make them sound a bit less leafier
                                    .hardnessAndResistance(0.1f),
            leaves, logs
        ));
    }

    private static Block log(String id, MaterialColor color, Supplier<Block> stripped) {
        return block(id, new StripableRotatedPillarBlock(
            AbstractBlock.Properties.create(Material.WOOD, color)
                                    .sound(SoundType.WOOD)
                                    .harvestTool(ToolType.AXE)
                                    .hardnessAndResistance(2f),
            stripped
        ));
    }

    private static Block log(String id, MaterialColor color) {
        return block(id, new RotatedPillarBlock(
            AbstractBlock.Properties.create(Material.WOOD, color)
                                    .sound(SoundType.WOOD)
                                    .harvestTool(ToolType.AXE)
                                    .hardnessAndResistance(2f)
        ));
    }

    private static Block stem(String id, MaterialColor color) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.ORGANIC, color)
                                    .sound(SoundType.NETHER_STEM)
                                    .harvestTool(ToolType.AXE)
                                    .hardnessAndResistance(2f)
        ));
    }

    private static Block globStem(String id, MaterialColor color) {
        return block(id, new RotatedPillarBlock(
            AbstractBlock.Properties.create(Material.ORGANIC, color)
                                    .sound(SoundType.NETHER_STEM)
                                    .harvestTool(ToolType.AXE)
                                    .hardnessAndResistance(1.7f)
        ));
    }

    private static Block infestedGlobStem(String id, MaterialColor color) {
        return block(id, new HorizontalFacingBlock(
            AbstractBlock.Properties.create(Material.ORGANIC, color)
                                    .sound(SoundType.NETHER_STEM)
                                    .harvestTool(ToolType.AXE)
                                    .hardnessAndResistance(0.4f)
        ));
    }

    private static Block thatch(String id, MaterialColor color) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.ORGANIC, color)
                                    .sound(SoundType.WART_BLOCK)
                                    .harvestTool(ToolType.HOE)
                                    .hardnessAndResistance(0.8f)
        ));
    }

    private static Block reedThatch(String id, MaterialColor color, Supplier<Block> cut) {
        return block(id, new ShearableBlock(
            AbstractBlock.Properties.create(Material.ORGANIC, color)
                                    .sound(SoundType.WART_BLOCK)
                                    .harvestTool(ToolType.HOE)
                                    .luminance(state -> 8)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .hardnessAndResistance(0.8f),
            cut
        ));
    }

    private static Block wood(String id, MaterialColor color) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.WOOD, color)
                                    .sound(SoundType.WOOD)
                                    .harvestTool(ToolType.AXE)
                                    .hardnessAndResistance(2f)
        ));
    }

    private static Block bookshelf(String id, MaterialColor color) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.WOOD, color)
                                    .sound(SoundType.WOOD)
                                    .hardnessAndResistance(1.5f)
        ));
    }

    private static Block shroomAir(String id) {
        return block(id, new ShroomAirBlock(
            AbstractBlock.Properties.create(Material.AIR, MaterialColor.AIR)
                                    .nonOpaque()
                                    .suffocates((state, world, pos) -> false)
                                    .luminance(state -> 15)
                                    .noDrops()
        ));
    }

    private static Block shroomCap(String id, MaterialColor color, int sporeColor) {
        return block(id, new ShroomCapBlock(
            AbstractBlock.Properties.create(Material.ORGANIC, color)
                                    .harvestTool(ToolType.HOE)
                                    .hardnessAndResistance(1.7f)
                                    .sound(SoundType.WART_BLOCK),
            sporeColor
        ));
    }

    private static Block globCap(String id, MaterialColor color) {
        return block(id, new BouncyShroomCapBlock(
            AbstractBlock.Properties.create(Material.ORGANIC, color)
                                    .harvestTool(ToolType.HOE)
                                    .hardnessAndResistance(1.1f)
                                    .luminance(state -> 15)
                                    .sound(SoundType.SLIME)
        ));
    }

    private static Block darkPearl(String id, double hardness, double resistance, MaterialColor color) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.IRON, color)
                                    .nonOpaque()
                                    .sound(SoundType.BONE)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .requiresTool()
        ));
    }

    private static Block metal(String id, double hardness, double resistance, MaterialColor color, int harvestLevel) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.IRON, color)
                                    .sound(SoundType.METAL)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .harvestLevel(harvestLevel)
                                    .requiresTool()
        ));
    }

    private static Block brittleMetal(String id, double hardness, double resistance, MaterialColor color, int harvestLevel) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.IRON, color)
                                    .sound(MnSoundTypes.BRITTLE_METAL)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .harvestLevel(harvestLevel)
                                    .requiresTool()
        ));
    }

    private static Block rareMetal(String id, double hardness, double resistance, MaterialColor color, int harvestLevel) {
        return block(id, new Block(
            AbstractBlock.Properties.create(Material.IRON, color)
                                    .sound(SoundType.NETHERITE)
                                    .hardnessAndResistance((float) hardness, (float) resistance)
                                    .harvestTool(ToolType.PICKAXE)
                                    .harvestLevel(harvestLevel)
                                    .requiresTool()
        ));
    }

    private static Block glass(String id) {
        return block(id, new GlassBlock(
            AbstractBlock.Properties.create(Material.GLASS, MaterialColor.PINK)
                                    .nonOpaque()
                                    .sound(SoundType.GLASS)
                                    .hardnessAndResistance(0.3F)
        ));
    }

    private static Block glassPane(String id) {
        return block(id, new PaneBlock(
            AbstractBlock.Properties.create(Material.GLASS, MaterialColor.PINK)
                                    .nonOpaque()
                                    .sound(SoundType.GLASS)
                                    .hardnessAndResistance(0.3F)
        ));
    }

    private static Block virilux(String id) {
        return block(id, new Block(
            AbstractBlock.Properties.create(MnMaterials.VIRILUX, MaterialColor.LIME)
                                    .sound(MnSoundTypes.JEWEL)
                                    .hardnessAndResistance(6.5F, 8)
                                    .harvestTool(ToolType.PICKAXE)
                                    .harvestLevel(3)
                                    .luminance(state -> 15)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .requiresTool()
        ));
    }

    private static Block viriluxOre(String id) {
        return block(id, new XPDroppingBlock(
            AbstractBlock.Properties.create(Material.ROCK, MaterialColor.OBSIDIAN)
                                    .sound(SoundType.STONE)
                                    .hardnessAndResistance(5, 5)
                                    .harvestTool(ToolType.PICKAXE)
                                    .harvestLevel(3)
                                    .luminance(state -> 4)
                                    .emissiveLighting((state, world, pos) -> true)
                                    .requiresTool(),
            3, 6
        ));
    }

    @Nonnull
    @SuppressWarnings("ConstantConditions")
    private static Block inj() {
        return null;
    }
}
