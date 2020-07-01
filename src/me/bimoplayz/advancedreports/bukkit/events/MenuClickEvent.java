package me.bimoplayz.advancedreports.bukkit.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.bimoplayz.advancedreports.bukkit.features.ActiveReportsGUI;
import me.bimoplayz.advancedreports.bukkit.features.MainGUI;
import me.bimoplayz.advancedreports.bukkit.features.SolvedReportsGUI;

public class MenuClickEvent implements Listener {

	private MainGUI menu;
	private ActiveReportsGUI activeReportsMenu;
	private SolvedReportsGUI solvedReportsMenu;
	
	public MenuClickEvent() {
		menu = new MainGUI(null);
		activeReportsMenu = new ActiveReportsGUI(null);
		solvedReportsMenu = new SolvedReportsGUI(null);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		if (!event.getInventory().equals(menu.getInventory())) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			
			if (event.getView().getType() == InventoryType.PLAYER) {
				return;
			}
			
			switch(event.getSlot()) {
			case 11:
				activeReportsMenu.openInventory(player);
				player.updateInventory();
				break;
			case 13:
				//player.closeInventory();
				player.updateInventory();
				break;
			case 15:
				solvedReportsMenu.openInventory(player);
				player.updateInventory();
				break;
	        default:
	        	break;
			}	
		}
	}
}
