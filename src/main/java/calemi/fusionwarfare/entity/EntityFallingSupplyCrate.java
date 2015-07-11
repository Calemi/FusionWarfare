package calemi.fusionwarfare.entity;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import calemi.fusionwarfare.block.BlockSupplyCrate;
import calemi.fusionwarfare.init.InitBlocks;
import calemi.fusionwarfare.item.ItemMissile;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityFallingSupplyCrate extends Entity {

	public static int meta;
	
	public EntityFallingSupplyCrate(World world) {
		super(world);
	}

	public EntityFallingSupplyCrate(int meta, World world, int x, int z) {
		super(world);
		this.meta = meta;
		this.posX = x - 1;
		this.posY = 256;
		this.posZ = z - 1;
		motionY -= 0.1F;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		posX += motionX;
		posY += motionY;
		posZ += motionZ;
					
		if (!worldObj.isRemote) {
			
			if (posY < 0) {
				setDead();
			}
		
			
			if (!worldObj.isAirBlock((int)posX, (int)posY, (int)posZ)) {
				
				setDead();
				checkForAir((int)posX, (int)posY, (int)posZ);
			}
		}
	}
	
	private void checkForAir(int x, int y, int z) {
		
		if (worldObj.isAirBlock(x, y, z) || worldObj.getBlock(x, y, z).isReplaceable(worldObj, x, y, z)) {		
			
			worldObj.setBlock(x, y, z, InitBlocks.supply_crate);
			worldObj.setBlockMetadataWithNotify(x, y, z, meta, 2);
		}
		
		else if (y > 256) {
			return;
		}
		
		else {
			checkForAir(x, y + 1, z);
		}
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
		
	}	
}
