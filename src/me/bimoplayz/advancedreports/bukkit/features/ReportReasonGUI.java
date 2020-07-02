package me.bimoplayz.advancedreports.bukkit.features;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class ReportReasonGUI {
	
	AdvancedReports plugin;
	public ReportReasonGUI (AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	private static Inventory INV;
	private static String META;
	
	public void createMenu() {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("menu.title")));
		
		ItemStack item = new ItemStack(Material.ENDER_PEARL);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&eTeleport"));
		item.setItemMeta(meta);
		inv.setItem(10, item);
		
		item = new ItemStack(Material.ANVIL);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4Ban"));
		item.setItemMeta(meta);
		inv.setItem(11, item);
		
		item = new ItemStack(Material.PAPER);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6Mute"));
		item.setItemMeta(meta);
		inv.setItem(12, item);
		
		item = new ItemStack(Material.WRITABLE_BOOK);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Comment"));
		item.setItemMeta(meta);
		inv.setItem(13, item);
		
		item = new ItemStack(Material.STONE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5YEAH BITCH"));
		item.setItemMeta(meta);
		inv.setItem(14, item);
		
		item = new ItemStack(Material.WRITABLE_BOOK);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Comment"));
		item.setItemMeta(meta);
		inv.setItem(15, item);
		
		item = new ItemStack(Material.STONE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5YEAH BITCH"));
		item.setItemMeta(meta);
		inv.setItem(16, item);
		
		setInventory(inv);
		setReason(meta.getDisplayName());
	}
	
	//- Inventory Getter/Setter/Opener Methods
	public Inventory getInventory() {
		return INV;
	}
	
	public void setInventory(Inventory inv) {
		INV = inv;
	}
	
	public void openInventory(Player player) {
		player.openInventory(INV);
	}
	
	//- Reason Getter/Setter/ Methods
	public String getReason() {
		return META;
	}
	
	public void setReason(String metaDisplayName) {
		META = metaDisplayName;
	}
}
