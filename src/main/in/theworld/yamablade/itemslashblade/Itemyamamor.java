package in.theworld.yamablade.itemslashblade;

import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Itemyamamor extends ItemSlashBladeNamed{

	public Itemyamamor(ToolMaterial par2EnumToolMaterial, float baseAttackModifiers) {
		super(par2EnumToolMaterial, baseAttackModifiers);
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		if ((target != null) && (!target.worldObj.isRemote)) {
			target.hurtResistantTime=0;
			target.onDeath(DamageSource.outOfWorld);
			target.setHealth(0.0F);
			target.attackEntityFrom(DamageSource.outOfWorld.setMagicDamage().setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), Float.MAX_VALUE);
			if((target instanceof EntityPlayer)) {
				EntityPlayer victim = (EntityPlayer)target;
				victim.heal(Float.MAX_VALUE);
				victim.attackEntityFrom(DamageSource.outOfWorld.setMagicDamage().setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), Float.MAX_VALUE);
				victim.setHealth(0.0F);
			}
		}
		return super.hitEntity(stack, target, attacker);
	}
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		if (EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, stack) <= 0) {
			stack.addEnchantment(Enchantment.looting, 9);
		}
		 super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
