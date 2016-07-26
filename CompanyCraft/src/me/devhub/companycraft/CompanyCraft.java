package me.devhub.companycraft;

import java.util.logging.Logger;

import me.devhub.companycraft.data.PlayerData;
import me.devhub.companycraft.data.Util;
import me.devhub.companycraft.state.BusinessState;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class CompanyCraft extends JavaPlugin {
	
	public BusinessState state;
	Util util;
	PlayerData data;
	
	Player p;
	
    private static final Logger log = Logger.getLogger("Minecraft");
    public static Economy econ = null;
    public static Permission perms = null;
    public static Chat chat = null;
	
    @Override
	public void onEnable() {
		util = new Util(this);
		util.setupListeners();
		util.setupCommands();
		data = new PlayerData(this);
		data.createConfig();
		
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
       setupChat();
	}
	
	  private boolean setupEconomy() {
	        if (getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	        }
	        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	        if (rsp == null) {
	            return false;
	        }
	        econ = rsp.getProvider();
	        log.info("VAULT HOOKED!");
	        return econ != null;
	    }
	    
	    private boolean setupChat() {
	        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
	        chat = rsp.getProvider();
	        return chat != null;
	    }
	    
	    private boolean setupPermissions() {
	        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
	        perms = rsp.getProvider();
	        return perms != null;
	    }
	
	public void onDisable() {
		
	}

}
