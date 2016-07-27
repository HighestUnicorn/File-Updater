package me.devhub.companycraft.api;

import me.devhub.companycraft.data.PlayerData;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CompanyAPI {
	
	public FileConfiguration getConfig() {
		return PlayerData.data;
	}
	
	public String getCompanyName(Player p) {
		return getConfig().getString("Business." + p.getName());
	}
	
	public Integer getCompanyValue(Player p) {
		return getConfig().getInt("Business." + p.getName() + ".CompanyValue");
	}
	
	public void setCompanyValue(Player p, Integer value) {
		getConfig().set("Business." + p.getName() + ".CompanyValue", value);
	}
	
	public void saveConfig() {
		PlayerData.saveData();
	}

}
