package org.dss.er.commands;

import org.bukkit.GameMode;
import org.bukkit.Sound;
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
				if(p.hasPermission("essentials.gamemode") || p.hasPermission("essentials.*") || p.isOp()==true) {
					if(args.length == 1) {
						if(args[0].contains("su") || args[0].contains("0")) {
							p.setGameMode(GameMode.SURVIVAL);
							p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aGamemode changed to &f&lSURVIVAL"));
							return false;
						}
						if(args[0].contains("c") || args[0].contains("1")) {
							p.setGameMode(GameMode.CREATIVE);
							p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aGamemode changed to &f&lCREATIVE"));
							return false;
						}
						if(args[0].contains("a") || args[0].contains("2")) {
							p.setGameMode(GameMode.ADVENTURE);
							p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aGamemode changed to &f&lADVENTURE"));
							return false;
						}
						if(args[0].contains("sp") || args[0].contains("3")) {
							p.setGameMode(GameMode.SPECTATOR);
							p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aGamemode changed to &f&lSPECTATOR"));
							return false;
						} else {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lCorrect scheme of command usage /gm survival/creative/adventure/spectator"));
							return false;
						}
					}
					if(args.length <1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lToo less arguments!!!"));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lCorrect scheme of command usage /gm survival/creative/adventure/spectator"));
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 100, 0);
						return false;
					}
					if(args.length >1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lToo much arguments!!!"));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lCorrect scheme of command usage /gm survival/creative/adventure/spectator"));
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 100, 0);
						return false;
					}
				}
				else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lYou don't have enough permissions to do it!!!"));
					return false;
				}
			} else {
				sender.sendMessage("You are console. Consoles can't change their gamemode");
				return false;
			}
		}
		return false;
	}

}
