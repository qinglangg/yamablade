package in.theworld.yamablade;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import in.theworld.yamablade.init.InitProxy;

public class ClientProxy extends CommonProxy{
	
	 public void preInit(FMLPreInitializationEvent event) {
		 super.preInit(event);
	 }
	 
	 public void init(FMLInitializationEvent event) {
		 super.init(event);
		 InitProxy.proxy.initializeItemRenderer();
	 }
	 
	 public void postInit(FMLPostInitializationEvent event) {
		 super.postInit(event);
	 }
}
