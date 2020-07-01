package me.bimoplayz.advancedreports.bukkit.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.bimoplayz.advancedreports.common.database.SQLGetter;

public class SQLJoinEvent implements Listener {
	
	public SQLGetter data;
	
	@EventHandler
	public void onJoinSQL(PlayerJoinEvent event) {
			Player player = event.getPlayer();
			data.createPlayer(player);
	}
}
