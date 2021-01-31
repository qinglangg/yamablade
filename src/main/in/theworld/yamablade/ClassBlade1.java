package in.theworld.yamablade;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.RecipeAwakeBlade;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.named.event.LoadEvent;
import mods.flammpfeil.slashblade.stats.AchievementList;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;

public class ClassBlade1 {
	public static String name = "flammpfeil.slashblade.named.yama1";
	String namey = "flammpfeil.slashblade.named.yamato";
	
	@SubscribeEvent
	  public void init(LoadEvent.InitEvent event)
	  {
		 ItemStack customblade = new ItemStack(CommonProxy.blade001, 1, 0);    
		 NBTTagCompound tag = new NBTTagCompound();
		 customblade.setTagCompound(tag);
		 customblade.addEnchantment(Enchantment.looting, 9);
		 ItemSlashBladeNamed.CurrentItemName.set(tag, this.name);
		 ItemSlashBladeNamed.IsDefaultBewitched.set(tag, Boolean.valueOf(true));
		 ItemSlashBladeNamed.CustomMaxDamage.set(tag, Integer.valueOf(100001));
		 ItemSlashBlade.TextureName.set(tag, "named/yamablade/texture");
		 ItemSlashBlade.ModelName.set(tag, "named/yamablade/model");
		 ItemSlashBlade.SpecialAttackType.set(tag, Integer.valueOf(3));
		 ItemSlashBlade.BaseAttackModifier.set(tag, 1.0E9F);
		 ItemSlashBlade.SummonedSwordColor.set(tag, Integer.valueOf(15395502));
		 GameRegistry.registerCustomItemStack(name, customblade);
		 ItemSlashBladeNamed.NamedBlades.add("flammpfeil.slashblade:" + name);
		 
		 AchievementList.registerCraftingAchievement(name, customblade, AchievementList.getAchievement(name));
		 
		 ItemStack custombladeReqiredH = GameRegistry.findItemStack("flammpfeil.slashblade", this.namey, 1);
	     NBTTagCompound reqTag = ItemSlashBlade.getItemTagCompound(custombladeReqiredH);
	     ItemSlashBlade.KillCount.set(reqTag, Integer.valueOf(5000));
	     ItemSlashBlade.ProudSoul.set(reqTag, Integer.valueOf(20000));
	     
	     ItemStack blade = SlashBlade.getCustomBlade(name);
	     
	     IRecipe recipe =new RecipeAwakeBlade(blade, custombladeReqiredH, new Object[] { "SSS", "SIS", "SSS",Character.valueOf('S'),Blocks.diamond_block,
		    		Character.valueOf('I'),custombladeReqiredH });
		            SlashBlade.addRecipe(name, recipe);     
	  }

}
