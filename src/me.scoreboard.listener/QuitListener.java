package me.scoreboard.listener;
 
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
 
import me.scoreboard.api.SBManager;
 
public class QuitListener implements Listener {
   
   
   
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
 
        for(Player all : Bukkit.getOnlinePlayers()) {
            SBManager.setScoreBoard(all);
        }
    }
 
}
