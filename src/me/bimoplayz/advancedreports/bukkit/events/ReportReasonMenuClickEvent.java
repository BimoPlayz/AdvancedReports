package me.bimoplayz.advancedreports.bukkit.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;
import me.bimoplayz.advancedreports.bukkit.commands.subcommands.PlayerReport;
import me.bimoplayz.advancedreports.bukkit.features.ActiveReportsGUI;
import me.bimoplayz.advancedreports.bukkit.features.ReportReasonGUI;

public class ReportReasonMenuClickEvent implements Listener {
	
	private ReportReasonGUI reportReasonMenu;
	private ActiveReportsGUI activeReportsMenu;
	private PlayerReport playerReport;
	
	AdvancedReports plugin;
	public ReportReasonMenuClickEvent (AdvancedReports plugin) {
		this.plugin = plugin;
	}

	public ReportReasonMenuClickEvent() {
		reportReasonMenu = new ReportReasonGUI(null);
		activeReportsMenu = new ActiveReportsGUI(null);
		playerReport = new PlayerReport(null);
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
				ItemStack item = new ItemStack(Material.PLAYER_HEAD);
				ItemMeta meta = item.getItemMeta();
				List<String> lores = new ArrayList<String>();
				lores.add(reportReasonMenu.getReason());
				meta.setLore(lores);
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a" + playerReport.getTarget().getName()));
				item.setItemMeta(meta);
				activeReportsMenu.getInventory().setItem(1, item);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 11:
				item = new ItemStack(Material.PLAYER_HEAD);
				meta = item.getItemMeta();
				List<String> lores1 = new ArrayList<String>();
				lores1.add(reportReasonMenu.getReason());
				meta.setLore(lores1);
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a" + playerReport.getTarget().getName()));
				item.setItemMeta(meta);
				activeReportsMenu.getInventory().setItem(1, item);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 12:
				item = new ItemStack(Material.PLAYER_HEAD);
				meta = item.getItemMeta();
				List<String> lores2 = new ArrayList<String>();
				lores2.add(reportReasonMenu.getReason());
				meta.setLore(lores2);
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a" + playerReport.getTarget().getName()));
				item.setItemMeta(meta);
				activeReportsMenu.getInventory().setItem(1, item);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 13:
				item = new ItemStack(Material.PLAYER_HEAD);
				meta = item.getItemMeta();
				List<String> lores3 = new ArrayList<String>();
				lores3.add(reportReasonMenu.getReason());
				meta.setLore(lores3);
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a" + playerReport.getTarget().getName()));
				item.setItemMeta(meta);
				activeReportsMenu.getInventory().setItem(1, item);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 14:
				item = new ItemStack(Material.PLAYER_HEAD);
				meta = item.getItemMeta();
				List<String> lores4 = new ArrayList<String>();
				lores4.add(reportReasonMenu.getReason());
				meta.setLore(lores4);
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a" + playerReport.getTarget().getName()));
				item.setItemMeta(meta);
				activeReportsMenu.getInventory().setItem(1, item);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 15:
				item = new ItemStack(Material.PLAYER_HEAD);
				meta = item.getItemMeta();
				List<String> lores5 = new ArrayList<String>();
				lores5.add(reportReasonMenu.getReason());
				meta.setLore(lores5);
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a" + playerReport.getTarget().getName()));
				item.setItemMeta(meta);
				activeReportsMenu.getInventory().setItem(1, item);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
			case 16:
				item = new ItemStack(Material.PLAYER_HEAD);
				meta = item.getItemMeta();
				List<String> lores6 = new ArrayList<String>();
				lores6.add(reportReasonMenu.getReason());
				meta.setLore(lores6);
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a" + playerReport.getTarget().getName()));
				item.setItemMeta(meta);
				activeReportsMenu.getInventory().setItem(1, item);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
				player.updateInventory();
				break;
	        default:
	        	break;
			}	
		}
	}
}

