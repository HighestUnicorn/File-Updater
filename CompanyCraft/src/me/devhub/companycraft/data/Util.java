package me.devhub.companycraft.data;

import me.devhub.companycraft.CompanyCraft;
import me.devhub.companycraft.CreateCompany;
import me.devhub.companycraft.event.PlayerJoin;

import org.bukkit.Bukkit;

public class Util {
	
	CompanyCraft plugin;
	public Util(CompanyCraft plugin) {
		this.plugin = plugin;
	}
	
	public void setupListeners() {
		org.bukkit.plugin.PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(plugin), plugin);
	}
	
	public void setupCommands() {
		plugin.getCommand("Company").setExecutor(new CreateCompany());
	}

}
