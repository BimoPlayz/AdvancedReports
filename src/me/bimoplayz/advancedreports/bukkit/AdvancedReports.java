package me.bimoplayz.advancedreports.bukkit;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.bimoplayz.advancedreports.bukkit.commands.CommandHandler;
import me.bimoplayz.advancedreports.bukkit.commands.ReportCommand;
import me.bimoplayz.advancedreports.bukkit.commands.TabComplete;
import me.bimoplayz.advancedreports.bukkit.commands.subcommands.Dev;
import me.bimoplayz.advancedreports.bukkit.commands.subcommands.Help;
import me.bimoplayz.advancedreports.bukkit.commands.subcommands.Menu;
import me.bimoplayz.advancedreports.bukkit.commands.subcommands.PlayerReport;
import me.bimoplayz.advancedreports.bukkit.commands.subcommands.Reload;
import me.bimoplayz.advancedreports.bukkit.commands.subcommands.Version;
import me.bimoplayz.advancedreports.bukkit.events.ActiveReportsMenuClickEvent;
import me.bimoplayz.advancedreports.bukkit.events.ManagePlayersMenuEvent;
import me.bimoplayz.advancedreports.bukkit.events.MenuClickEvent;
import me.bimoplayz.advancedreports.bukkit.events.ReportReasonMenuClickEvent;
import me.bimoplayz.advancedreports.bukkit.events.SolvedReportsMenuClickEvent;
import me.bimoplayz.advancedreports.bukkit.features.ActiveReportsGUI;
import me.bimoplayz.advancedreports.bukkit.features.MainGUI;
import me.bimoplayz.advancedreports.bukkit.features.ManagePlayersGUI;
import me.bimoplayz.advancedreports.bukkit.features.ReportReasonGUI;
import me.bimoplayz.advancedreports.bukkit.features.SolvedReportsGUI;
import me.bimoplayz.advancedreports.bukkit.net.UpdateNotifier;
import me.bimoplayz.advancedreports.common.database.MySQL;
import me.bimoplayz.advancedreports.common.database.SQLGetter;

public class AdvancedReports extends JavaPlugin {

	public MySQL SQL;
	public SQLGetter data;
		
    AdvancedReports plugin;
	
	public void registerCommands() {
		
		CommandHandler handler = new CommandHandler(plugin);
		
		//- Main Command
		handler.register("advancedreports", new ReportCommand(plugin));
		
		//- Argument Commands
		handler.register("help", new Help());	
		handler.register("player", new PlayerReport(plugin));
		handler.register("menu", new Menu(plugin));
		handler.register("version", new Version(plugin));
		handler.register("dev", new Dev());
		handler.register("reload", new Reload(plugin));
		getCommand("advancedreports").setExecutor(handler);
		
		//- TabCompleter
		getCommand("advancedreports").setTabCompleter(new TabComplete()); 	
	}
	
	@Override
	public void onEnable() {
		
		//- #===============^===============#
		//                MySQL
		//          Connection | Data
		
		this.SQL = new MySQL();
		this.data = new SQLGetter(this);
		
			try {
				SQL.connect();
			} catch (ClassNotFoundException | SQLException e) {
				//Login info is incorrect
				//They are not using a database
				//e.printStackTrace();
				Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "[AdvancedReports] Database not connected"));
			}
			
			if (SQL.isConnected()) {
				Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "[AdvancedReports] Database is connected"));
				data.createTable();
				//this.getServer().getPluginManager().registerEvents(this, this);
			}
			
		    //- #===============^===============#
			
			//- #===============^===============#
			//            PlaceholderAPI
			//                Check         
			
			if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
				//do something
				Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "[AdvancedReports] PlaceholderAPI Found"));
				Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "[AdvancedReports] Successfuly hooked into PlaceholderAPI"));			
			} else {
				//do something
			}
			
			//- #===============^===============#	
			
			plugin = this;
		
		this.registerCommands();
        this.saveDefaultConfig();
        
        //- Menu-Creation Section
		MainGUI menu = new MainGUI(plugin);
		menu.createMenu();
		ActiveReportsGUI activeReportsMenu = new ActiveReportsGUI(plugin);
		activeReportsMenu.createMenu();
		SolvedReportsGUI solvedReportsMenu = new SolvedReportsGUI(plugin);
		solvedReportsMenu.createMenu();
		ManagePlayersGUI managePlayersMenu = new ManagePlayersGUI(plugin);
		managePlayersMenu.createMenu();
		ReportReasonGUI reportReasonMenu = new ReportReasonGUI(plugin);
		reportReasonMenu.createMenu();
		
        //-Event-Registering Section
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new MenuClickEvent(), this);
        pluginManager.registerEvents(new ActiveReportsMenuClickEvent(), this);
        pluginManager.registerEvents(new SolvedReportsMenuClickEvent(), this);
        pluginManager.registerEvents(new ManagePlayersMenuEvent(), this);
        pluginManager.registerEvents(new ReportReasonMenuClickEvent(), this);
        
		//- UpdateNotifier
        Logger logger = this.getLogger();
        
        new UpdateNotifier(this, 12345).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("There is not a new update available.");
            } else {
                logger.info("There is a new update available.");
            }
        }); 
	}

	@Override
	public void onDisable() {
		SQL.disconnect();
		Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "[AdvancedReports] Database disconnected"));
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		return false;
	}

}
