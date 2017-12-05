package com.cocopixelmc.RandomSpawn;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener{

	@Override
    public void onEnable() {
		getLogger().info("Wellcome to use~~~");
		
		saveDefaultConfig();
		reloadConfig();
		getLogger().info("save config done");
		
		new Death(this);
		getCommand("randomspawn").setExecutor(new Cmd(this));
		getLogger().info("Londing Done!");
	}
	
	@Override
    public void onDisable() {
    	getLogger().info("GoodBye~~~");
    }
}
