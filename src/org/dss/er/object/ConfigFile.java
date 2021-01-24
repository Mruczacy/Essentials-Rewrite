package org.dss.er.object;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.dss.er.Main;

public class ConfigFile {

	private File FileVar;
	private String configname;
    private FileConfiguration FileConfig;
    
    public ConfigFile(File FileVar, String configname, FileConfiguration FileConfig) {
    	this.FileVar = FileVar;
    	this.configname = configname;
    	this.FileConfig = FileConfig;
    }
    
    public FileConfiguration getCustomConfig() {
        return this.FileConfig;
    }
    
    public void Init() {
    	this.FileVar = new File(Main.getInstance().getDataFolder(), this.configname);
        if (!this.FileVar.exists()) {
            this.FileVar.getParentFile().mkdirs();
            Main.getInstance().saveResource(this.configname, false);
         }

        this.FileConfig= new YamlConfiguration();
        try {
            this.FileConfig.load(FileVar);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

	public File getFileVar() {
		return FileVar;
	}

	public void setFileVar(File fileVar) {
		FileVar = fileVar;
	}

	public String getConfigname() {
		return configname;
	}

	public void setConfigname(String configname) {
		this.configname = configname;
	}

	public FileConfiguration getFileConfig() {
		return FileConfig;
	}

	public void setFileConfig(FileConfiguration fileConfig) {
		FileConfig = fileConfig;
	}
}
