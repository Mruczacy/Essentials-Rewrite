package org.dss.er.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.fly") || p.hasPermission("essentials.*") || p.isOp()== true) {
					if(args.length == 1) {
						if(args[0].contains("on")) {
							p.setAllowFlight(true);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lLATANIE ZOSTALO WLACZONE"));
						}
						if(args[0].contains("off")) {
							p.setAllowFlight(false);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lLATANIE ZOSTALO WYLACZONE"));
						}
					}
					if(args.length >0) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lZLA ILOSC ARGUMENTOW"));
					}
					if(args.length <0) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lZLA ILOSC ARGUMENTOW"));
					}
				}else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lBRAK UPRAWNIEN SMIECIU"));
				}
			}
			
		}
		return false;
	}

}
