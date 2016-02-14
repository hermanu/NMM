package com.manu.nomoremining.init;

import com.manu.nomoremining.NoMoreMining;
import com.manu.nomoremining.item.ItemMobEncloser;
import com.manu.nomoremining.item.ItemNMM;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * Created by Manu on 07/02/2016.
 */
public class ModItems extends ItemNMM
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



}
