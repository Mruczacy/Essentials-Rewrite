package org.dss.er.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class broadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("broadcast") || cmd.getName().equalsIgnoreCase("bc")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.*") || p.hasPermission("essentials.broadcast") || p.isOp()==true) {
					if(args.length >=1) {
						String message = "";
						for(String s : args) {
							message = message + s + " ";
						}
						Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
						List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
						for(Player l: list) {
							l.playSound(l.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 0);
						}
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
						return false;
					}
					else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lTOO LESS ARGUMENTS, CORRECT SCHEME OF COMMAND USAGE /BROADCAST <MESSAGE>"));
						return false;
					}
				}
			}
			else {
				if(args.length >=1) {
					String message = "";
					for(String s : args) {
						message = message+s + " ";
					}
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&4&lConsole says: " + message));
					List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
					for(Player l: list) {
						l.playSound(l.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 0);
					}
					return false;
				}
				else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lTOO LESS ARGUMENTS, CORRECT SCHEME OF COMMAND USAGE /BROADCAST <MESSAGE>"));
					return false;
				}
			}
		}
		return false;
	}
}
