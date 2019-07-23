package me.scoreboard.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.scoreboard.Main;
import me.scoreboard.api.SBManager;
 
public class JoinListener implements Listener {
   
   
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
       
        SBManager.setScoreBoard(p);
        JavaPlugin.getPlugin(Main.class).updateScoreboard(p);
        
//        for(Player all : Bukkit.getOnlinePlayers()) {
//            SBManager.setScoreBoard(all);
//        }
    }
 
}
