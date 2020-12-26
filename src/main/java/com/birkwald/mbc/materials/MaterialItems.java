package com.birkwald.mbc.materials;

import com.birkwald.mbc.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import java.util.ArrayList;
import java.util.List;

public class MaterialItems {
    public static String[] materialList = {
            "",
    };

    public static final List<Item> ITEMS = new ArrayList<>();

    public static void registerRenderItem(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getTranslationKey().substring(5)), "inventory"));
    }
}
