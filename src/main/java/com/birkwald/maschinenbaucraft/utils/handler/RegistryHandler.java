package com.birkwald.maschinenbaucraft.utils.handler;

import com.birkwald.maschinenbaucraft.MaschinenBau_Craft;
import com.birkwald.maschinenbaucraft.registered_lists.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {
    // ItemRegistry
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(Items.ITEMS.values().toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        OBJLoader.INSTANCE.addDomain(MaschinenBau_Craft.MODID);
    }

    public static void preInitRegistries(FMLPreInitializationEvent event) {

    }

    public static void initRegistries(FMLInitializationEvent event) {

    }

    public static void postInitRegistries(FMLPostInitializationEvent event) {

    }

    public static void serverRegistries(FMLServerStartingEvent event) {

    }
}
