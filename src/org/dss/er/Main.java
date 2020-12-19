package org.dss.er;

import org.bukkit.plugin.java.JavaPlugin;
import org.dss.er.commands.gm;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("gm").setExecutor(new gm());
	}
}
