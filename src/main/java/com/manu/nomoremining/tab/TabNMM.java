package com.manu.nomoremining.tab;

import com.manu.nomoremining.item.ItemNMM;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Manu on 07/02/2016.
 */
public class TabNMM extends CreativeTabs
{

    public TabNMM (String label)
    {
        super(label);

    }
    @Override
    public Item getTabIconItem() {
        return ItemNMM.mob_encloser;
    }
}
