package me.bimoplayz.advancedreports.bukkit.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;
import me.bimoplayz.advancedreports.bukkit.commands.CommandInterface;
import me.bimoplayz.advancedreports.bukkit.features.ReportReasonGUI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class PlayerReport implements CommandInterface {
	
	private static Player TARGET;;
	
	AdvancedReports plugin;
	public PlayerReport (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player target = null;

		if (args.length == 2) {
			target = Bukkit.getPlayer(args[1]);
			if (target == null) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.null-player")));
			} else {
				Player player = (Player) sender;
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + "&2&n" + target.getName() + "&r " + plugin.getConfig().getString("messages.report")));
				ReportReasonGUI reportReasonMenu = new ReportReasonGUI(plugin);
				reportReasonMenu.openInventory(player);
				if (plugin.getConfig().getBoolean("settings.title-message") == true) {
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&7" + target.getName()+ " " + "&a&lREPORTED")));
				   
					setTarget(target);
				}
			}
		} else if (args.length == 1) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + "&7Usage: /report player <player_name>"));
		}
		return false;
	}
	
	public Player getTarget() {
		return TARGET;
	}
	
	public void setTarget(Player target) {
		TARGET = target;
	}
}
