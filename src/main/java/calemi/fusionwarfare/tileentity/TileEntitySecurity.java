package calemi.fusionwarfare.tileentity;

import calemi.fusionwarfare.api.ISecurity;
import calemi.fusionwarfare.tileentity.base.TileEntityEnergyBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.scoreboard.Team;
import net.minecraft.stats.ObjectiveStat;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntitySecurity extends TileEntityEnergyBase implements ISecurity {

	public String teamName;

	@Override
	public boolean isSameTeam(Team team) {
		return getTeam() == null || (team != null && getTeam().isSameTeam(team));
	}
	
	@Override
	public void setTeam(Team team) {
		teamName = team.getRegisteredName();
	}
	
	@Override
	public Team getTeam() {
		return worldObj.getScoreboard().getTeam(teamName);
	}
	
	@Override
	public void writeSyncNBT(NBTTagCompound nbt) {
		super.writeSyncNBT(nbt);
		
		if (teamName != null) {
			nbt.setString("team", teamName);
		}
	}
	
	@Override
	public void readSyncNBT(NBTTagCompound nbt) {
		super.readSyncNBT(nbt);
		
		if (nbt.hasKey("team")) {
			teamName = nbt.getString("team");
		}
	}
}
