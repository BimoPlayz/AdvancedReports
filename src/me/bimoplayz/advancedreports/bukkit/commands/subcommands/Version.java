package me.bimoplayz.advancedreports.bukkit.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;
import me.bimoplayz.advancedreports.bukkit.commands.CommandInterface;

public class Version implements CommandInterface {

	AdvancedReports plugin;
	public Version (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender.hasPermission("advancedreports.version")) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + "&7Current version running: &av" + plugin.getConfig().getString("version")));
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.no-permission")));
		}
		return false;
	}
}
