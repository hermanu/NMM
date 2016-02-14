package com.manu.nomoremining.block;

import com.manu.nomoremining.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Manu on 14/02/2016.
 */
public abstract class BlockNMMTileEntity extends BlockContainer {

    public BlockNMMTileEntity(Material material){
        super(material);
    }

    public BlockNMMTileEntity(){
        this(Material.rock);
    }

    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":"+ item.getUnlocalizedName().substring(5),"inventory"));

    }
}
