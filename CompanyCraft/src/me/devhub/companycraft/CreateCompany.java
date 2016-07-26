package me.devhub.companycraft;

import me.devhub.companycraft.data.PlayerData;
import me.devhub.companycraft.event.PlayerJoin;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateCompany implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getLabel().equalsIgnoreCase("Company")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.GRAY + "=====" + ChatColor.GOLD + "CompanyCraft" + ChatColor.GRAY + "=====");
				p.sendMessage("/Company Create [Name] - Creates a company for $25000");
			}
			
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("Create")) {
					if(args.length == 1) {
					p.sendMessage(ChatColor.RED + "Please Specify A Company Name!");
					return false;
					}
					if(args.length >= 2) {
					String name1 = args[1];
					String name2 = args[2];
					String companyName = name1 + " " + name2;
					if(CompanyCraft.econ.getBalance(p.getName()) >= 25000) {
						if(!PlayerData.data.contains("Business." + p.getName())) {
						EconomyResponse r = CompanyCraft.econ.withdrawPlayer(p.getName(), 25000);
						if(r.transactionSuccess()) {
						p.sendMessage(ChatColor.GOLD + "You have purchased a company with the name " + ChatColor.BLUE + companyName + ChatColor.GOLD + "!");
						p.sendMessage(ChatColor.GOLD + "Total Cost: " + ChatColor.WHITE + "$25,000");
						PlayerJoin.customComp = ChatColor.GRAY + " [" + ChatColor.BLUE + companyName + ChatColor.GRAY + "]" + ChatColor.RESET;
						CompanyCraft.chat.setPlayerSuffix(p, PlayerJoin.customComp);
						PlayerData.data.set("Business." + p.getName(), PlayerJoin.customComp);
						PlayerData.saveData();
						return true;
						}
						} else {
						p.sendMessage(ChatColor.RED + "You already have a company!");
						p.sendMessage(ChatColor.RED + "Please use " + ChatColor.BLUE + "/Company Buy [Company]" + ChatColor.RED + " to purchase a player's company.");
						return false;
						}
					} else {
						p.sendMessage(ChatColor.RED + "You do not have sufficient funds to purchase a company.");
						return false;
					}
					}
				}
			}
		}
		
		
		return false;
	}
	
	

}
