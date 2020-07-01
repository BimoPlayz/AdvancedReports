package me.bimoplayz.advancedreports.bukkit.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.bimoplayz.advancedreports.bukkit.features.ActiveReportsGUI;
import me.bimoplayz.advancedreports.bukkit.features.MainGUI;
import me.bimoplayz.advancedreports.bukkit.features.ManagePlayersGUI;

public class ActiveReportsMenuClickEvent implements Listener {
	
	private MainGUI menu;
	private ActiveReportsGUI activeReportsMenu;
	private ManagePlayersGUI managePlayersMenu;
	
	public ActiveReportsMenuClickEvent() {
		menu = new MainGUI(null);
		activeReportsMenu = new ActiveReportsGUI(null);
		managePlayersMenu = new ManagePlayersGUI(null);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
	
		if (!event.getInventory().equals(activeReportsMenu.getInventory())) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			
			if (event.getView().getType() == InventoryType.PLAYER) {
				return;
			}
	
			switch(event.getSlot()) {
			case 45:
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
				managePlayersMenu.openInventory(player);
				player.updateInventory();
	        	break;
			}
		}
	}
}
