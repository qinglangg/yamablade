package in.theworld.yamablade.init;

import cpw.mods.fml.common.SidedProxy;

public class InitProxy {
	 @SidedProxy(clientSide="in.theworld.yamablade.init.InitProxyClient", serverSide="in.theworld.yamablade.init.InitProxy")
	 public static InitProxy proxy;
	 
	 public void initializeItemRenderer() {}
	 
}
