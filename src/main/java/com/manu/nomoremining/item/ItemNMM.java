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
//    public ItemNMM()
//    {
//        super();
//
//    }
//
//    @Override
//    public String getUnlocalizedName()
//    {
//        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase()+ ":",getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
//    }
//
//    @Override
//    public String getUnlocalizedName(ItemStack itemStack)
//    {
//        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() +":",getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
//    }
//
//    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
//    {
//        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
//    }


    public static Item test_item;

    public static void init()
    {
        test_item = new ItemTest().setUnlocalizedName("test_item").setCreativeTab(NoMoreMining.tabNMM);

    }
    public static void register()
    {
        GameRegistry.registerItem(test_item, test_item.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRender(test_item);
    }

    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":"+ item.getUnlocalizedName().substring(5),"inventory"));
    }
}
