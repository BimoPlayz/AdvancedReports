package me.bimoplayz.advancedreports.common.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class BukkitStorageFile implements PluginFile<FileConfiguration> {
	
	  private final AdvancedReports plugin;
	  
	  private String name;	  
	  private File file;  
	 
	  private FileConfiguration config;
	  
	  public BukkitStorageFile(String label, AdvancedReports plugin) {
	    this.name = label;
	    this.plugin = plugin;
	    setup();
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	  
	  private void setup() {
	    this.file = new File(this.plugin.getDataFolder().getPath() + File.separator + this.name + ".yml");
	    this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
	    save();
	  }
	  
	  public void reload() {
	    setup();
	  }
	  
	  public FileConfiguration getConfig() {
	    return this.config;
	  }
	  
	  public void save() {
	    try {
	      this.config.save(this.file);
	    } catch (IOException iOException) {
	      iOException.printStackTrace();
	    } 
	  }
	}
