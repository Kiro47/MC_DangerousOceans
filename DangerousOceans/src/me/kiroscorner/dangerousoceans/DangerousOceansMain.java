package me.kiroscorner.dangerousoceans;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.kiroscorner.dangerousoceans.utils.FileManager;

public class DangerousOceansMain extends JavaPlugin {
	
	public void onEnable() {
		FileManager.getInstance().setup(getThisPlugin());
		saveDefaultConfig();
		
		Bukkit.getLogger().log(Level.INFO, "Enabling DangerousOceans, version : " + FileManager.getInstance().getDesc().getVersion());
		
		Bukkit.getServer().getPluginManager().registerEvents(new SpawnCatching(), this);
		getCommand("dango").setExecutor(new PrimaryCommand());
	}
	
	public void onDisable() {
		
	}
	
	public Plugin getThisPlugin() {
		return Bukkit.getPluginManager().getPlugin(this.getName().replace("Main", ""));
	}
}
