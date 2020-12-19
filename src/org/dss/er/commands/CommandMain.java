package org.dss.er.commands;

import org.dss.er.Main;

public class CommandMain {

	public static void RegisterCommands() {
		Main.getInstance().getCommand("gm").setExecutor(new gm());
		Main.getInstance().getCommand("raid").setExecutor(new raid());
		Main.getInstance().getCommand("fly").setExecutor(new fly());
		Main.getInstance().getCommand("broadcast").setExecutor(new broadcast());
		Main.getInstance().getCommand("chatclear").setExecutor(new chatclear());
	}
}
