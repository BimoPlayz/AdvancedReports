package me.bimoplayz.advancedreports.bukkit.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.bimoplayz.advancedreports.bukkit.features.MainGUI;
import me.bimoplayz.advancedreports.bukkit.features.SolvedReportsGUI;

public class SolvedReportsMenuClickEvent implements Listener{

	private MainGUI menu;
	private SolvedReportsGUI solvedReportsMenu;
	
	public SolvedReportsMenuClickEvent() {
		menu = new MainGUI(null);
		solvedReportsMenu = new SolvedReportsGUI(null);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
	
		if (!event.getInventory().equals(solvedReportsMenu.getInventory())) {
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
	        	break;
			}
		}
	}
}
