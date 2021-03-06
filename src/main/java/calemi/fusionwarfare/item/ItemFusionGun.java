package calemi.fusionwarfare.item;

import java.util.List;

import calemi.fusionwarfare.Reference;
import calemi.fusionwarfare.entity.DamageSourceCustom;
import calemi.fusionwarfare.entity.EntityFusionBullet;
import calemi.fusionwarfare.init.InitCreativeTabs;
import calemi.fusionwarfare.init.InitItems;
import calemi.fusionwarfare.util.GunUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemFusionGun extends ItemBase {

	public int ammoCost;
	public int hitDamage;
	public int accuracy;
	public float gravityVelocity;
	private boolean isSniper;

	public ItemFusionGun(String imagePath, int reloadTime, int ammoCost, int hitDamage, int accuracy, float gravityVelocity, boolean isSniper) {
		super(imagePath, false, false);
		setMaxStackSize(1);
		setCreativeTab(InitCreativeTabs.creativeTabInfantry);
		setMaxDamage(reloadTime);
		this.ammoCost = ammoCost;
		this.hitDamage = hitDamage;
		this.gravityVelocity = gravityVelocity;
		this.accuracy = accuracy;
		this.isSniper = isSniper;
	}

	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean b) {
		if (is.getItemDamage() > 0) list.add(EnumChatFormatting.RED + "Reloading: " + getCurrentProgress(is) * 100 / getMaxDamage() + "%");
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack is) {

		if (isSniper) {

			if (getNBT(is).getFloat("Scoping") == 0) {
				getNBT(is).setFloat("Scoping", 1);
			}

			else if (getNBT(is).getFloat("Scoping") == 1) {
				getNBT(is).setFloat("Scoping", 2);
			}

			else {
				getNBT(is).setFloat("Scoping", 0);
			}
		}
		
		return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase player, EntityLivingBase entity) {
		
		if (!isSniper) {
			
			if (player instanceof EntityPlayer && entity instanceof EntityPlayer) {
			
				entity.attackEntityFrom(new DamageSourceCustom(((EntityPlayer)entity).getDisplayName() + " was knocked out by " + ((EntityPlayer)player).getDisplayName() + "'s gun"), 4.0F);
			}
			
			else {
				entity.attackEntityFrom(DamageSource.generic, 2.0F);
			}
		}
		
		return true;
	}

	@Override
	public void onUpdate(ItemStack is, World world, Entity entity, int i1, boolean b) {

		if (!world.isRemote) {

			if (is != ((EntityPlayer) entity).inventory.getCurrentItem()) {
				getNBT(is).setFloat("Scoping", 0);
			}
			
			else {
				if (getCurrentProgress(is) < getMaxDamage()) {
					is.damageItem(-1, (EntityLivingBase) entity);
				}				
			}		
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {

		GunUtil.shootBullet(world, is, player);
		return is;
	}

	public int getCurrentProgress(ItemStack is) {
		return getMaxDamage() - is.getItemDamage();
	}

	@Override
	public boolean isFull3D() {
		return true;
	}
}
