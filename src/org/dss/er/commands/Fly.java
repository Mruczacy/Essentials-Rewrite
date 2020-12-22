package org.dss.er.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.fly") || p.hasPermission("essentials.*") || p.isOp()== true) {
					if(args.length == 1) {
						if(args[0].contains("on")) {
							p.setAllowFlight(true);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lFLYING ENABLED"));
							p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
							return false;
						}
						if(args[0].contains("off")) {
							p.setAllowFlight(false);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lFLYING DISABLED"));
							p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
							return false;
						}
					}
					if(args.length >1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lTOO MUCH ARGUMENTS"));
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
						return false;
					}
					if(args.length <1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lTOO LESS ARGUMENTS"));
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
						return false;
					}
				}else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYOU DON'T HAVE PERMISSION TO DO THIS"));
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
					return false;
				}
			}
			
		}
		return false;
	}

}
