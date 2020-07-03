package me.bimoplayz.advancedreports.bukkit.events;

import java.util.Date;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.bimoplayz.advancedreports.bukkit.commands.subcommands.PlayerReport;
import me.bimoplayz.advancedreports.bukkit.features.MainGUI;
import me.bimoplayz.advancedreports.bukkit.features.ManagePlayersGUI;

public class ManagePlayersMenuEvent implements Listener {
	
	private MainGUI menu;
	private ManagePlayersGUI managePlayersMenu;
	private PlayerReport playerReport;
	private PlayerMuteEvent playerMute;
	
	public ManagePlayersMenuEvent() {
		menu = new MainGUI(null);
		managePlayersMenu = new ManagePlayersGUI(null);
		playerReport = new PlayerReport(null);
		playerMute = new PlayerMuteEvent();
	}
	
	private static Player PLAYER;
	private Server targetServer = playerReport.getTarget().getServer();
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
	
		if (!event.getInventory().equals(managePlayersMenu.getInventory())) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			
			if (event.getView().getType() == InventoryType.PLAYER) {
				return;
			}
			
			String banReason = ChatColor.translateAlternateColorCodes('&', "Breaking Server Rules!");
			Date expireTime = new Date(30000);
	
			switch(event.getSlot()) {
			case 11:
				player.teleport(playerReport.getTarget().getLocation());
				player.updateInventory();
				break;
			case 13:
				Bukkit.getBanList(Type.NAME).addBan(playerReport.getTarget().getName(), banReason, expireTime, player.getName());
				playerReport.getTarget().kickPlayer("banReason");
				player.updateInventory();
				break;
			case 15:
				playerMute.onTargetChat(null);
				player.updateInventory();
				break;
			case 25:
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&aReports &8>> &7Connecting to" + " " + targetServer.getName() + " (" + targetServer.getBukkitVersion() + ")"));
				//player Connect to target's server
				player.updateInventory();
				break;
			case 31:
				player.kickPlayer("Kicked by Administrator");
				player.updateInventory();
				break;
			case 48:
				menu.openInventory(player);
				player.updateInventory();
				break;
			case 49:
				player.updateInventory();
				break;
			case 50:
				menu.openInventory(player);
				player.updateInventory();
				break;
			case 53:
				menu.openInventory(player);
				player.updateInventory();
				break;
			default:
				player.updateInventory();
	        	break;
			}
		}
	}
	
	public Player getPlayer() {
		return PLAYER;
	}
	
	public void setPlayer(Player player) {
		PLAYER = player;
	}
}
