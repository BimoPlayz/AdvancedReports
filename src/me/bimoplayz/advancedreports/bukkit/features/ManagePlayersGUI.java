package me.bimoplayz.advancedreports.bukkit.features;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class ManagePlayersGUI {
	
	AdvancedReports plugin;
	public ManagePlayersGUI (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	private static Inventory INV;
	
	public void createMenu() {
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.title")));
		
		ItemStack item = new ItemStack(Material.ENDER_PEARL);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&eTeleport"));
		item.setItemMeta(meta);
		inv.setItem(11, item);
		
		item = new ItemStack(Material.ANVIL);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4Ban"));
		item.setItemMeta(meta);
		inv.setItem(13, item);
		
		item = new ItemStack(Material.PAPER);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6Mute"));
		item.setItemMeta(meta);
		inv.setItem(15, item);
		
		item = new ItemStack(Material.WRITABLE_BOOK);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Comment"));
		item.setItemMeta(meta);
		inv.setItem(19, item);
		
		item = new ItemStack(Material.STONE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5YEAH BITCH"));
		item.setItemMeta(meta);
		inv.setItem(21, item);
		
		item = new ItemStack(Material.STONE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&eDelete"));
		item.setItemMeta(meta);
		inv.setItem(23, item);
		
		item = new ItemStack(Material.HOPPER);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5Server"));
		item.setItemMeta(meta);
		inv.setItem(25, item);
		
		item = new ItemStack(Material.FEATHER);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cKick"));
		item.setItemMeta(meta);
		inv.setItem(29, item);
		
		item = new ItemStack(Material.REDSTONE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cKick"));
		item.setItemMeta(meta);
		inv.setItem(31, item);
		
		item = new ItemStack(Material.WRITTEN_BOOK);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.solved-reports")));
		item.setItemMeta(meta);
		inv.setItem(33, item);
		
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
