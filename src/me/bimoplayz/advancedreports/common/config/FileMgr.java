package me.bimoplayz.advancedreports.common.config;

import java.util.HashMap;
import java.util.Map;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;
import me.bimoplayz.advancedreports.common.AdvancedReportsPlugin;

public class FileMgr {
	
	  private final AdvancedReportsPlugin plugin;
	  
	  private Map<String, PluginFile<?>> files;
	  
	  public FileMgr(AdvancedReportsPlugin plugin) {
	    this.plugin = plugin;
	    this.files = new HashMap<>();
	  }
	  
	  public PluginFile<?> addFile(String label, FileType fileType) {
	    if (label == null)
	      throw new IllegalArgumentException("The file name cannot be null!"); 
	    if (fileType == FileType.BUKKIT_STORAGE) {
	      BukkitStorageFile bukkitStorageFile = new BukkitStorageFile(label, (AdvancedReports)this.plugin);
	      this.files.put(label, bukkitStorageFile);
	      return bukkitStorageFile;
	    } 
	    if (fileType == FileType.BUKKIT_CONFIG) {
	      BukkitConfigFile bukkitConfigFile = new BukkitConfigFile(label, (AdvancedReports)this.plugin);
	      this.files.put(label, bukkitConfigFile);
	      return bukkitConfigFile;
	    }  
	    throw new IllegalArgumentException("The FileType cannot be null!");
	  }
	  
	  @SuppressWarnings("rawtypes")
	  public void reloadFile(String label) {
	    PluginFile pluginFile = this.files.get(label);
	    if (pluginFile != null) {
	      pluginFile.reload();
	    } else {
	      throw new IllegalArgumentException("Specified file doesn't exist!");
	    } 
	  }
	  
	  public void reloadAll() {
	    for (String str : this.files.keySet())
	      reloadFile(str); 
	  }
	  
	  public enum FileType {
	    BUKKIT_STORAGE, BUKKIT_CONFIG;
	  }
}
