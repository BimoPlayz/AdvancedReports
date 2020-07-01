package me.bimoplayz.advancedreports.bukkit.commands;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class CommandHandler implements CommandExecutor {

	AdvancedReports plugin;
	public CommandHandler (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	private static HashMap<String, CommandInterface> commands = new HashMap<String, CommandInterface>();
	
	public void register(String name, CommandInterface cmd) {
		
		commands.put(name, cmd);
	}
	
	public boolean exists(String name) {
		
		return commands.containsKey(name);
	}
	
	public CommandInterface getExecutor(String name) {
		
		return commands.get(name);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

			if(args.length == 0) {
				getExecutor("advancedreports").onCommand(sender, cmd, label, args);
				return true;
			}
			if(args.length > 0) {
				if(exists(args[0])) {
					getExecutor(args[0]).onCommand(sender, cmd, label, args);
					return true;
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.subcommand")));
					return true;
				}
			} 
		return false;
	}
}