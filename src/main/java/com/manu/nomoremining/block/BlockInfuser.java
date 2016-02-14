package com.manu.nomoremining.block;

import com.manu.nomoremining.tileentity.TileEntityInfuser;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Manu on 14/02/2016.
 */
public class BlockInfuser extends BlockNMMTileEntity {


    public BlockInfuser(Material material){
        super(material);
    }
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {

       return new TileEntityInfuser();
    }
}
