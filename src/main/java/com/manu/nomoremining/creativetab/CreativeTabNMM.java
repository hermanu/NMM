package com.manu.nomoremining.creativetab;

import com.manu.nomoremining.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Manu on 07/02/2016.
 */
public class CreativeTabNMM extends CreativeTabs {

    public CreativeTabNMM(String label) {
        super(label);

    }

    @Override
    public Item getTabIconItem() {
        return ModItems.mob_encloser;
    }
}