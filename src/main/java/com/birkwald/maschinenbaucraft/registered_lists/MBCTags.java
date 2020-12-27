package com.birkwald.maschinenbaucraft.registered_lists;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MBCTags {
    // MaterialsGroup
    public static final CreativeTabs MBCMaterials = new CreativeTabs("mbc_materials_group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };
}
