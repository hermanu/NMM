package com.manu.nomoremining.init;

import com.manu.nomoremining.tileentity.TileEntityInfuser;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Manu on 14/02/2016.
 */
public class ModTileEntities {



    public static void init(){

        GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
    }


}
