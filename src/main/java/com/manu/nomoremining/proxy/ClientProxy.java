package com.manu.nomoremining.proxy;

import com.manu.nomoremining.blocks.BlocksNMM;
import com.manu.nomoremining.item.ItemNMM;
import paulscode.sound.CommandObject;

/**
 * Created by Manu on 07/02/2016.
 */
public class ClientProxy extends CommonProxy
{

    @Override
    public void registerRenders()
    {
        ItemNMM.registerRenders();
        BlocksNMM.registerRenders();
    }
}
