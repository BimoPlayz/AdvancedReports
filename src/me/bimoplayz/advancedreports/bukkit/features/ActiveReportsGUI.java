package me.bimoplayz.advancedreports.bukkit.features;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class ActiveReportsGUI {
	
	AdvancedReports plugin;
	public ActiveReportsGUI (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	private static Inventory INV;
	
	public void createMenu() {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.title")));
		
		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta meta = item.getItemMeta();
		List<String> lores = new ArrayList<String>();
		lores.add(plugin.getConfig().getString("menu.report-reason"));
		lores.add("&fKillAura");
		meta.setLore(lores);
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.player-name") + "AsteiliaDev"));
		item.setItemMeta(meta);
		inv.setItem(0, item);
		
		item = new ItemStack(Material.HOPPER);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&eRemove all reports"));
		item.setItemMeta(meta);
		inv.setItem(45, item);
		
		item = new ItemStack(Material.ARROW);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l<<<"));
		item.setItemMeta(meta);
		inv.setItem(48, item);
		
		item = new ItemStack(Material.REDSTONE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Current Page: 1"));
		item.setItemMeta(meta);
		inv.setItem(49, item);
		
		item = new ItemStack(Material.ARROW);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l>>>"));
		item.setItemMeta(meta);
		inv.setItem(50, item);
		
		item = new ItemStack(Material.BARRIER);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.return-back")));
		item.setItemMeta(meta);
		inv.setItem(53, item);
		
		setInventory(inv);
	}
	
	public Inventory getInventory() {
		return INV;
	}
	
	public void setInventory(Inventory inv) {
		INV = inv;
	}
	
	public void openInventory(Player player) {
		player.openInventory(INV);
	}
}
