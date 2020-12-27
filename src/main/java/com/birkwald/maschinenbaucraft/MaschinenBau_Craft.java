package com.birkwald.maschinenbaucraft;

import com.birkwald.maschinenbaucraft.proxy.CommonProxy;
import com.birkwald.maschinenbaucraft.utils.handler.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Logger;

@Mod(modid = MaschinenBau_Craft.MODID, name = MaschinenBau_Craft.NAME, version = MaschinenBau_Craft.Version, useMetadata = true)
public class MaschinenBau_Craft {
    public static final String MODID = "maschinen_bau_craft";
    public static final String NAME = "MaschinenBau Craft";
    public static final String Version = "1.0.0";


    public static final String CLIENT_PROXY_CLASS = "com.birkwald.maschinenbaucraft.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.birkwald.maschinenbaucraft.proxy.CommonProxy";

    @Mod.Instance
    public static MaschinenBau_Craft instance;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    private static SimpleNetworkWrapper network;
    // log
    private static Logger logger;

    // network
    public static SimpleNetworkWrapper getNetwork() {
        return network;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.preInitRegistries(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RegistryHandler.initRegistries(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RegistryHandler.postInitRegistries(event);
    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegistries(event);
    }
}
