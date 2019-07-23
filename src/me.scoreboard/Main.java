package me.scoreboard;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.scoreboard.api.SBManager;
import me.scoreboard.commands.HelpScoreboardCommand;
import me.scoreboard.commands.ReloadScoreboardCommand;
import me.scoreboard.commands.StaffScoreboardCommand;
import me.scoreboard.listener.JoinListener;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {

    private static Main m;
    private Permission perms = null;
    public static ArrayList<UUID> staffspelers = new ArrayList<UUID>();

    public void onEnable() {
        m = this;
        getConfig().options().copyDefaults(true);
        saveConfig();

        registerCommands();
        registerEvents();
        
        if (!setupPermissions()) {
        	Bukkit.getLogger().severe("[StarSurvivalSB] Vault is niet gevonden! Installeer Vault om deze plugin te gebruiken.");
        	getServer().getPluginManager().disablePlugin(this);
        	return;
        }
    }

    /**
     * Verkrijgt de Main class.
     * @return m De Main class
     */
    public static Main getInstance() {
        return m;
    }
    
    public Permission getPermission() {
    	return this.perms;
    }

    public void updateScoreboard(Player p) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Main.class), new Runnable() {

            @Override
            public void run() {
            	if (staffspelers.contains(p.getUniqueId())) {
            		SBManager.setAdminScoreBoard(p);
            	} else {
            		SBManager.setScoreBoard(p);
            	}
            }
        }, 0, 20);

    }

    public void registerCommands() {
        getCommand("reloadscoreboard").setExecutor(new ReloadScoreboardCommand());
        getCommand("helpscoreboard").setExecutor(new HelpScoreboardCommand());
        getCommand("staff").setExecutor(new StaffScoreboardCommand());
    }

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        // Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
    }

    public static void Error(String message) {
        Bukkit.getServer().getLogger().info("[CustomScoreboard][Error] " + message);
    }
    
    private boolean setupPermissions() {
        RegisteredServiceProvider < Permission > rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
}

