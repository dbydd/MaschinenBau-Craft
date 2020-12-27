package com.birkwald.maschinenbaucraft.materials;

import com.birkwald.maschinenbaucraft.MaschinenBau_Craft;
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
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(MaschinenBau_Craft.MODID, item.getTranslationKey().substring(5)), "inventory"));
    }
}
