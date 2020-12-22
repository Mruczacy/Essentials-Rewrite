package org.dss.er.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Reload implements CommandExecutor {
	
    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Essentials-Rewrite");
    final FileConfiguration config = plugin.getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ereload")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("essentials.reload") || p.hasPermission("essentials.*") || p.isOp()==true){
					plugin.reloadConfig();
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aConfiguration file reloaded."));
					return false;
				}else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lYou don't have enough permissions to do it!!!"));
					return false;
				}
			}
		}
		return false;
	}

}
