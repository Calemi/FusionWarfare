package calemi.fusionwarfare.config;

import calemi.fusionwarfare.FusionWarfare;
import calemi.fusionwarfare.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class FWConfig {
	
	public static Configuration config = FusionWarfare.config;
	
	public static boolean disableWelcomeChat;
	public static boolean disableFreeWrench;
	public static boolean disableFallingCrates;
	public static boolean disableZombieArmor;
	public static boolean disableHighTierWeaponRecipes;
	public static boolean disableTooltips;
	public static boolean drawInfoTextOnRight;
	
	public static boolean disableScopeHUD;
	public static boolean disableScubaHUD;
	
	public static boolean disableInfusedCrystalOre;
	public static boolean disableInfusedCatalystOre;
	public static boolean disableInfusedAzuriteOre;
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
				
		if (event.modID.equals(Reference.MOD_ID)) {
			syncConfig();
		}
	}
	
	public static void syncConfig() {	
		FMLCommonHandler.instance().bus().register(FusionWarfare.instance);
		
		final String GENERAL_OPTIONS = config.CATEGORY_GENERAL + config.CATEGORY_SPLITTER + "General Options";
		config.setCategoryLanguageKey(GENERAL_OPTIONS, "category.general_options.name");
		config.addCustomCategoryComment(GENERAL_OPTIONS, "General options for Fusion Warfare.");
		
		disableWelcomeChat = config.getBoolean("Disable Welcome Chat", GENERAL_OPTIONS, false, "Disables welcome chat.");
		disableFreeWrench = config.getBoolean("Disable Free Wrench", GENERAL_OPTIONS, false, "Disables the free wrench that spawns when you first join a world.");
		disableFallingCrates = config.getBoolean("Disable Falling Supply Crates", GENERAL_OPTIONS, false, "Disables Supply Crates from falling.");
		disableZombieArmor = config.getBoolean("Disable Zombie Armor", GENERAL_OPTIONS, false, "Disables Zombies from spawning with armor.");
		disableHighTierWeaponRecipes = config.getBoolean("Disable High Tier Weapon Recipes", GENERAL_OPTIONS, true, "Disables high tier weapon recipes. Recommended false if Supply Crates are enabled.");
		disableTooltips = config.getBoolean("Disable Custom Tooltips", GENERAL_OPTIONS, false, "Disables custom tooltips on armor and tools.");
		drawInfoTextOnRight = config.getBoolean("Disable Info Text on Right", GENERAL_OPTIONS, false, "Places info text on the right side of the gui.");
		
		final String GUI = config.CATEGORY_GENERAL + config.CATEGORY_SPLITTER + "GUI";
		config.setCategoryLanguageKey(GUI, "category.gui.name");
		config.addCustomCategoryComment(GUI, "Disable certain GUIs.");
		
		disableScopeHUD = config.getBoolean("Disable Scope HUD Overlay", GUI, false, "Disables the sniping scope HUD overlay.");
		disableScopeHUD = config.getBoolean("Disable Scuba HUD Overlay", GUI, false, "Disables the Scuba Helmet HUD overlay.");
		
		final String ORES = config.CATEGORY_GENERAL + config.CATEGORY_SPLITTER + "Ores";
		config.setCategoryLanguageKey(ORES, "category.ores.name");
		config.addCustomCategoryComment(ORES, "Disable ores from spawning.");
		
		disableInfusedCrystalOre = config.getBoolean("Disable Infused Crystal Ore", ORES, false, "Disables this ore from spawning.");
		disableInfusedCatalystOre = config.getBoolean("Disable Infused Catalyst Ore", ORES, false, "Disables this ore from spawning.");
		disableInfusedAzuriteOre = config.getBoolean("Disable Infused Azurite Ore", ORES, false, "Disables this ore from spawning.");
		
		if (config.hasChanged()) {
			config.save();
		}
	}
}
