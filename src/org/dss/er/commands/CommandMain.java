package org.dss.er.commands;

import org.dss.er.Main;

public class CommandMain {

	public static void RegisterCommands() {
		Main.getInstance().getCommand("gm").setExecutor(new Gm());
		Main.getInstance().getCommand("raid").setExecutor(new Raid());
		Main.getInstance().getCommand("fly").setExecutor(new Fly());
		Main.getInstance().getCommand("broadcast").setExecutor(new Broadcast());
		Main.getInstance().getCommand("chatclear").setExecutor(new Chatclear());
		Main.getInstance().getCommand("feed").setExecutor(new Feed());
		Main.getInstance().getCommand("heal").setExecutor(new Heal());
		Main.getInstance().getCommand("ereload").setExecutor(new Reload());
		Main.getInstance().getCommand("thor").setExecutor(new Thor());
	}
}
