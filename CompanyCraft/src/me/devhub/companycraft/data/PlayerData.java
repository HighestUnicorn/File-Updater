package me.devhub.companycraft.data;

import java.io.File;
import java.io.IOException;

import me.devhub.companycraft.CompanyCraft;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerData {
	
	CompanyCraft plugin;
	public PlayerData(CompanyCraft plugin) {
		this.plugin = plugin;
	}
	
	public static File dataFile;
	public static FileConfiguration data;
	
	public void createConfig() {
		if(dataFile == null) {
			dataFile = new File(plugin.getDataFolder() + "/data", "playerBusiness.yml");
		}
		data = YamlConfiguration.loadConfiguration(dataFile);
		init();
	}
	
	public void init() {
		saveData();
	}
	
	public static void saveData() {
		try {
			data.save(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
