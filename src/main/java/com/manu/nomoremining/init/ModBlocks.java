package com.manu.nomoremining.init;

import com.manu.nomoremining.NoMoreMining;
import com.manu.nomoremining.block.BlockMachine1;
import com.manu.nomoremining.block.BlockNMM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Manu on 14/02/2016.
 */
public class ModBlocks extends BlockNMM {

    public static Block test_block;

    public static void init()
    {
        test_block = new BlockMachine1(Material.clay).setUnlocalizedName("test_block").setCreativeTab(NoMoreMining.tabNMM);
    }

    public static void register()
    {
        GameRegistry.registerBlock(test_block,test_block.getUnlocalizedName().substring(5));

    }

    public static void registerRenders()
    {
        registerRender(test_block);
    }


}
