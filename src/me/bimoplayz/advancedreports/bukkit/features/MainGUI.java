package me.bimoplayz.advancedreports.bukkit.features;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class MainGUI {

	AdvancedReports plugin;
	public MainGUI (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	private static Inventory INV;
	
	public void createMenu() {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.title")));
		
		ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.active-reports")));
		item.setItemMeta(meta);
		inv.setItem(11, item);
		
		item = new ItemStack(Material.CAMPFIRE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5YEAH BITCH"));
		item.setItemMeta(meta);
		inv.setItem(13, item);
		
		item = new ItemStack(Material.EMERALD_BLOCK);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.solved-reports")));
		item.setItemMeta(meta);
		inv.setItem(15, item);
		
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
