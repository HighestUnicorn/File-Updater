package me.devhub.companycraft.command;

import java.util.List;

import me.devhub.companycraft.CompanyCraft;
import me.devhub.companycraft.api.CompanyAPI;
import me.devhub.companycraft.data.PlayerData;
import me.devhub.companycraft.event.PlayerJoin;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateCompany implements CommandExecutor {
	
	public static int value = 26000;
	
	List<String> companies;
	CompanyAPI api;
	
	String companyName;
	String prefix = ChatColor.DARK_AQUA + "[" + ChatColor.DARK_GREEN + "CompanyCraft" + ChatColor.DARK_AQUA + "]" + ChatColor.RESET;

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getLabel().equalsIgnoreCase("Company")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.GRAY + "=====" + ChatColor.GOLD + "CompanyCraft" + ChatColor.GRAY + "=====");
				p.sendMessage("/Company Create [Name] - Creates a company for $25000.");
				p.sendMessage("/Company Resign - Resign from your company and add your company value to your account.");
			}
			
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("Create")) {
					if(args.length == 1) {
					p.sendMessage(ChatColor.RED + "Please Specify A Company Name!");
					return false;
					}
					if(args.length == 2) {
					p.sendMessage(ChatColor.RED + "Please add a company registrar. E.g. Co., Inc., Etc");
					return false;
					}
					if(args.length > 2) {
						String name1 = args[1];
						String name2 = args[2];
						companyName = name1 + " " + name2;
					if(CompanyCraft.econ.getBalance(p.getName()) >= 25000) {
						if(!PlayerData.data.contains("Business." + p.getName())) {
						EconomyResponse r = CompanyCraft.econ.withdrawPlayer(p.getName(), 25000);
						if(r.transactionSuccess()) {
						p.sendMessage(ChatColor.GOLD + "You have purchased a company with the name " + ChatColor.BLUE + companyName + ChatColor.GOLD + "!");
						p.sendMessage(ChatColor.GOLD + "Total Cost: " + ChatColor.WHITE + "$25,000");
						Bukkit.broadcastMessage(prefix + " Player " + p.getName() + " has purchased a company called " + ChatColor.BLUE + companyName);
						PlayerJoin.customComp = ChatColor.BLUE + companyName + ChatColor.RESET;
						CompanyCraft.chat.setPlayerSuffix(p, ChatColor.GRAY + " [" + PlayerJoin.customComp + ChatColor.GRAY + "] " + ChatColor.RESET);
						PlayerData.data.set("Business." + p.getName(), PlayerJoin.customComp);
						PlayerData.data.set("Business." + p.getName() + ".CompanyValue", value);
						PlayerData.saveData();
						return true;
						} else {
						p.sendMessage(ChatColor.RED + "You do not have sufficient funds to purchase a company.");
						return false;	
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
				} else
					if(args[0].equalsIgnoreCase("Resign")) {
						companyName = CompanyCraft.chat.getPlayerSuffix(p);
						if(PlayerData.data.contains("Business." + p.getName())) {
						EconomyResponse r = CompanyCraft.econ.depositPlayer(p.getName(), value);
						if(r.transactionSuccess()) {
						p.sendMessage(ChatColor.GOLD + "You have resigned from your company!");
						p.sendMessage(ChatColor.GOLD + "You have earned $" + value);
						Bukkit.broadcastMessage(prefix + " Player " + p.getName() + " has resigned from " + companyName + "!");
						PlayerData.data.set("Business." + p.getName(), null);
						PlayerData.data.set("Businesses." + companyName, null);
						PlayerData.saveData();
						CompanyCraft.chat.setPlayerSuffix(p, PlayerJoin.defaultComp);
						return true;
						} else {
						return false;
						}
						} else {
						p.sendMessage(ChatColor.RED + "You don't have a business! Try creating one first.");
						return false;
						}
					}
			}
		}
		
		
		return false;
	}
	
	

}
