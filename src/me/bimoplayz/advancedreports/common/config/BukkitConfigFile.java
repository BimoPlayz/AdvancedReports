package me.bimoplayz.advancedreports.common.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class BukkitConfigFile implements PluginFile<FileConfiguration> {
	
	  private final AdvancedReports plugin;

	  private String name;
	  private File file;
	 
	  private FileConfiguration fileConfiguration;
	  private FileConfiguration defaultFileConfiguration;
	  
	  public BukkitConfigFile(String label, AdvancedReports plugin) {
	    this.name = label + ".yml";
	    this.plugin = plugin;
	    setup();
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	  
	  private void setup() {
	    this.file = new File(this.plugin.getDataFolder(), this.name);
	    try {
	      InputStreamReader inputStreamReader = new InputStreamReader(this.plugin.getResource(this.name));
	      try {
	        this.defaultFileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(inputStreamReader);
	        inputStreamReader.close();
	      } catch (Throwable throwable) {
	        try {
	          inputStreamReader.close();
	        } catch (Throwable throwable1) {
	          throwable.addSuppressed(throwable1);
	        } 
	        throw throwable;
	      } 
	    } catch (IOException iOException) {
	      iOException.printStackTrace();
	    } 
	    save();
	  }
	  
	  public void reload() {
	    this.fileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
	  }
	  
	  public FileConfiguration getConfig() {
	    if (this.fileConfiguration == null)
	      reload(); 
	    return this.fileConfiguration;
	  }
	  
	  public void save() {
	    if (!this.file.exists())
	      this.plugin.saveResource(this.name, false); 
	  }
	  
	  public FileConfiguration getDefaultConfig() {
	    return this.defaultFileConfiguration;
	  }
	}
