package me.devhub.companycraft;

import me.devhub.companycraft.data.PlayerData;
import me.devhub.companycraft.data.Util;
import me.devhub.companycraft.state.BusinessState;

import org.bukkit.plugin.java.JavaPlugin;

public class CompanyCraft extends JavaPlugin {
	
	public BusinessState state;
	Util util;
	PlayerData data;
	
	public void onEnable() {
		state = BusinessState.DEFAULT;
		util = new Util(this);
		util.setupListeners();
		data = new PlayerData(this);
	}
	
	public void onDisable() {
		
	}

}
