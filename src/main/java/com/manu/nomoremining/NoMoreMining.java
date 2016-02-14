package com.manu.nomoremining;

import com.manu.nomoremining.configuration.ConfigurationHandler;
import com.manu.nomoremining.init.ModBlocks;
import com.manu.nomoremining.init.ModItems;
import com.manu.nomoremining.proxy.CommonProxy;
import com.manu.nomoremining.reference.Reference;
import com.manu.nomoremining.tab.TabNMM;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION)
public class NoMoreMining
{

    @Mod.Instance("NoMoreMining")
    public static NoMoreMining instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    public static final TabNMM tabNMM = new TabNMM("tabNMM");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModBlocks.init();
        ModBlocks.register();
        ModItems.init();
        ModItems.register();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        proxy.registerRenders();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
