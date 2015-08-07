package calemi.fusionwarfare.event;

import java.util.Random;

import calemi.fusionwarfare.init.InitItems;
import calemi.fusionwarfare.item.tool.ItemArmorBase;
import calemi.fusionwarfare.item.tool.ItemSwordBase;
import calemi.fusionwarfare.util.EnumColorUtil;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntitySpawnEvent {
	
	Random rand = new Random();
	
	@SubscribeEvent
	public void livingSpawnEvent(LivingSpawnEvent event) {				
		addArmorAndWeapons(event.entityLiving);
	}
	
	private void addArmorAndWeapons(EntityLivingBase entity) {
		
		if (entity instanceof EntityMob && !(entity instanceof EntityWitch) && !(entity instanceof EntityEnderman)) {		
			
			if (rand.nextInt(100) == 0) {
				
				entity.setCurrentItemOrArmor(0, new ItemStack(InitItems.steel.sword));
				entity.setCurrentItemOrArmor(4, new ItemStack(InitItems.steel.helmet));
				entity.setCurrentItemOrArmor(3, new ItemStack(InitItems.steel.chestplate));
				entity.setCurrentItemOrArmor(2, new ItemStack(InitItems.steel.leggings));
				entity.setCurrentItemOrArmor(1, new ItemStack(InitItems.steel.boots));
			}
			
			if (rand.nextInt(800) == 0) {
				
				ItemStack sword = new ItemStack(InitItems.infused_steel.sword);
				ItemStack helmet = new ItemStack(InitItems.infused_steel.helmet);
				ItemStack chestplate = new ItemStack(InitItems.infused_steel.chestplate);
				ItemStack leggings = new ItemStack(InitItems.infused_steel.leggings);
				ItemStack boots = new ItemStack(InitItems.infused_steel.boots);
								
				ItemStack[] armor = new ItemStack[]{helmet, chestplate, leggings, boots};
				
				int colorID = rand.nextInt(15);
				
				EnumColorUtil[] colors = EnumColorUtil.values();
				
				int hex = colors[colorID].hex;
				
				((ItemSwordBase)sword.getItem()).getNBT(sword).setInteger("color", hex);
				
				for (ItemStack armorStack : armor) {
					
					((ItemArmorBase)armorStack.getItem()).getNBT(armorStack).setInteger("color", hex);	
				}
				
				entity.setCurrentItemOrArmor(0, sword);
				entity.setCurrentItemOrArmor(4, armor[0]);
				entity.setCurrentItemOrArmor(3, armor[1]);
				entity.setCurrentItemOrArmor(2, armor[2]);
				entity.setCurrentItemOrArmor(1, armor[3]);						
			}					
		}
	}
}
