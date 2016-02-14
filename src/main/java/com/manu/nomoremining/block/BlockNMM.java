package com.manu.nomoremining.block;

import com.manu.nomoremining.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by Manu on 07/02/2016.
 */
public class BlockNMM extends Block
{

    public BlockNMM (Material material){
        super(material);
    }

    public BlockNMM(){
        this(Material.rock);
    }


    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":"+ item.getUnlocalizedName().substring(5),"inventory"));

    }

}
