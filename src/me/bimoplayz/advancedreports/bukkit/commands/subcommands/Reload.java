package me.bimoplayz.advancedreports.bukkit.commands.subcommands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;
import me.bimoplayz.advancedreports.bukkit.commands.CommandInterface;

public class Reload implements CommandInterface{

	AdvancedReports plugin;
	public Reload (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("advancedreports.reload")) {
			try {
				plugin.reloadConfig();
				List<String> messages = plugin.getConfig().getStringList("messages.reload-success");
				for (String s : messages) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + s));
				}
			} 
			catch(Exception e) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.reload-fail")));
			}
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.no-permission")));
		}
		return false;
	}
}
