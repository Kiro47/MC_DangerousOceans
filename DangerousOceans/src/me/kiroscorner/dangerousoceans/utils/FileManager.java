package me.kiroscorner.dangerousoceans.utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class FileManager {

	/**
	 * Unused Constructor, standards reasoning
	 */
	private FileManager() {
	}

	// Singular instance of file class, having multiple classes change files is
	// bad.
	static FileManager instance = new FileManager();

	/**
	 * getInstance()
	 * 
	 * Retrieve static instance of class
	 * 
	 * @return Static instance of class
	 */
	public static FileManager getInstance() {
		return instance;
	}

	Plugin plugin;
	FileConfiguration config;
	File file;

	/**
	 * setup()
	 * 
	 * Sets up the FileManager on loading
	 * 
	 * @param plugin The plugin itself to be passed from onEnable()
	 */
	public void setup(Plugin plugin) {
		this.plugin = plugin;
		config = plugin.getConfig();
		file = new File(plugin.getDataFolder(), "config.yml");
	}

	/**
	 * reloadConfig()
	 * 
	 * Reloads the configuration file in memory with one on disk
	 */
	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(file);
	}

	/**
	 * 
	 * getDesc()
	 * 
	 * Retrieves plugin information 
	 * 
	 * @return Plugin information
	 */
	public PluginDescriptionFile getDesc() {
		return plugin.getDescription();
	}
}
