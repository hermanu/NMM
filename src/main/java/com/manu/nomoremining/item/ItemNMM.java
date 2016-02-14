package com.manu.nomoremining.item;

import com.manu.nomoremining.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by Manu on 07/02/2016.
 */

public class ItemNMM extends Item
{

    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":"+ item.getUnlocalizedName().substring(5),"inventory"));
    }

}
