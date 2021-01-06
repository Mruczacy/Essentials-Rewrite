package org.dss.er.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kick")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.*")||p.hasPermission("essentials.heal")||p.isOp()==true) {	
					if(args.length==0) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lPlease specify a player!"));
						return false;
					}
					if(args.length==1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lPlease specify a reason!"));
						return false;
					}
					Player p1 = (Player) Bukkit.getPlayer(args[0]);
					if(p1 == null) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lNo such player could be found!"));
						return true;
					}
					p1.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&c&lYou got kicked from server by &f&l" + p.getName()));
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer &f" + p1.getName() + " has been kicked by &f" + p.getName()));
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 100, 0);
					return false;
				}
			}
		}
		return false;
	}

}
