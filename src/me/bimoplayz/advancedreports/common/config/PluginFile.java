package me.bimoplayz.advancedreports.common.config;

public interface PluginFile<CT> {
	
	String getName();
	void reload();
	
	CT getConfig();
    void save();
}
