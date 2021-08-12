package com.midsummer380.baicair;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
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
            .of(Material.METAL)
            .breakByHand(false)
            .breakByTool(FabricToolTags.PICKAXES, 3));


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "chinese_cabbage"), CHINESE_CABBAGE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "a_words"), AWORDS);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "a_words_block"), AWORDS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MODID, "a_words_block"), new BlockItem(AWORDS_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
    }

}