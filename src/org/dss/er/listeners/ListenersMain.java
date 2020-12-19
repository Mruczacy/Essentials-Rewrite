package org.dss.er.listeners;

import org.bukkit.Bukkit;
import org.dss.er.Main;

public class ListenersMain {

	
	public static void  RegisterListeners() {
		Bukkit.getPluginManager().registerEvents(new Block(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new EntityExplode(), Main.getInstance());
	}
}
