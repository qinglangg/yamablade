package in.theworld.yamablade.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import in.theworld.yamablade.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PlayerDeathEvent {
	
	public static boolean alwaysHave(EntityPlayer player) {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
            	ItemStack itemStack = player.inventory.getStackInSlot(i);
            		if (itemStack != null && itemStack.getItem() == CommonProxy.blade001)
            		{
            			return true;
            		}
			}
			return false;
	}
	
	@SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event) {
               	if (event.entityLiving != null && event.entityLiving instanceof EntityPlayer) {
               		EntityPlayer player = (EntityPlayer)event.entityLiving;
               		if (alwaysHave(player)) {
               			event.setCanceled(true);
               			player.setHealth(player.getMaxHealth());
               		}
               	}
    	}
	
	 @SubscribeEvent
	  public void onLivingUpdate(LivingEvent.LivingUpdateEvent event)
	  {
	    if ((event.entityLiving != null) && 
	      ((event.entityLiving instanceof EntityPlayer)))
	    	{
	    	EntityPlayer player = (EntityPlayer)event.entityLiving;
	        		if (alwaysHave(player)) 
	        		{
	        			player.capabilities.allowFlying = true;
	        		} 
	    	}
	  }
}
