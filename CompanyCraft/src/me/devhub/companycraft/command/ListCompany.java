package me.devhub.companycraft.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCompany implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getLabel().equalsIgnoreCase("Companies")) {
			
		}
		
		return false;
	}

}
