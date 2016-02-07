package com.manu.nomoremining.blocks;

import com.manu.nomoremining.NoMoreMining;
import com.manu.nomoremining.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Manu on 07/02/2016.
 */
public class BlocksNMM
{
    public static Block test_block;

    public static void init()
    {
        test_block = new Block(Material.cactus).setUnlocalizedName("test_block").setCreativeTab(NoMoreMining.tabNMM);
    }

    public static void register()
    {
        GameRegistry.registerBlock(test_block,test_block.getUnlocalizedName().substring(5));

    }

    public static void registerRenders()
    {
        registerRender(test_block);
    }

    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":"+ item.getUnlocalizedName().substring(5),"inventory"));

    }
}
