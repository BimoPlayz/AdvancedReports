package me.bimoplayz.advancedreports.bukkit.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.bimoplayz.advancedreports.bukkit.commands.CommandInterface;

public class Help implements CommandInterface {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', 
    			"&8&m+--------------&r &8< &aAdvancedReports &8> &m--------------+\n"
    		    + "&r \n"
    			+ "&8- &a/report help &8» &7Shows this help page\n"
    			+ "&8- &a/report player &2<&aplayer&2> &8» &7Reports a player\n"
    			+ "&8- &a/report menu &8» &7Shows the Main GUI\n"
    			+ "&8- &a/report reload &8» &7Reloads AdvancedReports's config.yml\n"
    	        + "&8- &a/report version &8» &7View the version of AdvancedReports\n"
    	        + "&8- &a/report dev &8» &7View the developer of AdvancedReports\n"
    	        + "&r \n"
    	        + "&2 <> &8- &7Arguments\n"
    	        + "&2 [] &8- &7Optional\n"
    			+ "&8&m+-----------------------------------------------+"));

        return true;
	}
}
