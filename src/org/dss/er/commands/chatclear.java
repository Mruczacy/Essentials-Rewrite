package org.dss.er.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class chatclear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("chatclear")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.*")||p.hasPermission("essentials.chatclear")||p.isOp()==true) {
					if(args.length ==1) {
						for(int i=0; i<250; i++) {
							Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', ""));
						}
						List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
						for(Player l: list) {
							l.playSound(l.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 100, 0);
						}
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 0);
						Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&1&l"+args[0]+" &c&lcleared the chat"));
					}
					if(args.length ==0) {
						for(int i=0; i<250; i++) {
							Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', ""));
						}
						List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
						for(Player l: list) {
							l.playSound(l.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 100, 0);
						}
						Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&1&lSOMEONE &c&lcleared the chat"));
					}
					if(args.length >1) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lTOO LESS ARGUMENTS"));
					}
				}
			}
			else {
				if(args.length ==1) {
					for(int i=0; i<250; i++) {
						Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', ""));
					}
					List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
					for(Player l: list) {
						l.playSound(l.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 100, 0);
					}
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&1&l" + args[0] + " &c&lcleared the chat"));
				}
				if(args.length ==0) {
					for(int i=0; i<250; i++) {
						Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', ""));
					}
					List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
					for(Player l: list) {
						l.playSound(l.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 100, 0);
					}
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&1&lSOMEONE &c&lcleared the chat"));
				}
				if(args.length >1) {
					sender.sendMessage("&c&lTOO LESS ARGUMENTS");
				}
			}
		}
		return false;
	}

}
