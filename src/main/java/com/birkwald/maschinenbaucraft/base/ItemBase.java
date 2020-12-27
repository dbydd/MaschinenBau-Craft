package com.birkwald.maschinenbaucraft.base;

import com.birkwald.maschinenbaucraft.registered_lists.Items;
import com.birkwald.maschinenbaucraft.registered_lists.MBCTags;
import com.birkwald.maschinenbaucraft.utils.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemBase extends Item implements IHasModel {
    private ArrayList<String> subtypeList = new ArrayList<>();

    public ItemBase(String registryName, String itemName, boolean subType, String... itemNameSuffix) {
        setRegistryName(registryName);
        setCreativeTab(MBCTags.MBCMaterials);
        setTranslationKey(registryName);
        setHasSubtypes(subType);
        subtypeList.addAll(Arrays.asList(itemNameSuffix));
        Items.ITEMS.putIfAbsent(itemName, this);
    }

    public ArrayList<String> getSubtypeList() {
        return subtypeList;
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        if (!hasSubtypes) {
            return super.getTranslationKey(stack);
        } else {
            return getTranslationKey() + "." + subtypeList.get(stack.getMetadata());
        }
    }

    @Override
    public void registerModels() {
        Items.registerRenderItem(this);
    }
}
