package org.dss.er;

import org.bukkit.plugin.java.JavaPlugin;
import org.dss.er.commands.CommandMain;
import org.dss.er.listeners.ListenersMain;

public class Main extends JavaPlugin {
	public static boolean raidbool=false;
	private static Main instance;
    public Main() {
        instance = this;
    }
    public static Main getInstance() {
        return instance;
    }	
	@Override
	public void onEnable() {
		CommandMain.RegisterCommands();
		ListenersMain.RegisterListeners();
	}
}