package me.devhub.companycraft.command;

import java.util.ArrayList;

import me.devhub.companycraft.data.PlayerData;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCompany implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		Player p = (Player) sender;
		if(cmd.getLabel().equalsIgnoreCase("Companies")) {
			CreateCompany.list = (ArrayList<String>) PlayerData.data.getStringList("Businesses");
			p.sendMessage(ChatColor.GOLD + "=====" + ChatColor.WHITE + "Companies" + ChatColor.GOLD + "=====");
			for(int i = 0; i < CreateCompany.list.size(); i++) {
				p.sendMessage(i + 1 + ". " + ChatColor.BLUE + "'" + ChatColor.WHITE + CreateCompany.list.get(i).toString() + ChatColor.BLUE + "'" + ChatColor.WHITE + ": $" + CreateCompany.value);
			}
			p.sendMessage(ChatColor.GOLD + "==================");
				return true;
			}
		
		return false;
	}

}
