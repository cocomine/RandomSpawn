package com.cocopixelmc.playerdeath.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.cocopixelmc.playerdeath.main;

import me.badbones69.crazyauctions.api.ShopType;
import me.badbones69.crazyauctions.events.AuctionListEvent;
import me.badbones69.crazyauctions.events.AuctionNewBidEvent;
import me.badbones69.crazyauctions.events.AuctionWinBidEvent;

public class CA implements Listener {

	@SuppressWarnings("unused")
	private final main plugin;

	public CA(main plugin){
	    this.plugin=plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
    public void onAuctionList(AuctionListEvent e){
		
		Player player = e.getPlayer();
		ItemStack item = e.getItem();
		
		if(e.getShopType().equals(ShopType.BID)){
			if(item.getItemMeta().getDisplayName() != null){
				String itemName = item.getItemMeta().getDisplayName();
				Bukkit.broadcastMessage(ChatColor.AQUA+"【精靈商場】"+ChatColor.GOLD+player.getName()+" 將 "+itemName+ChatColor.GOLD+" 放在精靈商城雙拍賣了趕快來競價! 底價 $"+e.getPrice());
			}else{
				String itemName = item.getData().getItemType().name();
				Bukkit.broadcastMessage(ChatColor.AQUA+"【精靈商場】"+ChatColor.GOLD+player.getName()+" 將 "+itemName+ChatColor.GOLD+" 放在精靈商城雙拍賣了趕快來競價! 底價 $"+e.getPrice());
			}
		}
	}
	
	@EventHandler
    public void onAuctionNewBid(AuctionNewBidEvent e){
		
		Player player = e.getPlayer();
		ItemStack item = e.getItem();
		
		if(item.getItemMeta().getDisplayName() != null){
			String itemName = item.getItemMeta().getDisplayName();
			Bukkit.broadcastMessage(ChatColor.AQUA+"【精靈商場】"+ChatColor.GOLD+player.getName()+" 競價了 "+itemName+ChatColor.GOLD+" 趕快來競價! 現在的價格是 $"+e.getBid());
		}else{
			String itemName = item.getData().getItemType().name();
			Bukkit.broadcastMessage(ChatColor.AQUA+"【精靈商場】"+ChatColor.GOLD+player.getName()+" 競價了 "+itemName+ChatColor.GOLD+" 趕快來競價! 現在的價格是 $"+e.getBid());
		}
		
	}
	
	@EventHandler
    public void onAuctionWinBid(AuctionWinBidEvent e){
		
		Player player = e.getPlayer();
		ItemStack item = e.getItem();
		
		if(item.getItemMeta().getDisplayName() != null){
			String itemName = item.getItemMeta().getDisplayName();
			Bukkit.broadcastMessage(ChatColor.AQUA+"【精靈商場】"+ChatColor.GOLD+player.getName()+" 成功競價了 "+itemName+ChatColor.GOLD+" 最後的競價價錢是 $"+e.getBid());
		}else{
			String itemName = item.getData().getItemType().name();
			Bukkit.broadcastMessage(ChatColor.AQUA+"【精靈商場】"+ChatColor.GOLD+player.getName()+" 成功競價了 "+itemName+ChatColor.GOLD+" 最後的競價價錢是 $"+e.getBid());
		}
		
	}
}
