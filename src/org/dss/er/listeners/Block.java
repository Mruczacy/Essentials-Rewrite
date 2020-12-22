package org.dss.er.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.dss.er.Main;

public class Block implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(Main.raidbool==false) {
			e.setCancelled(false);
			return;
		}
		if(Main.raidbool==true) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lAdministration enabled ANTI-RAID system. In this case you can't destroy and place blocks"));
			return;
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(Main.raidbool==false) {
			e.setCancelled(false);
			return;
		}
		if(Main.raidbool==true) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lAdministration enabled ANTI-RAID system. In this case you can't destroy and place blocks"));
			return;
		}
	}
	
	@EventHandler
	public void onEndermanBlockPick(EntityChangeBlockEvent e) {
		if(Main.raidbool==true) {
			e.setCancelled(true);
		}
	}
}
