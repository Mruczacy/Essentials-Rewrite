package org.dss.er.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandExecutor;
import org.dss.er.Main;

public class CommandMain {

	public static List<String> commands = new ArrayList<String>();
	public static void RegisterCommands() {
		RegisterOneCommand("gm", new Gm());
		RegisterOneCommand("raid", new Raid());
		RegisterOneCommand("fly", new Fly());
		RegisterOneCommand("broadcast", new Broadcast());
		RegisterOneCommand("chatclear", new Chatclear());
		RegisterOneCommand("feed", new Feed());
		RegisterOneCommand("heal", new Heal());
		RegisterOneCommand("ereload", new Reload());
		RegisterOneCommand("thor", new Thor());
		RegisterOneCommand("mate", new Mate());
		RegisterOneCommand("kick", new Kick());
		/* Main.getInstance().getCommand("gm").setExecutor(new Gm());
		commands.add("gm"); */
		try {
			RegisterCommandsInConfig();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void RegisterOneCommand(String name, CommandExecutor executor) {
		Main.getInstance().getCommand(name).setExecutor(executor);
		commands.add(name);
	}
	
	public static void RegisterCommandsInConfig() throws IOException {
		for(String s: commands ) {
			org.dss.er.data.yamls.YamlMain.CommandsYaml.getCustomConfig().set(s, true);
			org.dss.er.data.yamls.YamlMain.CommandsYaml.getCustomConfig().save(org.dss.er.data.yamls.YamlMain.CommandsYaml.getConfigname());;
		}
	}
}
