package me.devhub.companycraft.api;

import me.devhub.companycraft.data.PlayerData;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CompanyAPI {
	
	public static String getPlayerCompany(Player pl) {
		return PlayerData.data.getString("Business." + pl.getName() + ".CompanyName");
	}

	public static Integer getCompanyValue(Player pl) {
		return PlayerData.data.getInt("Business." + pl.getName() + ".CompanyValue");
	}

	public static FileConfiguration getCompanyConfig() {
		return PlayerData.data;
	}

}
