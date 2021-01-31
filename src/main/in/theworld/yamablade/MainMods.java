package in.theworld.yamablade;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import in.theworld.yamablade.event.PlayerDeathEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="yamablade", name="The fianlly blade of magic", version="0.0.1", dependencies="required-after:flammpfeil.slashblade")
public class MainMods {
	 public static final String MODID = "yamablade";
	 public static final String MODNAME = "The fianlly blade of magic";
	 public static final String version = "0.01";
	 public static final String author = "HANLING";
	 @Mod.Instance("yamablade")
	 public static MainMods instance;
	 @SidedProxy(clientSide="in.theworld.yamablade.ClientProxy", serverSide="in.theworld.yamablade.CommonProxy")
	 public static CommonProxy proxy1;
	 
	 @Mod.EventHandler
	 public void preInit(FMLPreInitializationEvent event) {
		 proxy1.preInit(event);
	 }
	 @Mod.EventHandler
	 public void init(FMLInitializationEvent event) {
		 proxy1.init(event);
	 }
	 @Mod.EventHandler
	 public void postInit(FMLPostInitializationEvent event) {	 
		 proxy1.postInit(event);
	 }
	 @Mod.EventHandler
	  public void load(FMLInitializationEvent event)
	  {
		 MinecraftForge.EVENT_BUS.register(new PlayerDeathEvent());
	  }

}
