package in.theworld.yamablade;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import in.theworld.yamablade.event.PlayerDeathEvent;
import in.theworld.yamablade.itemslashblade.Itemyamamor;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public static Item blade001;

	public void preInit(FMLPreInitializationEvent event) {
		blade001=new Itemyamamor(Item.ToolMaterial.IRON, 100.0F).setRepairMaterial(new ItemStack(Items.iron_ingot)).setRepairMaterialOreDic(new String[0]).setUnlocalizedName("flammpfeil.slashblade.yama1").setTextureName("flammpfeil.slashblade:proudsoul").setCreativeTab(SlashBlade.tab);
		GameRegistry.registerItem(blade001, "Yamamor");
		SlashBlade.InitEventBus.register(new ClassBlade1());
		
		SlashBlade.InitEventBus.register(MainMods.instance);
	}

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
