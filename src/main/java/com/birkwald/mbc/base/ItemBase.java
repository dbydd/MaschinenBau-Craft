package com.birkwald.mbc.base;

import com.birkwald.mbc.materials.MBCMaterials;
import com.birkwald.mbc.materials.MaterialItems;
import com.birkwald.mbc.utils.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String itemname) {
        setTranslationKey(itemname);
        setRegistryName(itemname);
        setCreativeTab(MBCMaterials.MBCMaterials);
        MaterialItems.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
//        MBCMaterials
    }
}
