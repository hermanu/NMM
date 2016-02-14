package com.manu.nomoremining.proxy;

import com.manu.nomoremining.init.ModBlocks;
import com.manu.nomoremining.init.ModItems;

/**
 * Created by Manu on 07/02/2016.
 */
public class ClientProxy extends CommonProxy
{

    @Override
    public void registerRenders()
    {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }
}
