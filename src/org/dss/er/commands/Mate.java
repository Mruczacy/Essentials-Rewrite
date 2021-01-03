package org.dss.er.commands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.dss.er.data.MYSQL;

public class Mate implements CommandExecutor {

	public Map<Player, Player> Mate_add_request = new HashMap<Player, Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("Mate")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args.length < 1) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lToo LESS arguments, at least one required"));
				}
				if(args.length > 2) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lToo MUCH arguments, but..."));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lI'll try to execute this command"));
				}
				if(args.length == 1) {
					Player p1 = (Player) Bukkit.getPlayer(args[0]);
					Mate_add_request.put(p, p1);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lTeammate request sended to " + p1.getName()));
					p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l" + p.getName() + " wants to be your teammate"));
					p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lType /mate accept" + p.getName() + "to accept"));
					p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lType /mate deny" + p.getName() + "to deny"));
				}
				if(args.length == 2) {
					Player p1 = (Player) Bukkit.getPlayer(args[1]);
					if(args[0]=="add") {
						Mate_add_request.put(p, p1);
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lTeammate request sended to " + p1.getName()));
						p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l" + p.getName() + " wants to be your teammate"));
						p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lType /mate accept" + p.getName() + "to accept"));
						p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lType /mate deny" + p.getName() + "to deny"));
						
					}
					if(args[0]=="rem" || args[0]=="remove") {
						Connection conn;
						try {
							conn = DriverManager.getConnection(MYSQL.serverUrl, MYSQL.username, MYSQL.password);
							PreparedStatement stmt = conn.prepareStatement("DELETE * FROM teammate WHERE uuid1=" + p.getUniqueId().toString() + " AND uuid2="+ p1.getUniqueId().toString());
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lDeleted"));
							p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lDeleted"));
							stmt.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					/*if(args[0]=="info") {
						
					}
					if(args[0]=="list") {
						//maybe add some privacy options to this?
					}*/
					if(args[0]=="accept") {
						if(Mate_add_request.containsKey(p1)) {
							Mate_add_request.remove(p1, p);
							Connection conn;
							try {
								conn = DriverManager.getConnection(MYSQL.serverUrl, MYSQL.username, MYSQL.password);
								PreparedStatement stmt = conn.prepareStatement("INSERT INTO teammate(uuid1, uuid2, ffused) VALUES (?, ?, ?)");
								stmt.setString(1, p1.getUniqueId().toString());
								stmt.setString(2, p.getUniqueId().toString());
								stmt.setInt(3, 0);
								stmt.executeUpdate();
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lInserted"));
								p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lInserted"));
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
						}
					}
					if(args[0]=="deny") {
						if(Mate_add_request.containsKey(p1)) {
							Mate_add_request.remove(p1, p);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lDenied request"));
							p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYour request has been denied"));
						}
						else {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lThere is no request connected with this player"));
						}
					}
				}
			}
		}
		return false;
	}

	
}
