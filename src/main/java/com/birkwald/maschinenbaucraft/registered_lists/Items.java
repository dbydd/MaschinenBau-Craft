package com.birkwald.maschinenbaucraft.registered_lists;

import com.birkwald.maschinenbaucraft.MaschinenBau_Craft;
import com.birkwald.maschinenbaucraft.base.ItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import java.util.ArrayList;
import java.util.HashMap;

public class Items {
    public static final HashMap<String, Item> ITEMS = new HashMap<>();

    public static void registerRenderItem(ItemBase item) {
        if (item.getHasSubtypes()) {
            ArrayList<String> subtypeList = item.getSubtypeList();
            int size = subtypeList.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(new ResourceLocation(MaschinenBau_Craft.MODID, item.getRegistryName().getPath() + "/" + subtypeList.get(i)), "inventory"));
            }
        } else {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(MaschinenBau_Craft.MODID, item.getRegistryName().getPath()), "inventory"));
        }
    }
}
