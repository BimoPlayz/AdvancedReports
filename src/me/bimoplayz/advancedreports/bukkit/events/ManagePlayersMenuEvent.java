package me.bimoplayz.advancedreports.bukkit.events;

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
	
	public ManagePlayersMenuEvent() {
		menu = new MainGUI(null);
		managePlayersMenu = new ManagePlayersGUI(null);
		playerReport = new PlayerReport(null);
	}
	
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
	
			switch(event.getSlot()) {
			case 11:
				player.teleport(playerReport.getTarget().getLocation());
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
}
