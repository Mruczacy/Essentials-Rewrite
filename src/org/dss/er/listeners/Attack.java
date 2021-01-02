package org.dss.er.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.dss.er.Main;
import org.dss.er.data.MYSQL;


public class Attack implements Listener {

	public void onAttack(EntityDamageEvent e) {
		if(Main.raidbool==true) {
			e.setCancelled(true);
			return;
		}
		if(e.getEntity() instanceof Player || e.getCause() == DamageCause.ENTITY_ATTACK) {
			
		}
	}
	public void onAttack(EntityDamageByEntityEvent e) {
		if(Main.raidbool==true) {
			e.setCancelled(true);
			return;
		}
		if(e.getEntity() instanceof Player || e.getDamager() instanceof Player) {
			String uuid1 = e.getEntity().getUniqueId().toString();
			String uuid2 = e.getDamager().getUniqueId().toString();
			Connection conn;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + MYSQL.dbName, MYSQL.username, MYSQL.password);
				Statement stmt= conn.createStatement();
				ResultSet rs = null;
				if(stmt.execute("SELECT * FROM `teammate` WHERE (uuid1="+uuid1+" AND uuid2="+uuid2+") OR (uuid1="+uuid2+" AND uuid2="+uuid1+")")) {
					rs = stmt.getResultSet();
				}
				while(rs.next()) {
					int i = rs.getInt("ffused");
					e.setCancelled(true);
					e.getEntity().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou cannot damage your teammate u retard"));
					e.getDamager().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou cannot damage your teammate u retard"));
					stmt = conn.createStatement();
					i+=1;
					stmt.executeUpdate("UPDATE `teammate` SET ffused=" + String.valueOf(i) + " WHERE (uuid1="+uuid1+" AND uuid2="+uuid2+") OR (uuid1="+uuid2+" AND uuid2="+uuid1+")");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
