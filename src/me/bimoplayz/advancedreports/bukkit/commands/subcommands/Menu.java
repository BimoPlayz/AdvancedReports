package me.bimoplayz.advancedreports.bukkit.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;
import me.bimoplayz.advancedreports.bukkit.commands.CommandInterface;
import me.bimoplayz.advancedreports.bukkit.features.MainGUI;

public class Menu implements CommandInterface {
	
	AdvancedReports plugin;
	public Menu (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
        	Player player = (Player) sender;
        	MainGUI menu = new MainGUI(plugin);
        	if (player.hasPermission("advancedreports.menu")) {
        		menu.openInventory(player);
        		return true;
        	} else {
        		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.no-permission")));
        	}
        } else {
        	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.non-player")));
        }
		return false;
	}
}
