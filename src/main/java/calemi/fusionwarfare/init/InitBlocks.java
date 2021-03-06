package calemi.fusionwarfare.init;

import calemi.fusionwarfare.block.BlockAuraBase;
import calemi.fusionwarfare.block.BlockBasicMachineBase;
import calemi.fusionwarfare.block.BlockChargedPlant;
import calemi.fusionwarfare.block.BlockFusionTorch;
import calemi.fusionwarfare.block.BlockNetworkBeacon;
import calemi.fusionwarfare.block.BlockNetworkCable;
import calemi.fusionwarfare.block.BlockNetworkController;
import calemi.fusionwarfare.block.BlockNetworkGate;
import calemi.fusionwarfare.block.BlockOreBase;
import calemi.fusionwarfare.block.BlockReactorCoolingUnit;
import calemi.fusionwarfare.block.BlockReinforceable;
import calemi.fusionwarfare.block.BlockReinforceableGlass;
import calemi.fusionwarfare.block.BlockReinforcedDoor;
import calemi.fusionwarfare.block.BlockSteelCasing;
import calemi.fusionwarfare.block.BlockSupplyCrate;
import calemi.fusionwarfare.block.BlockTwoInputs;
import calemi.fusionwarfare.recipe.EnumRecipeType;
import calemi.fusionwarfare.tileentity.gen.TileEntityAquaGenerator;
import calemi.fusionwarfare.tileentity.gen.TileEntityGeothermalGenerator;
import calemi.fusionwarfare.tileentity.gen.TileEntitySolarGenerator;
import calemi.fusionwarfare.tileentity.gen.TileEntityWindTurbine;
import calemi.fusionwarfare.tileentity.machine.TileEntityAuraMatterReinforcer;
import calemi.fusionwarfare.tileentity.machine.TileEntityAuraMobTurret;
import calemi.fusionwarfare.tileentity.machine.TileEntityAuraPlayerHealer;
import calemi.fusionwarfare.tileentity.machine.TileEntityAuraPlayerTurret;
import calemi.fusionwarfare.tileentity.machine.TileEntityEMPTower;
import calemi.fusionwarfare.tileentity.machine.TileEntityEXPFabricator;
import calemi.fusionwarfare.tileentity.machine.TileEntityEnergeticFurnace;
import calemi.fusionwarfare.tileentity.machine.TileEntityMiningUnit;
import calemi.fusionwarfare.tileentity.machine.TileEntityMissileLauncher;
import calemi.fusionwarfare.tileentity.machine.TileEntityMissileSiloCore;
import calemi.fusionwarfare.tileentity.machine.TileEntityOreEnricher;
import calemi.fusionwarfare.tileentity.machine.TileEntityRFConverter;
import calemi.fusionwarfare.tileentity.reactor.TileEntityAdvancedHydroReactorCore;
import calemi.fusionwarfare.tileentity.reactor.TileEntityCapsuleCore;
import calemi.fusionwarfare.tileentity.reactor.TileEntityReactorCore;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;

public class InitBlocks {
	
	//#-#-#-#-#-ORE-#-#-#-#-#\\
	
	public static Block infused_crystal_ore;
	public static Block infused_catalyst_ore;
	public static Block infused_azurite_ore;
	
	//#-#-#-#-#-BUILDING-#-#-#-#-#\\
	
	public static Block fusion_torch;
	
	public static Block concrete;
	public static Block reinforced_glass;
	
	public static Block black_brick;
	public static Block blue_brick;
	public static Block red_brick;
	
	public static Block steel_casing;
	
	public static Block reinforced_door;
	
	//#-#-#-#-#-NETWORK-#-#-#-#-#\\
	
	public static Block network_controller_1;
	public static Block network_controller_2;
	public static Block network_controller_3;
	public static Block network_cable;	
	public static Block network_gate;
	public static Block network_beacon;
	
	//#-#-#-#-#-GENERATORS-#-#-#-#-#\\
	
	public static Block aqua_generator;
	public static Block solar_generator;
	public static Block geothermal_generator;
	public static Block wind_turbine;
	
	//#-#-#-#-#-REACTORS-#-#-#-#-#\\
	
	public static Block reactor_core;
	public static Block reactor_cooling_unit;
	
	public static Block advanced_hydro_reactor_core;
	public static Block capsule_core;
	
	//#-#-#-#-#-MACHINES-#-#-#-#-#\\
	
	public static Block infusion_table;
	public static Block infusion_foundry;
	public static Block energetic_furnace;
	public static Block ore_enricher;
	public static Block mining_unit;
	public static Block missile_factory;
	public static Block missile_launcher;
	public static Block missile_silo_core;
	public static Block exp_fabricator;	
	public static Block emp_tower;
		
	public static Block aura_player_turret;	
	public static Block aura_matter_reinforcer;
	public static Block aura_mob_turret;
	public static Block aura_player_healer;
	
	public static Block rf_converter;
	
	//#-#-#-#-#-MISC-#-#-#-#-#\\
		
	public static Block charged_plant;
	public static Block supply_crate;
	
	public static void init() {
		
		//#-#-#-#-#-ORE-#-#-#-#-#\\
		
		infused_crystal_ore = new BlockOreBase("infused_crystal_ore", InitItems.infused_crystal, 1, 2, 3, 7);
		infused_catalyst_ore = new BlockOreBase("infused_catalyst_ore", InitItems.infused_catalyst, 1, 1, 3, 7);
		infused_azurite_ore = new BlockOreBase("infused_azurite_ore", InitItems.infused_azurite, 1, 2, 0, 2);		
		
		//#-#-#-#-#-BUILDING-#-#-#-#-#\\
		
		fusion_torch = new BlockFusionTorch();
		
		concrete = new BlockReinforceable("concrete", 5);
		reinforced_glass = new BlockReinforceableGlass("reinforced_glass", 3);
				
		black_brick = new BlockReinforceable("black_brick", 5);
		blue_brick = new BlockReinforceable("blue_brick", 5);
		red_brick = new BlockReinforceable("red_brick", 5);
		
		steel_casing = new BlockSteelCasing();
		
		reinforced_door = new BlockReinforcedDoor();
		
		//#-#-#-#-#-NETWORK-#-#-#-#-#\\
	
		network_controller_1 = new BlockNetworkController(1);
		network_controller_2 = new BlockNetworkController(2);
		network_controller_3 = new BlockNetworkController(3);
		network_cable = new BlockNetworkCable();
		network_gate = new BlockNetworkGate();
		network_beacon = new BlockNetworkBeacon();
		
		//#-#-#-#-#-GENERATORS-#-#-#-#-#\\
		
		aqua_generator = new BlockBasicMachineBase("aqua_generator", TileEntityAquaGenerator.class).setAllFourSideImages();
		solar_generator = new BlockBasicMachineBase("solar_generator", TileEntitySolarGenerator.class).setTopImage();		
		geothermal_generator = new BlockBasicMachineBase("geothermal_generator", TileEntityGeothermalGenerator.class).setTopImage("mech_top_3").setAllFourSideImages();
		wind_turbine = new BlockBasicMachineBase("wind_turbine", TileEntityWindTurbine.class).setDirectional();		
		
		//#-#-#-#-#-REACTORS-#-#-#-#-#\\
		
		reactor_core = new BlockBasicMachineBase("reactor_core", TileEntityReactorCore.class).setAllSideImages();
		reactor_cooling_unit = new BlockReactorCoolingUnit();
		
		advanced_hydro_reactor_core = new BlockBasicMachineBase("advanced_hydro_reactor_core", TileEntityAdvancedHydroReactorCore.class).setTopImage().setAllFourSideImages();
		capsule_core = new BlockBasicMachineBase("capsule_core", TileEntityCapsuleCore.class).setAllSideImages();
	
		//#-#-#-#-#-MACHINES-#-#-#-#-#\\
		
		infusion_table = new BlockTwoInputs("infusion_table", EnumRecipeType.INFUSION_TABLE).setTopImage().setAllFourSideImages();	
		infusion_foundry = new BlockTwoInputs("infusion_foundry", EnumRecipeType.INFUSION_FOUNDRY);	
		missile_factory = new BlockTwoInputs("missile_factory", EnumRecipeType.MISSILE_FACTORY).setTopImage().setAllFourSideImages();	
		
		energetic_furnace = new BlockBasicMachineBase("energetic_furnace", TileEntityEnergeticFurnace.class).setDirectional();
		ore_enricher = new BlockBasicMachineBase("ore_enricher", TileEntityOreEnricher.class).setDirectional();			
		mining_unit = new BlockBasicMachineBase("mining_unit", TileEntityMiningUnit.class).setBottomImage().setAllFourSideImages();	
		missile_launcher = new BlockBasicMachineBase("missile_launcher", TileEntityMissileLauncher.class).setHasCustomModel().setBounds(1, 0, 1, 15, 4, 15);
		missile_silo_core = new BlockBasicMachineBase("missile_silo_core", TileEntityMissileSiloCore.class).setAllFourSideImages();
		exp_fabricator = new BlockBasicMachineBase("exp_fabricator", TileEntityEXPFabricator.class).setTopImage().setAllFourSideImages();
		emp_tower = new BlockBasicMachineBase("emp_tower", TileEntityEMPTower.class).setHasCustomModel().setBounds(2, 0, 2, 14, 16, 14);
		
		aura_player_turret = new BlockAuraBase("player_turret", TileEntityAuraPlayerTurret.class).setHardness(50F);
		aura_matter_reinforcer = new BlockAuraBase("matter_reinforcer", TileEntityAuraMatterReinforcer.class);
		aura_mob_turret = new BlockAuraBase("mob_turret", TileEntityAuraMobTurret.class);
		aura_player_healer = new BlockAuraBase("player_healer", TileEntityAuraPlayerHealer.class);
		
		rf_converter = new BlockBasicMachineBase("rf_converter", TileEntityRFConverter.class).setAllFourSideImages();
		
		//#-#-#-#-#-MISC-#-#-#-#-#\\
		
		charged_plant = new BlockChargedPlant();
		supply_crate = new BlockSupplyCrate();
		
		OreDictionary.registerOre("oreInfusedCrystal", infused_crystal_ore);
		OreDictionary.registerOre("oreInfusedCatalyst", infused_catalyst_ore);
		OreDictionary.registerOre("oreInfusedAzurite", infused_azurite_ore);
		OreDictionary.registerOre("oreSulfur", infused_azurite_ore);
	}	
}
