package me.bimoplayz.advancedreports.common.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.bimoplayz.advancedreports.bukkit.AdvancedReports;

public class SQLGetter {
	
	private AdvancedReports plugin;
	public SQLGetter(AdvancedReports plugin) {
		this.plugin = plugin;
	}
	
	public void createTable() {
		PreparedStatement ps;
		try {
			ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS reportsData "
		            + "(NAME VARCHAR(100),UUID VARCHAR(100),POINTS INT(100),PRIMARY KEY (NAME))");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createPlayer(Player player) {
		try {
			UUID uuid = player.getUniqueId();
			if (!exists(uuid)) {
				PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT IGNORE INTO reportsData"  
			            + "(NAME,UUID) VALUES (?,?)");
				ps2.setString(1, player.getName());
				ps2.setString(2, uuid.toString());
				ps2.executeUpdate();
				
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean exists(UUID uuid) {
		try {
			PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM reportsData WHERE UUID=?");
			ps.setString(1, uuid.toString());
			
			ResultSet results = ps.executeQuery();
			if (results.next()) {
				//player is found
				return true;
			} else {
				//player not found
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void addPoints(UUID uuid, int points) {
		try {
			PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE reportsData SET POINTS=? WHERE UUID=?");
			ps.setInt(1, (getPoints(uuid) + points));
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getPoints(UUID uuid) {
		try {
			PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT POINTS FROM reportsData WHERE UUID=?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			int points = 0;
			if (rs.next()) {
				points = rs.getInt("POINTS");
				return points;
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void emptyTable() {
		try {
			PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("TRUNCATE reportsData");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeData(UUID uuid) {
		try {
			PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("DELETE FROM reportsData WHERE UUID=?");
			ps.setString(1, uuid.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
