package org.dss.er.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class gm implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gm")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.gamemode") || p.hasPermission("essentials.*") || p.isOp()== true) {
					if(args.length == 1) {
						if(args[0] == "0") {
							p.setGameMode(GameMode.SURVIVAL);
						}
						if(args[0] == "1") {
							p.setGameMode(GameMode.SURVIVAL);
						}
						if(args[0] == "2") {
							p.setGameMode(GameMode.SURVIVAL);
						}
						if(args[0] == "3") {
							p.setGameMode(GameMode.SURVIVAL);
						}
					}
					if(args.length <=1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lZa malo argumentow!!!"));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lPoprawny schemat uzycia komendy to /gm 1/2/3/0"));
					}
					if(args.length >=1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lZa duzo argumentow!!!"));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lPoprawny schemat uzycia komendy to /gm 1/2/3/0"));
					}
				}
			}
		}
		return false;
	}

}
