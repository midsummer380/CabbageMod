package com.midsummer380.baicair;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {

    public static final String MODID = "baicair";

    //items
    public static final Item CHINESE_CABBAGE = new Item(new Item.Settings()
            .group(ItemGroup.MISC)
            .food((new FoodComponent.Builder())
                    .hunger(3)
                    .snack()
                    .saturationModifier(0.5F)
                    .build()));

    public static final Item CABBAGE_WITH_POTATO = new Item(new Item.Settings()
            .group(ItemGroup.MISC)
            .food((new FoodComponent.Builder())
                    .hunger(6)
                    .snack()
                    .saturationModifier(0.6F)
                    .build()));

    public static final Item AWORDS = new Item(new Item.Settings()
            .group(ItemGroup.MISC));

    //blocks
    public static final Block AWORDS_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .hardness(2.0f)
            .breakByTool(FabricToolTags.PICKAXES, 0));

    //crops
    public static final CropBlock CABBAGE_CROP = new CabbageCrop(AbstractBlock.Settings
            .of(Material.PLANT)
            .nonOpaque()
            .noCollision()
            .ticksRandomly()
            .breakInstantly()
            .sounds(BlockSoundGroup.CROP));

    public static final Item CABBAGE_SEED = new AliasedBlockItem(Main.CABBAGE_CROP, new Item.Settings().group(ItemGroup.MISC));


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "chinese_cabbage"), CHINESE_CABBAGE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "baicaiduntudou"), CABBAGE_WITH_POTATO);
        Registry.register(Registry.ITEM, new Identifier(MODID, "a_words"), AWORDS);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "a_words_block"), AWORDS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MODID, "a_words_block"), new BlockItem(AWORDS_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("baicair","cabbage_crop"), CABBAGE_CROP);
        Registry.register(Registry.ITEM, new Identifier("baicair","cabbage_seed"), CABBAGE_SEED);
    }

}