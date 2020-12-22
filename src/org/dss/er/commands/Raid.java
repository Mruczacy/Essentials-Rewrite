package org.dss.er.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Raid implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("raid")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args.length ==1) {
					if(args[0].contains("on")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAnti-raid secure enabled"));
						org.dss.er.Main.raidbool=true;
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, 100, 0);
						return false;
					}
					if(args[0].contains("of")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAnti-raid secure disabled"));
						org.dss.er.Main.raidbool=false;
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 100, 0);
						return false;
					}
					else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lCorrect first argument is on/off"));
						return false;
					}
				}
				if(args.length < 1) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lToo less arguments!!!"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lCorrect scheme of command usage /raid <on/off>"));
					return false;
				}
				if(args.length > 1) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lToo much arguments!!!"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lCorrect scheme of command usage /raid <on/off>"));
					return false;
				}
			} else {
				if(args.length ==1) {
					if(args[0] == "on") {
						org.dss.er.Main.raidbool=true;
						sender.sendMessage("Anti-raid secure enabled");
						return false;
					}
					if(args[0]== "off") {
						org.dss.er.Main.raidbool=false;
						sender.sendMessage("Anti-raid secure disabled");
						return false;
					}
					else {
						sender.sendMessage("Correct first argument is on/off");
						return false;
					}
				}
				if(args.length < 1) {
					sender.sendMessage("Too less arguments Correct scheme of command usage /raid <on/off>");
					return false;
				}
				if(args.length > 1) {
					sender.sendMessage("Too much arguments Correct scheme of command usage /raid <on/off>");
					return false;
				}
			}
		}
		return false;
	}

}
