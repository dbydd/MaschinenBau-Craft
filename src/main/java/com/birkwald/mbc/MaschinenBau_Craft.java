package com.birkwald.mbc;

import com.birkwald.mbc.proxy.CommonProxy;
import com.birkwald.mbc.utils.handler.RegistryHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.Version, useMetadata = true)
public class MaschinenBau_Craft {

    @Mod.Instance
    public static MaschinenBau_Craft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    private static SimpleNetworkWrapper network;

    // network
    public static SimpleNetworkWrapper getNetwork() {
        return network;
    }

    // log
    private static Logger logger;

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
