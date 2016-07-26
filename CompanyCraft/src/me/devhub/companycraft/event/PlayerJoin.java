package me.devhub.companycraft.event;

import me.devhub.companycraft.CompanyCraft;
import me.devhub.companycraft.state.BusinessState;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	
	public static String defaultComp = ChatColor.DARK_AQUA + "[JAAPEG Inc.]";
	
	CompanyCraft plugin;
	public PlayerJoin(CompanyCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(plugin.state == BusinessState.DEFAULT) {
			p.setDisplayName(defaultComp + p.getName());
		}
	}

}
