package com.manu.nomoremining.item;

import com.manu.nomoremining.NoMoreMining;
import com.manu.nomoremining.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Manu on 07/02/2016.
 */
public class ItemNMM
{



    public static Item mob_encloser;

    public static void init()
    {
        mob_encloser = new ItemMobEncloser().setUnlocalizedName("mob_encloser").setCreativeTab(NoMoreMining.tabNMM);

    }
    public static void register()
    {
        GameRegistry.registerItem(mob_encloser, mob_encloser.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRender(mob_encloser);
    }

    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":"+ item.getUnlocalizedName().substring(5),"inventory"));
    }
}
