package me.devhub.companycraft.event;

import me.devhub.companycraft.CompanyCraft;
import me.devhub.companycraft.data.PlayerData;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	
	public static String defaultComp = ChatColor.GRAY + " [" + ChatColor.BLUE + "JAAPEG Inc." + ChatColor.GRAY + "]" + ChatColor.RESET;
	public static String customComp;
	
	CompanyCraft plugin;
	public PlayerJoin(CompanyCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!PlayerData.data.contains("Business." + p.getName())) {
			CompanyCraft.chat.setPlayerSuffix(p, defaultComp);
			//p.sendMessage("Suffix = " + CompanyCraft.chat.getPlayerSuffix(p));
			return;
		} else {
			CompanyCraft.chat.setPlayerSuffix(p, PlayerData.data.getString("Business." + p.getName()));
			//p.sendMessage("You're suffix has been loaded!");
			return;
		}
	}

}
