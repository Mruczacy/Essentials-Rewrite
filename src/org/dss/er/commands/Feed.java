package org.dss.er.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("feed")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.*")||p.hasPermission("essentials.feed")||p.isOp()==true) {
					if(args.length ==0) {
						p.setFoodLevel(20);
						p.playSound(p.getLocation(), Sound.ENTITY_FOX_EAT, 100, 0);
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou have feed yourself"));
						return false;
					}
					if(args.length==1) {
						Player p1 = (Player) Bukkit.getPlayer(args[0]);
						p1.setFoodLevel(20);
						p1.playSound(p1.getLocation(), Sound.ENTITY_FOX_EAT, 100, 0);
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou have feed " + args[0]));
						p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou had been feed by" + p.getName()));
						return false;
					}
					if(args.length >1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lToo many arguments, but..."));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lI'll try to execute this command"));
						Player p1 = (Player) Bukkit.getPlayer(args[0]);
						p1.setFoodLevel(20);
						p1.playSound(p1.getLocation(), Sound.ENTITY_FOX_EAT, 100, 0);
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou have feed " + args[0]));
						p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou had been feed by" + p.getName()));
						return false;
						
					}
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou don't have permission to do this"));
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 100, 0);
					return false;
				}
			} else {
				if(args.length <1) {
					sender.sendMessage("Have you ever tried to imagine how to feed a robot?");
					return false;
				}
				if(args.length >1) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lToo many arguments, but..."));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lI'll try to execute this command"));
					Player p1 = (Player) Bukkit.getPlayer(args[0]);
					p1.setFoodLevel(20);
					p1.playSound(p1.getLocation(), Sound.ENTITY_FOX_EAT, 100, 0);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou have feed " + args[0]));
					p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou had been feed by console"));
					return false;
				}
				else {
					Player p1 = (Player) Bukkit.getPlayer(args[0]);
					p1.setFoodLevel(20);
					p1.playSound(p1.getLocation(), Sound.ENTITY_FOX_EAT, 100, 0);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou have feed " + args[0]));
					p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou had been feed by console"));
					return false;
				}
			}
		}
		return false;
	}

	
}
