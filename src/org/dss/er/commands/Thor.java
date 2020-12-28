package org.dss.er.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Thor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("thor")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.*")||p.hasPermission("essentials.thor")||p.isOp()==true) {
					if(args.length ==0) {
						p.getWorld().strikeLightning(p.getTargetBlock(null, 15).getLocation());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou used lightning power!!!"));
						return false;
					}
					if(args.length==1) {
						Player p1 = (Player) Bukkit.getPlayer(args[0]);
						p1.getWorld().strikeLightning(p1.getLocation());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou have feed on&f&l " + args[0]));
						p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou were attacked with lightning by&f&l " + p.getName()));
						return false;
					}
					if(args.length >1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lToo many arguments, but..."));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lI'll try to execute this command"));
						Player p1 = (Player) Bukkit.getPlayer(args[0]);
						p1.getWorld().strikeLightning(p1.getLocation());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou have feed on&f&l " + args[0]));
						p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou were attacked with lightning by&f&l " + p.getName()));
						return false;
					}
				}else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou don't have permission to do this"));
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 100, 0);
					return false;
				}
			}else {
				if(args.length <1) {
					sender.sendMessage("Do you want to attack the robot?");
					return false;
				}
				if(args.length >1) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lToo many arguments, but..."));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lI'll try to execute this command"));
					Player p1 = (Player) Bukkit.getPlayer(args[0]);
					p1.getWorld().strikeLightning(p1.getLocation());
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou have feed on&f&l " + args[0]));
					p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "You were attacked by lightning by console."));
					return false;
				}
				else {
					Player p1 = (Player) Bukkit.getPlayer(args[0]);
					p1.getWorld().strikeLightning(p1.getLocation());
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou have feed on&f&l " + args[0]));
					p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "You were attacked with lightning by console."));
					return false;
				}
			}
		}
		return false;
	}

}
