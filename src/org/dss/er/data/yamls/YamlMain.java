package org.dss.er.data.yamls;

import org.dss.er.object.ConfigFile;

public class YamlMain {

	public static ConfigFile CommandsYaml;
	
	public void YamlInit() {
		 ConfigFile CommandsYaml = new ConfigFile(null, "Commands.yml", null);
		 CommandsYaml.Init();
	}
}
