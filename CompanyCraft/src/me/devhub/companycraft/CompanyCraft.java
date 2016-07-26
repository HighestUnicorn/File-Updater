package me.devhub.companycraft;

import me.devhub.companycraft.state.BusinessState;
import me.devhub.companycraft.state.Util;

import org.bukkit.plugin.java.JavaPlugin;

public class CompanyCraft extends JavaPlugin {
	
	public BusinessState state;
	Util util;
	
	public void onEnable() {
		state = BusinessState.DEFAULT;
		util = new Util(this);
		
		util.setupListeners();
	}
	
	public void onDisable() {
		
	}

}
