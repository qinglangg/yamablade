package in.theworld.yamablade.init;

import in.theworld.yamablade.CommonProxy;
import mods.flammpfeil.slashblade.ItemRendererBaseWeapon;
import net.minecraftforge.client.MinecraftForgeClient;

public class InitProxyClient extends InitProxy{
	
	public void initializeItemRenderer()	
		{
		ItemRendererBaseWeapon renderer = new ItemRendererBaseWeapon();
		MinecraftForgeClient.registerItemRenderer(CommonProxy.blade001, renderer);
		}

}
