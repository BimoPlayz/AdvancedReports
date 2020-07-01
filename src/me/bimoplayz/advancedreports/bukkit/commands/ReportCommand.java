package me.bimoplayz.advancedreports.bukkit.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class ReportCommand implements CommandInterface {

	AdvancedReports plugin;
	public ReportCommand (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("advancedreports.help")) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.info")));
			return true;
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.no-permission")));
		}

		return false;
	}
}
