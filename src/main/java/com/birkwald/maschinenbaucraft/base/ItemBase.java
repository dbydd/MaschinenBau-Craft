package com.birkwald.maschinenbaucraft.base;

import com.birkwald.maschinenbaucraft.materials.MBCMaterials;
import com.birkwald.maschinenbaucraft.materials.MaterialItems;
import com.birkwald.maschinenbaucraft.utils.IHasModel;
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
