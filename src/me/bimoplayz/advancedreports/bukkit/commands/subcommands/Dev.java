package me.bimoplayz.advancedreports.bukkit.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.bimoplayz.advancedreports.bukkit.commands.CommandInterface;

public class Dev implements CommandInterface {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"                    &2&l»&a&l» &aAdvancedReports &a&l«&2&l«\n"
				+ "                &7This plugin is developed\n"
				+ "                           &7by &aBimoPlayz&7.\n"
				+ "                    &2&l»&a&l» &aAdvancedReports &a&l«&2&l«"));
		return false;
	}
}
