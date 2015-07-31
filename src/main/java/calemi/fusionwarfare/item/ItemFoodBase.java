package calemi.fusionwarfare.item;

import calemi.fusionwarfare.init.InitCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemFood;

public class ItemFoodBase extends ItemFood {

	public ItemFoodBase(String imagePath, int foodAmount, float saturation, boolean isWolfsFavorateMeat) {
		super(foodAmount, saturation, isWolfsFavorateMeat);
		setUnlocalizedName(imagePath);
		setCreativeTab(InitCreativeTabs.creativeTabCore);
		GameRegistry.registerItem(this, imagePath);
	}
}
