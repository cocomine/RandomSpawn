package com.cocopixelmc.RandomSpawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import io.netty.util.internal.ThreadLocalRandom;

public class Death implements Listener {

	private final Main plugin;
	
	public Death(Main plugin){
	    this.plugin=plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
		
		if(plugin.getConfig().getString("SpawnWorld") != null){
			//System.out.println("work");//debug
			Player player = e.getEntity();
			//Player player = e.getPlayer();
		
			World world = Bukkit.getWorld(plugin.getConfig().getString("SpawnWorld"));
			int X = ThreadLocalRandom.current().nextInt(-2999998,2999998);
			int Z = ThreadLocalRandom.current().nextInt(-2999998,2999998);
			int Y = world.getHighestBlockYAt(X, Z);
			Location location = new Location(world, X, Y, Z);
		
			//System.out.println(X+","+Y+","+Z);//debug
			//System.out.println(location);//debug
			//System.out.println(world.getBiome(X, Z));//debug
			//System.out.println(player);//debug
		
			if(!(world.getBiome(X, Z).equals(Biome.OCEAN) || world.getBiome(X, Z).equals(Biome.DEEP_OCEAN))){
				player.setBedSpawnLocation(location, true);
			}else{
				onPlayerDeath(e);
			}
		}
	}
}
