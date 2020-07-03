package me.bimoplayz.advancedreports.bukkit.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;
import me.bimoplayz.advancedreports.bukkit.commands.subcommands.PlayerReport;

@SuppressWarnings("deprecation")
public class PlayerMuteEvent implements Listener {
	
	public AdvancedReports plugin;
	public PlayerReport playerReport;
	public ManagePlayersMenuEvent managePlayers;

	public PlayerMuteEvent(AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	public PlayerMuteEvent() {
		playerReport = new PlayerReport(null);
		managePlayers = new ManagePlayersMenuEvent();
	}
	
	private boolean targetIsMuted = false;	
	private Player target = playerReport.getTarget();
	
	@EventHandler
	public void onTargetChat(PlayerChatEvent event) {
		if (managePlayers.getPlayer().hasPermission("advancedreports.mute")) {
				event.setCancelled(true);
				targetIsMuted = true;
				onTargetMessage();
		} else {
			managePlayers.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', 
					plugin.getConfig().getString("prefix") + plugin.getConfig().getString("messages.no-permission")));
		}
	}
	
	public void onTargetMessage() {
		if (targetIsMuted == true) {
			target.sendMessage(ChatColor.translateAlternateColorCodes('&',
					plugin.getConfig().getString("prefix") + "&cYou are muted by staff."));
		}
	}
}
