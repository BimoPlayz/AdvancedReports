package me.bimoplayz.advancedreports.bukkit.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;
import me.bimoplayz.advancedreports.bukkit.features.ReportReasonGUI;

public class ReportReasonMenuClickEvent implements Listener {
	
	private ReportReasonGUI reportReasonMenu;
	
	AdvancedReports plugin;
	public ReportReasonMenuClickEvent (AdvancedReports plugin) {
		this.plugin = plugin;
	}

	public ReportReasonMenuClickEvent() {
		reportReasonMenu = new ReportReasonGUI(null);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		if (!event.getInventory().equals(reportReasonMenu.getInventory())) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			
			if (event.getView().getType() == InventoryType.PLAYER) {
				return;
			}	
			
			switch(event.getSlot()) {
			case 10:
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',
						  plugin.getConfig().getString("prefix")));
				player.updateInventory();
				break;
			case 11:
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 12:
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 13:
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 14:
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 15:
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 16:
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
	        default:
	        	break;
			}	
		}
	}
}

