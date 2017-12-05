package com.cocopixelmc.RandomSpawn;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class Cmd implements Listener, CommandExecutor {

	private final Main plugin;


	public Cmd(Main plugin) {
		this.plugin=plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("randomspawn")){
			
			if (sender.hasPermission("RandomSpawn.reload")){
				if(args.length == 0) {
    				sender.sendMessage(ChatColor.RED + "/randomspawn reload --> reload Config");
    		    }else
    		    if(args.length >= 1){
    		    	if(args[0].equalsIgnoreCase("reload")){
    		    		plugin.reloadConfig();
    		    		sender.sendMessage(ChatColor.GREEN + "Reload Done");
    		    	}else{
    		    		sender.sendMessage(ChatColor.RED + "/randomspawn reload --> reload Config");
    		    	}
    		    }
    		}else{
    			sender.sendMessage(ChatColor.RED + "You not have permission");
    		}
			return true;
		}
		return false;
	}
}
